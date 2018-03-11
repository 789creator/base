package com.base.api.server.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.base.api.common.ConfigUtil;
import com.base.api.common.domain.ResultBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.Map;

public class PreHandleInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(UserHandleInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//System.out.println(">>>PreHandleInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）"+request.getRequestURI());

		if(!"/api/reloadConfig".equals(request.getRequestURI()) && ConfigUtil.getInstance().getConfigBoolValue("site.pause")){
			ResultBody body = new ResultBody();
			body.setResMsg("系统例行维护中，请半小时再试，感谢您的耐心与支持");
			response.setHeader("Content-type", "text/json;charset=UTF-8");
			response.getOutputStream().write(JSON.toJSONString(body).getBytes("UTF-8"));
			return false;
		}
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
	}
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		//System.out.println(">>>PreHandleInterceptor>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）"+request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println(">>>PreHandleInterceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）"+request.getRequestURI());
    }
}
