package com.base.api.common.rtf.config;

import com.base.api.common.ConfigUtil;
import com.base.api.common.config.Global;
import com.base.api.common.rtf.bean.RtfBaseRequest;

import java.lang.reflect.Field;

/**
 * 融托富请求地址
 *
 * @author zhj
 * @date 2017/12/11.
 */
public class RtfConfig {

    /**
     * 获取请求地址
     *
     * @param name
     * @param rtfBaseRequest
     * @return
     */
    public static String getRequestUrl(String name, RtfBaseRequest rtfBaseRequest) {
        if (isDev()){
            return Global.getConfig (name + "-dev");
        } else {
            return Global.getConfig (name + "-pro");
        }
    }

    /**
     * 根据partner是否相同:获取配置
     * @param name
     * @return
     */
    public static String getConfig(String name){
        if (isDev()){
            return Global.getConfig(name + "-dev");
        }else {
            return Global.getConfig(name + "-pro");
        }
    }
    public static boolean isDev(){
        String dev = Global.getConfig("partner-dev");
        String pro = ConfigUtil.getInstance().getRtfPartner();
        if (dev != null && dev.length() > 0 && dev.equals(pro)){
            return true;
        }else {
            return false;
        }
    }
}
