package com.base.api.common.domain;

public enum SysErrorCode {

	UNAUTHORIZED("-1001","用户未登录"),
	SIGN_ERROR("-1002","签名错误"),
	PAY_PASSWROD_ERROR("-1005", "交易密码错误"),
	NOT_PAY_PASSWROD_ERROR("-1006", "未设置交易密码"),
	PAY_PASSWROD_ENTER_NUMBER_ERROR("-1007", "交易密码次数超限"),
	APP_UPGRADE("-1008", "提示用户升级"),
	APP_SYSTEM_UPGRADE("-9999", "系统升级"),
	ACTION("-1009", "动作"),
	PAY_ERROR("-1003","支付错误，不关闭弹窗");
	
	private String errorCode;
	private String name;
	
	SysErrorCode(String errorCode, String name){
		this.errorCode = errorCode;
		this.name = name;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
