package com.base.api.common.utils;

import java.util.regex.Pattern;

/**
 * 设备信息操作工具
 *
 * @author zhj
 * @date 2017/12/14
 */
public class DeviceUtil {

    /**
     * 手机端正则
     */
    private static String PHONE_REG = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            + "|windows (phone|ce)|blackberry"
            + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            + "|laystation portable)|nokia|fennec|htc[-_]"
            + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    /**
     * pad端正则
     */
    private static String PAD_REG = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    /**
     * pc端正则
     */
    private static String BROWSER_REG = "";

    /**
     * 移动设备正则匹配：手机端、平板
     */
    static Pattern phonePat = Pattern.compile (PHONE_REG, Pattern.CASE_INSENSITIVE);
    static Pattern padPat = Pattern.compile (PAD_REG, Pattern.CASE_INSENSITIVE);
    static Pattern browserPat = Pattern.compile (BROWSER_REG, Pattern.CASE_INSENSITIVE);

    public static String getBusWay(String userAgent) {
        if (null == userAgent) {
            return "其他";
        }
        String agent = userAgent.toLowerCase ();
        if (phonePat.matcher (agent).find ()) {
            return "手机";
        } else if (padPat.matcher (agent).find ()) {
            return "平板";
        } else if (browserPat.matcher (agent).find ()) {
            return "pc";
        } else {
            return "其他";
        }
    }
}
