package com.base.api.common.utils;

import org.joda.time.DateTime;

import java.util.Random;

public class OrderNoUtil {

    /**
     * 余额充值订单前缀
     */
    public static final String R = "R";
    /**
     * 项目订单前缀
     */
    public static final String P = "P";

    /**
     * 提现订单前缀
     */
    public static final String W = "W";

    /***
     * 还款订单前缀
     */
    public static final String B = "B";

    /***
     * 签约订单前缀
     */
    public static final String OC = "OC-";
    /***
     * 融托付快捷充值订单前缀
     */
    public static final String RTFC = "RTFC-";
    /**
     * 业务订单前缀
     */
    public static final String OP = "OP-";
    /***
     * 存管投标单号前缀
     */
    public static final String DI = "DI-";
    /***
     * 存管满标订单号前缀
     */
    public static final String DFS = "DFS-";
    /***
     * 存管满标投资方分账商户流水号前缀
     */
    public static final String DFI = "DFI-";
    /***
     * 存管满标借款方分账商户流水号前缀
     */
    public static final String DFD = "DFD-";
    /***
     * 存管借款方还款流水号前缀
     */
    public static final String DR = "DR-";
    /***
     * 存管借款方手续费流水号前缀
     */
    public static final String DF = "DF-";
    /***
     * 存管担保方替借款方还款流水号前缀
     */
    public static final String DRG = "DRG-";
    /***
     * 企业分账订单号前缀（默认）
     */
    public static final String RTFFZ = "RTFFZ-";
    /***
     * 企业分账订单号前缀（平台代还款）
     */
    public static final String RTFFZCP = "RTFFZCP-";
    /***
     * 企业分账订单号前缀（活动）
     */
    public static final String RTFFZAT = "RTFFZAT-";
    /***
     * 企业分账订单号前缀（尾单红包）
     */
    public static final String RTFFZWD = "RTFFZWD-";
    /***
     * 企业分账订单号前缀（加息）
     */
    public static final String RTFFZPU = "RTFFZPU-";

    /***
     * 还款订单号
     */
    public static String genReturnOrderNo(Long borrowerId) {
        //订单号中借款人ID获取方式与用户方式一致 后续修改
        return B + getMemberId (borrowerId) + getOrderRandomNumber (3);
    }

    /**
     * 项目订单号
     */
    public static String genProjectOrderNo(Long memberId) {
        return P + getMemberId (memberId) + getOrderRandomNumber (3);
    }

    /**
     * 业务订单号
     *
     * @param mobile
     * @return
     */
    public static String genOperationOrderNo(String mobile) {
        return OP + getMobile (mobile) + getOrderRandomNumber (5);
    }

    /**
     * 签约订单号
     *
     * @param memebrId
     * @return
     */
    public static String genContractOrderNo(Long memebrId) {
        return OC + getMemberId (memebrId) + getOrderRandomNumber (3);
    }

    /**
     * 融托付充值订单号
     *
     * @param memebrId
     * @return
     */
    public static String genRtfRechargeOrderNo(Long memebrId) {
        return RTFC + getMemberId (memebrId) + getOrderRandomNumber (3);
    }

    /**
     * 充值订单号
     *
     * @param memberId
     * @return
     */
    public static String genRechargeOrderNo(Long memberId) {
        return R + getMemberId (memberId) + getOrderRandomNumber (3);
    }

    /**
     * 提现订单号
     *
     * @param memberId
     * @return
     */
    public static String genWithdrawOrderNo(Long memberId) {
        return W + getMemberId (memberId) + getOrderRandomNumber (3);
    }

    /**
     * 存管投标订单号
     */
    public static String genInvestOrderNo() {
        return DI + getOrderRandomNumber (4);
    }

    /**
     * 存管满标订单号
     */
    public static String genDepositFullOrderNo() {
        return DF + getOrderRandomNumber (4);
    }

    /**
     * 存管满标投资方分账商户流水号
     */
    public static String genDepositInvestOrderNo() {
        return DFI + getOrderRandomNumber (4);
    }

    /**
     * 存管满标借款方分账商户流水号
     */
    public static String genDepositDebitOrderNo() {
        return DFD + getOrderRandomNumber (4);
    }

    /**
     * 存管借款方还款流水号
     */
    public static String genDepositReturnOrderNo() {
        return DR + getOrderRandomNumber (4);
    }
    /**
     * 存管借款方手续费流水号
     */
    public static String genDepositFeeSerialNo() {
        return DFS + getOrderRandomNumber (4);
    }

    /**
     * 存管担保方替借款方还款流水号
     */
    public static String genDepositReturnOrderNoGuarantee() {
        return DRG + getOrderRandomNumber (4);
    }

    /**
     * 生成订单随机数字
     */
    public static String getOrderRandomNumber(int randomNum) {
        DateTime time = new DateTime ();
        StringBuilder sb = new StringBuilder ();
        sb.append (getYmd (time));
        int random = 9;
        if (randomNum == 2) {
            random = 99;
        } else if (randomNum == 3) {
            random = 999;
        } else if (randomNum == 4) {
            random = 9999;
        }
        String v = getRandomNumberOnMillisOfDay (time) + StrUtils.leftPad (new Random ().nextInt (random) + "",
                randomNum, "0");
        sb.append (StrUtils.shuffle (v));
        return sb.toString ();
    }

    private static String getCurrentTimeOfDay() {
        DateTime time = new DateTime ();
        return getYmd (time) + getCurrentSecondOfDay (time);
    }

    /**
     * 年月日（2020年前年只取一位）
     */
    private static String getYmd(final DateTime time) {
        return (time.getYearOfCentury () - 10) + appendZero (time.getMonthOfYear ()) + appendZero (time.getDayOfMonth ());
    }

    /**
     * 补零
     */
    private static String appendZero(int num) {
        if (num < 10) {
            return "0" + num;
        }
        return num + "";
    }

    /**
     * 当天的秒数
     */
    private static String getCurrentSecondOfDay(final DateTime time) {
        int millis = time.getMillisOfDay () / 10000;
        return StrUtils.leftPad (millis + "", 5, "0");
    }

    /**
     * 当天的秒数+随机数字
     */
    private static String getRandomNumberOnMillisOfDay(final DateTime time) {
        int millis = (time.getMillisOfDay () / 10000) + new Random ().nextInt (10000);
        return StrUtils.leftPad (millis + "", 5, "0");
    }

    /**
     * 获取用户的后4位
     */
    private static String getMemberId(Long memberId) {
        if (memberId == null) {
            return "0000";
        }
        String memberIdStr = memberId.toString ();
        if (memberId < 1000) {
            memberId = Math.abs (memberId);
            return StrUtils.leftPad (memberId.toString (), 4, "0");
        }
        return memberIdStr.substring (memberIdStr.length () - 4, memberIdStr.length ());
    }

    private static String getMobile(String mobile) {
        if (mobile == null) {
            return "0000";
        }
        if (mobile.length () < 4) {
            return StrUtils.leftPad (mobile, 4, "0");
        }
        return mobile.substring (mobile.length () - 4, mobile.length ());
    }

}
