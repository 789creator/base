package com.base.api.common.enums;

public enum ResCodeEnums {

	SUCCESS("返回成功",10000),
	ERROR("操作异常，请稍后再试", -10000),
	REQUEST_ERROR("啊呀，您的请求有些问题，请确认后再试", -2), 	
	APP_UPDATE("版本升级", 9999),
	//登录相关
	NO_LOGIN_ERROR("请先登录", 20000),
	VALID_CODE_ERROR("验证码错误", 20001),
	SIGN_ERROR("签名异常，请检查请求参数", 20002),

	//活动相关
	LUCK_DRAW("没有抽奖资格",40004),
	ACTIVITY_START("活动未开始",40001),
	ACTIVITY_END("活动已结束",40002);


	private String resMsg;
	private int resCode;

	ResCodeEnums(String resMsg, int resCode) {
		this.resMsg = resMsg;
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public int getResCode() {
		return resCode;
	}

}
