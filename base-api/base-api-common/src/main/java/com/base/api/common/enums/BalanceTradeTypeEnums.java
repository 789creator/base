package com.base.api.common.enums;

/**
 * 余额操作类型
 */
public enum BalanceTradeTypeEnums {

	DEFAULT (0, "默认","DEF"),
    RECHARGE (1, "充值","CHR"),
    BUY (2, "购买","BUY"),
    WITHDRAW (3, "提现","WTH"),
    PROJECT_REPAYMENT (4, "项目还款","REP"),
	ACTIVITY(5, "活动奖励","AT"),//一般活动奖励
	PROJECT_PLUS(6,"加息","PU"),//加息券+项目加息一起
	INVITE_REWARD(7, "邀请好友奖励","IVT"),
    PROJECT_TAIL_REWARD (8, "尾单奖励","TAIL"),
    TRIAL_PROJECT_REPAY (9, "体验金项目还款","TREP");

	private int value;
	private String description;
	private String orderPrefix;

    BalanceTradeTypeEnums(int value, String description,String orderPrefix) {
		this.value = value;
		this.description = description;
		this.orderPrefix = orderPrefix;
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	public String getOrderPrefix() {
		return orderPrefix;
	}
}
