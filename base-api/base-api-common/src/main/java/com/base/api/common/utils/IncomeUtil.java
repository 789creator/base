package com.base.api.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeUtil {

	private static final BigDecimal year365 = new BigDecimal(365);
	
	// //计算给借款人利息，和收益计算不同是四舍五入处理
	public static BigDecimal getTotalInterest(BigDecimal totalAmount, int days, BigDecimal yearRate){
		BigDecimal tmp = totalAmount.multiply(BigDecimal.valueOf(days)).multiply(yearRate)
			.divide(year365.multiply(BigDecimal.valueOf(100)), 10, BigDecimal.ROUND_HALF_UP);
		return tmp.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * 项目总收益
	 * @param totalAmount
	 * @param days
	 * @param yearRate
	 * @return
	 */
	public static BigDecimal getTotalIncome(BigDecimal totalAmount, int days, BigDecimal yearRate){
		return (getTotalIncome(totalAmount, yearRate).multiply(new BigDecimal(days))).setScale(2, RoundingMode.DOWN);
	}
	
	
	/**
	 * 项目收益
	 * @param totalAmount
	 * @param yearRate
	 * @return
	 */
	public static BigDecimal getTotalIncome(BigDecimal totalAmount,BigDecimal yearRate){
		return totalAmount.multiply(yearRate.divide(new BigDecimal("100"),10,BigDecimal.ROUND_DOWN).divide(year365, 10, BigDecimal.ROUND_DOWN));
	}
}
