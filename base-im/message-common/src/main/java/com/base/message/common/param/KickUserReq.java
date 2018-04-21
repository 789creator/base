package com.base.message.common.param;

import com.base.message.common.code.proto.IMBaseDefine;
import com.base.message.common.code.proto.IMBaseDefine;

public class KickUserReq {
	
	private long userId;
	private IMBaseDefine.ClientType userType;
	private IMBaseDefine.KickReasonType kickReasonType;	
	
	public IMBaseDefine.ClientType getUserType() {
		return userType;
	}
	public void setUserType(IMBaseDefine.ClientType userType) {
		this.userType = userType;
	}
	
	public IMBaseDefine.KickReasonType getKickReasonType() {
		return kickReasonType;
	}
	public void setKickReasonType(IMBaseDefine.KickReasonType kickReasonType) {
		this.kickReasonType = kickReasonType;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
	

}
