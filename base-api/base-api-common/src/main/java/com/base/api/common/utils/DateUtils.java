package com.base.api.common.utils;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * 日期工具类
 * @author xiaohaizi
 * @date   2017年3月9日 下午2:37:42
 */
public class DateUtils {

	/**
	 * yyyy-MM-dd
	 */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * yyyyMMdd
	 */
	public static final String YYYYMMDD = "yyyyMMdd";
	
	/**
	 * HHmmss
	 */
	public static final String HHmmss = "HHmmss";
	
	/**
	 * HH:mm
	 */
	public static final String HH_mm = "HH:mm";


	/**
	 * yyyy年MM月dd日
	 */
	public static final String YYYY_MM_DD_STR = "yyyy年MM月dd日";
	
	/**
	 * MM-DD
	 */
	public static final String MM_DD = "MM-dd";

	/**
	 * MM月DD日
	 */
	public static final String MM_DD_CN = "MM月dd日";
	
	/**
	 * 获得当前格式化的时间
	 * YYYY_MM_DD_HH_MM_SS
	 */
	public static String getDefaultStringDate(){
		return getStringDate(new Date(), YYYY_MM_DD_HH_MM_SS);
	}
	
	
	/**
	 * 今天的00:00:00
	 * @return Date     
	 */
	public static Date getTodayAsStartOfDay(){
		return withTimeAtStartOfDay(new Date());
	}
	
	/**
	 * 今天的23:59:59
	 * @return Date     
	 */
	public static Date getTodayAsEndOfDay(){
		return withTimeAtEndOfDay(new Date());
	}
	
	/**
	 * 当前日期的00:00:00
	 * @param date
	 * @return      
	 * Date
	 */
	public static Date withTimeAtStartOfDay(Date date){
		DateTime dt = new DateTime(date);
		return dt.withTimeAtStartOfDay().toDate();
	}
	
	/**
	 * 当前日期的23:59:59
	 * @param date
	 */
	public static Date withTimeAtEndOfDay(Date date){
		DateTime dt = new DateTime(date);
		return dt.withTimeAtStartOfDay().plusDays(1).minusSeconds(1).toDate();
	}
	
	/**
	 * 日期之间的天数
	 * @param startDate
	 * @param endDate
	 */
	public static int daysBetween(Date startDate, Date endDate){
		return Days.daysBetween(new DateTime(startDate).withTimeAtStartOfDay(), new DateTime(endDate).withTimeAtStartOfDay()).getDays();
	}
	
	/**
	 * 日期之间的秒数
	 * @param startDate
	 * @param endDate
	 */
	public static int secondsBetween(Date startDate, Date endDate){
		return Seconds.secondsBetween(new DateTime(startDate), new DateTime(endDate)).getSeconds();
	}
	
	/**
	 * 日期之间的分数
	 * @param startDate
	 * @param endDate
	 */
	public static int minutesBetween(Date startDate, Date endDate){
		return Minutes.minutesBetween(new DateTime(startDate), new DateTime(endDate)).getMinutes();
	}
	
	/**
	 * 日期之间的小时数
	 * @param startDate
	 * @param endDate
	 */
	public static int hoursBetween(Date startDate, Date endDate){
		return Hours.hoursBetween(new DateTime(startDate), new DateTime(endDate)).getHours();
	}
	
	/**
	 * 是否在当前日期之后
	 */
	public static boolean isAfterNow(){
		return isAfterNow(new Date());
	}
	
	/**
	 * 是否在日期之前
	 */
	public static boolean isBeforeNow(){
		return isAfterNow(new Date());
	}
	
	
	/**
	 * 是否在当前日期之后
	 * @param date
	 */
	public static boolean isAfterNow(Date date){
		DateTime dt = new DateTime(date);
		return dt.isAfterNow();
	}
	
	/**
	 * 是否在日期之前
	 * @param date
	 */
	public static boolean isBeforeNow(Date date){
		DateTime dt = new DateTime(date);
		return dt.isBeforeNow();
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @param pattern
	 */
	public static String getStringDate(Date date, String pattern){
		DateTime dt = new DateTime(date);
		return dt.toString(pattern);
	}
	
	/**
	 * 字符串转日期
	 * YYYY_MM_DD_HH_MM_SS
	 * @param dateStr
	 */
	public static Date getDateWithDateStr(String dateStr){
		return getDateWithDateStr(dateStr, YYYY_MM_DD_HH_MM_SS);
	}
	
	/**
	 * 字符串转日期
	 * @param dateStr
	 * @param pattern
	 */
	public static Date getDateWithDateStr(String dateStr, String pattern){
		 DateTime dt = DateTimeFormat.forPattern(pattern).parseDateTime(dateStr);
		 return dt.toDate();
	}
	
	/**
	 * 今日还剩余的秒数
	 * @return
	 */
	public static int getTodayEndSeconds(){
		return secondsBetween(getCurrentDate(), getTodayAsEndOfDay());
	}

	/**
	 * 周还剩余的秒数
	 * @return
	 */
	public static int getWeekEndSeconds(){
		return secondsBetween(getCurrentDate(),withTimeAtEndOfDay(new DateTime().dayOfWeek().withMaximumValue().toDate()));
	}
	
	/**
	 * 当前时间
	 * @return      
	 * Date
	 */
	public static Date getCurrentDate(){
		DateTime dt = new DateTime();
		return dt.toDate();
	}

	/**
	 * 项目还款日期
	 * @param days
	 * @return
	 */
	public static Date getProjectRepaymentDate(int days){
		return addDate(DateUtils.getCurrentDate(), days+1);
	}
	
	public static Date getProjectRepaymentDate(Date sales_endtime,int days){
		return addDate(sales_endtime, days+1);
	}

	/**
	 * 增加天数
	 * @param curDate
	 * @param days
	 * @return
	 */
	public static Date addDate(Date curDate, int days){
		DateTime dt = new DateTime(curDate);
		return dt.plusDays(days).toDate();
	}


	public static void main(String args[]){
		System.out.println(DateUtils.getStringDate(withTimeAtEndOfDay(new DateTime().dayOfWeek().withMaximumValue().toDate()),"yyyy-MM-dd HH:mm:ss"));
	}
}
