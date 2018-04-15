package com.base.api.server.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.base.api.common.constants.Constants;
import com.base.api.common.domain.ResultBody;
import com.base.api.common.web.model.TokenData;
import com.base.api.server.web.RequestParamsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserHandleInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(UserHandleInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		String name = method.getMethod().getName();
		TokenData usd = RequestParamsUtil.getSessionData(request);
		logger.info("UserHandleInterceptor:preHandle"+UserHandleInterceptor.class);
		return super.preHandle(request, response, handler);
	}
//
//	/**
//	 * 是否升级
//	 *
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws IOException
//	 */
//	public boolean isUpgrade(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String appVersion = request.getHeader(RequestHeaderEnums.REQ_HEADER_APP_VERSION.getHeader());
//		String client = request.getHeader(RequestHeaderEnums.REQ_HEADER_DEVICE_TYPE.getHeader());
//		if (StrUtils.isNotEmpty(client) && StrUtils.isNumeric(client)) {
//			int platform = Integer.parseInt(client);
//			if (platform == PlatformEnums.IOS.getValue()) {
//				if(appVersion.compareTo(ConfigUtil.getInstance().getSysVersion()) < 0){
//					ResultBody result = new ResultBody<>();
//					result.setResCode(-1008);
//					JSONObject upgrade = new JSONObject();
//					if (PlatformEnums.Android.getValue() == platform) {
//						upgrade.put("md5", ConfigUtil.getInstance().getSysAndroidMD5());
//						upgrade.put("download", ConfigUtil.getInstance().getSysAndroidDownURL());
//					} else if (PlatformEnums.IOS.getValue() == platform) {
//
//					}
//					upgrade.put("upgradeTips", ConfigUtil.getInstance().getUpgradeTips());
//					upgrade.put("title", "发现新版本"+ ConfigUtil.getInstance().getSysVersion());
//					upgrade.put("upgradeStatus", ConfigUtil.getInstance().getUpgradeStatus());
//					result.setResMsg(JSONObject.toJSONString(upgrade));
//					response.setCharacterEncoding(Constants.CHARSET_UTF8);
//					response.setContentType("application/json; charset=" + Constants.CHARSET_UTF8);
//					String jsonString = JSON.toJSONString(result);
//					ServletOutputStream outputStream = response.getOutputStream();
//					outputStream.write(jsonString.getBytes(Constants.CHARSET_UTF8));
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	/**
	 * 是否在维护
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public boolean isMaintainace(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ResultBody result = new ResultBody<>();
		result.setResCode(-9999);
		JSONObject jb = new JSONObject();
		jb.put("msg", "系统正在维护");
		jb.put("title", "系统维护");
		result.setResMsg(jb.toJSONString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		response.setContentType("application/json; charset=" + Constants.CHARSET_UTF8);
		String jsonString = JSON.toJSONString(result);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(jsonString.getBytes(Constants.CHARSET_UTF8));
		return true;
	}
}
