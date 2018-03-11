package com.base.api.server.web.interceptor;

import com.base.api.common.enums.ResCodeEnums;
import com.base.api.common.redis.util.MemberRedisUtil;
import com.base.api.common.web.model.MemberInfoDataRedis;
import com.base.api.common.web.model.TokenData;
import com.base.api.server.web.RequestParamsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户身份校验
 * @author xiaohaizi
 * @date   2017年3月9日 下午1:42:46
 */
public class TokenHandleInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private MemberRedisUtil memberRedisUtil;
	
	private Logger logger = LoggerFactory.getLogger(TokenHandleInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		TokenData sessionData = RequestParamsUtil.getSessionData(request);
		if(sessionData == null){
			RequestParamsUtil.resultData(response, ResCodeEnums.NO_LOGIN_ERROR);
			return false;
		}else{
//			MemberInfoDataRedis midr = memberRedisUtil.getMemberInfoData(sessionData.getId());
			//强制退出
			MemberInfoDataRedis midr = memberRedisUtil.getMemberInfoData(sessionData.getId(),sessionData.getClient());
			if(midr == null || midr.getMemberId() == null || !sessionData.checkToken(midr.getToken())){
				logger.info("强制退出:midr:"+midr.getToken());
				RequestParamsUtil.resultData(response, ResCodeEnums.NO_LOGIN_ERROR);
				return false;
			}
		}
		// logger.info("TokenHandleInterceptor:preHandle方法:"+TokenHandleInterceptor.class);
		return super.preHandle(request, response, handler);
	}
}
