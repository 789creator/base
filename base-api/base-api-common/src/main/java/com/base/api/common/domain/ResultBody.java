package com.base.api.common.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.base.api.common.enums.ResCodeEnums;
import com.base.api.common.utils.StrUtils;

import java.io.Serializable;

public class ResultBody<T> implements Serializable {
	private static final long serialVersionUID = 721027228290103397L;
	/**
	 * 返回对象
	 */
	private T data;

	/**
	 * 返回消息
	 */
	private String resMsg;

	/**
	 * 返回代码
	 */
	private int resCode = 1;
	
	
	@JSONField(serialize=false)
	private ResCodeEnums resCodeEnums;

	/**
	 * 需要执行的Action
	 */
	private String action;


	public ResultBody(){
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getResMsg() {
		if(resCodeEnums != null){
			return resCodeEnums.getResMsg();
		}
		if(StrUtils.isNotEmpty(resMsg) && resMsg.indexOf("exception") >= 0){
			resMsg = "业务处理异常";
		}
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public Integer getResCode() {
		if(resCodeEnums != null){
			return resCodeEnums.getResCode();
		}
		if(resCode != 1){
			return resCode;
		}
		if(StrUtils.isNotEmpty(getResMsg())){
			return -1;
		}
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	
	/**
	 * 是否成功
	 * @return
	 */
	@JSONField(serialize=false)
	public boolean isSuccess(){
		if(getResCode() < 0){
			return false;
		}
		return true;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
