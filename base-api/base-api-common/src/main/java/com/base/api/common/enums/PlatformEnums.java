package com.base.api.common.enums;

public enum PlatformEnums {

	/**IOS**/
	IOS(2, "IOS", 1),
	/**Android**/
	Android(1, "Android", 1),
	/**H5**/
	H5(3, "H5", 1),
	/**PC**/
	PC(4, "PC", 1),
	/**微信***/
	WEIXIN(5, "weixin", 1),
	/**未知**/
	OTHER(0, "other", 1);

	private int value;
	private String desc;
	private int type;

	private PlatformEnums(int value, String desc, int type) {
		this.value = value;
		this.desc = desc;
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public static PlatformEnums getClient(int deviceType){
		if(deviceType == PlatformEnums.IOS.getValue()){
			return PlatformEnums.IOS;
		}else if(deviceType == PlatformEnums.Android.getValue()){
			return PlatformEnums.Android;
		}else if(deviceType == PlatformEnums.PC.getValue()){
			return PlatformEnums.PC;
		}
		return PlatformEnums.H5;
	}
}
