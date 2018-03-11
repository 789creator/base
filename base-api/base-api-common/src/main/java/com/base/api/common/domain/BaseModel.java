package com.base.api.common.domain;

import com.base.api.common.enums.PlatformEnums;

public class BaseModel {
	private String ip;
	private String device;
	private String deviceType;
	private String channelSource;
	private String deviceId;
	private String pushId;
	private PlatformEnums clientSource;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getChannelSource() {
		return channelSource;
	}
	public void setChannelSource(String channelSource) {
		this.channelSource = channelSource;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getPushId() {
		return pushId;
	}
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public PlatformEnums getClientSource() {
		return clientSource;
	}

	public void setClientSource(PlatformEnums clientSource) {
		this.clientSource = clientSource;
	}
}
