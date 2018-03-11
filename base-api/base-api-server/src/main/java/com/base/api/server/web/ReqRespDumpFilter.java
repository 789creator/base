package com.base.api.server.web;

import com.base.api.common.ConfigUtil;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.util.Map;

//@WebFilter("/*")
public class ReqRespDumpFilter implements Filter {

    private static final Logger logger = Logger.getLogger(ReqRespDumpFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
            throws IOException, ServletException {
        if(ConfigUtil.getInstance().isDev()) {
            try {
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;

                StringBuilder sb = new StringBuilder();

                sb.append("---REQ----");
                sb.append(httpServletRequest.getRequestURI());
                sb.append("-----\n");

                Map<String, String[]> map = request.getParameterMap();
                for (Map.Entry<String, String[]> entry : map.entrySet()) {
                    sb.append(entry.getKey() + ":" + entry.getValue()[0] + "\n");
                }
                sb.append("-----\n");

                HttpServletResponseCopier responseCopier = new HttpServletResponseCopier(httpServletResponse);
                try {
                    chain.doFilter(request, responseCopier);
                    responseCopier.flushBuffer();
                } finally {
                    byte[] copy = responseCopier.getCopy();
                    sb.append(new String(copy, response.getCharacterEncoding()));
                }
                sb.append("\n------\n");

                logger.info(sb.toString());

            } catch (Throwable a) {
                logger.error(a);
            }
        }
    }


    @Override
    public void destroy() {
    }

    static  class ServletOutputStreamCopier extends ServletOutputStream {

        private OutputStream outputStream;
        private ByteArrayOutputStream copy;

        public ServletOutputStreamCopier(OutputStream outputStream) {
            this.outputStream = outputStream;
            this.copy = new ByteArrayOutputStream(1024);
        }

        @Override
        public void write(int b) throws IOException {
            outputStream.write(b);
            copy.write(b);
        }

        public byte[] getCopy() {
            return copy.toByteArray();
        }

    }

    static class HttpServletResponseCopier extends HttpServletResponseWrapper {

        private ServletOutputStream outputStream;
        private PrintWriter writer;
        private ServletOutputStreamCopier copier;

        public HttpServletResponseCopier(HttpServletResponse response) throws IOException {
            super(response);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            if (writer != null) {
                throw new IllegalStateException("getWriter() has already been called on this response.");
            }

            if (outputStream == null) {
                outputStream = getResponse().getOutputStream();
                copier = new ServletOutputStreamCopier(outputStream);
            }

            return copier;
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            if (outputStream != null) {
                throw new IllegalStateException("getOutputStream() has already been called on this response.");
            }

            if (writer == null) {
                copier = new ServletOutputStreamCopier(getResponse().getOutputStream());
                writer = new PrintWriter(new OutputStreamWriter(copier, getResponse().getCharacterEncoding()), true);
            }

            return writer;
        }

        @Override
        public void flushBuffer() throws IOException {
            if (writer != null) {
                writer.flush();
            } else if (outputStream != null) {
                copier.flush();
            }
        }

        public byte[] getCopy() {
            if (copier != null) {
                return copier.getCopy();
            } else {
                return new byte[0];
            }
        }

    }

}