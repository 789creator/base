package com.base.api.server.web.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 资源授权
 * @author xiaohaizi
 * @date 2017年3月7日 下午5:47:21   
 *
 */
public class ResourceAuthHandleInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * handler
	 */
	private AsyncHandlerInterceptor handlerInterceptor[];
	
	/**
	 * annotationClass
	 */
	private Class annotationClass;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if(handlerMethod.getMethod().getAnnotation(annotationClass) != null || handlerMethod.getBeanType().getAnnotation(annotationClass) != null){
			return invokeHandle(request, response, handler);
		}
		return super.preHandle(request, response, handler);
	}

	private boolean invokeHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		for(AsyncHandlerInterceptor handlerInterceptor : handlerInterceptor){
			boolean isTrue = handlerInterceptor.preHandle(request, response, handler);
			if(!isTrue){
				return false;
			}
		}
		return true;
	}

	public void setHandlerInterceptor(AsyncHandlerInterceptor[] handlerInterceptor) {
		this.handlerInterceptor = handlerInterceptor;
	}

	public void setAnnotationClass(Class annotationClass) {
		this.annotationClass = annotationClass;
	}
	
}
