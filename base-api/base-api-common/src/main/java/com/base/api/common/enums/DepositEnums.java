package com.base.api.common.enums;

/**
 * 项目存管类型
 */
public enum DepositEnums {

		ALL (0, "不限定"),
		BF (1, "宝付"),
		RTF (2, "融托富");
		/**
		 * 值 Integer型
		 */
		private final int value;
		/**
		 * 描述 String型
		 */
		private final String description;

		DepositEnums(int value, String description) {
			this.value = value;
			this.description = description;
		}

		public int getValue() {
			return value;
		}

		public String getDescription() {
			return description;
		}

}
