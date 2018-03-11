package com.base.api.common.rtf.client;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.base.api.common.ConfigUtil;
import com.base.api.common.encrypt.MD5;
import com.base.api.common.exception.RtfResponseException;
import com.base.api.common.exception.SignException;
import com.base.api.common.httpclient.HttpClientUtil;
import com.base.api.common.httpclient.common.HttpConfig;
import com.base.api.common.httpclient.exception.HttpProcessException;
import com.base.api.common.rtf.bean.RtfErrorResponse;
import com.base.api.common.rtf.config.RtfConfig;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 融托富 api 客户端工具类
 *
 * @author zhj
 * @date 2017/12/11
 */
public class RtfHttpClientUtil {

    static Logger logger = LoggerFactory.getLogger(RtfHttpClientUtil.class);
    /**
     * 融托富 api GET请求
     *
     * @param url
     * @param param 请求参数封装实体类
     * @param t     响应结果实体封装类
     * @param <T>
     * @return
     * @throws HttpProcessException
     */
    public static <T> T get(String url, Object param, T t) throws RtfResponseException, HttpProcessException, NoSuchFieldException, IllegalAccessException {
        String rs = httpClientGet (url, param);
        return parseResult (rs, (Class<T>) t.getClass (), param);
    }

    public static String httpClientGet(String url, Object obj) throws HttpProcessException {
        HttpConfig httpConfig = HttpConfig.custom ();
        httpConfig.url (url);
        httpConfig.map (formRequetParam (obj));
        return HttpClientUtil.get (httpConfig);
    }

    /**
     * 融托富 api POST请求
     *
     * @param url
     * @param param 请求参数封装实体类
     * @param t     响应结果实体封装类
     * @param <T>
     * @return
     * @throws HttpProcessException
     */
    public static <T> T post(String url, Object param, T t) throws HttpProcessException, NoSuchFieldException, IllegalAccessException {
        String rs = httpClientPost (url, param);
        return parseResult (rs, (Class<T>) t.getClass (), param);
    }


    public static String httpClientPost(String url, Object obj) throws HttpProcessException {
        HttpConfig httpConfig = HttpConfig.custom ();
        httpConfig.url (url);
        httpConfig.map (formRequetParam (obj));
        return HttpClientUtil.post (httpConfig);
    }

    /**
     * 结果解析
     *
     * @param rs    json字符串
     * @param clazz json 解析后封装到bean的clazz
     * @param param 请求融托富接口参数
     * @param <T>
     * @return
     */
    private static <T> T parseResult(String rs, Class<T> clazz, Object param) throws NoSuchFieldException, IllegalAccessException {
        if (rs.indexOf ("&") == -1) {
            RtfErrorResponse rtfErrorResponse = JSON.parseObject (rs, RtfErrorResponse.class);
            if(rtfErrorResponse == null){
                logger.info("解析融托富结果失败:"+rs + ",调用参数:" +  JSON.toJSONString (param));
            }
            logger.error("融托富接口："+rtfErrorResponse.getService()+"，订单号:"+rtfErrorResponse.getOrderNo()+"，返回错误："+rtfErrorResponse.getErrorMsg()+"("+rtfErrorResponse.getErrorCode()+")"+ ",调用参数:" +  JSON.toJSONString (param));
            throw new RtfResponseException (rtfErrorResponse, JSON.toJSONString (param));
        } else {
            String[] result = rs.split ("&");
            String resDataStr = result[result.length - 1];
            String resData = resDataStr.substring (resDataStr.indexOf ("=") + 1);
            T t = JSON.parseObject (resData, clazz);
            if (verifyResult (result, param)) {
                return convertToBean (Arrays.copyOfRange (result, 0, result.length - 1), t);
            } else {
                throw new SignException ("结果签名验证异常");
            }
        }
    }

    /**
     * 设置值到bean中
     *
     * @param result
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T convertToBean(String[] result, T t) {
        Map<String, Object> map = Maps.newHashMap ();
        for (String s : result) {
            String[] split = s.split ("=");
            map.put (split[0], split[1]);
        }
        BeanUtil.fillBeanWithMap (map, t, true);
        return t;
    }

    /**
     * 格式化请求参数
     *
     * @param param
     * @return
     */
    public static Map<String, Object> formRequetParam(Object param) {
        Map<String, Object> resMap = Maps.newHashMap ();
        Map<String, Object> data = Maps.newHashMap ();
        Class clazz = param.getClass ();
        List<Field> fieldsList = Lists.newArrayList ();
        while (clazz != null) {
            fieldsList.addAll (Arrays.asList (clazz.getDeclaredFields ()));
            clazz = clazz.getSuperclass ();
        }
        for (Field field : fieldsList) {
            field.setAccessible (true);
            // 这里还可以设置过滤内容
            try {
                if (Modifier.isStatic (field.getModifiers ()) || field.get (param) == null) {
                    continue;
                }
                if (field.getName ().equals ("version")) {
                    resMap.put ("version", field.get (param));
                } else if (field.getName ().equals ("service")) {
                    resMap.put ("service", field.get (param));
                } else if (field.getName ().equals ("partner")) {
                    resMap.put ("partner", field.get (param));
                } else if (field.getName ().equals ("signType")) {
                    resMap.put ("signType", field.get (param));
                } else if (field.getName ().equals ("sign")) {
                    resMap.put ("sign", field.get (param));
                } else {
                    data.put (field.getName (), field.get (param));
                }
            } catch (IllegalArgumentException e) {
                throw new RuntimeException (e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException (e);
            }
        }
        try {
            String reqData = JSON.toJSONString (data);
            String sign = MD5.sign (reqData, ConfigUtil.getInstance().getRtfKey(), "utf-8");
            resMap.put ("sign", sign);
            resMap.put ("reqData", reqData);
        } catch (Exception e) {
            e.printStackTrace ();
            throw new SignException ("融托富参数签名异常");
        }

        return resMap;
    }


    /**
     * 请求执行,统一处理
     * （外部只需调用这个方法）
     *
     * @param url
     * @param param         请求实体类
     * @param t             请求结果实体类
     * @param <T>
     * @param requestMethod 请求方法
     * @return
     * @throws HttpProcessException
     */
    public static <T> T execute(String url, Object param, T t, RequestMethod requestMethod) {
        try {
            if (RequestMethod.GET.equals (requestMethod)) {
                return get (url, param, t);

            } else if (RequestMethod.POST.equals (requestMethod)) {
                return post (url, param, t);
            } else {
                return get (url, param, t);
            }
        } catch (HttpProcessException e) {
            e.printStackTrace ();
            RtfErrorResponse res = new RtfErrorResponse ();
            res.setErrorCode ("10000");
            res.setErrorMsg (e.getMessage ());
            logger.error("融托富接口"+url+"访问失败:" + e.getMessage());
            throw new RtfResponseException (res);
        } catch (NoSuchFieldException e) {
            e.printStackTrace ();
            RtfErrorResponse res = new RtfErrorResponse ();
            res.setErrorCode ("10001");
            res.setErrorMsg (e.getMessage ());
            logger.error("融托富接口"+url+"访问异常:" + e.getMessage());
            throw new RtfResponseException (res);
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
            RtfErrorResponse res = new RtfErrorResponse ();
            res.setErrorCode ("10002");
            res.setErrorMsg (e.getMessage ());
            logger.error("融托富接口"+url+"访问异常:" + e.getMessage());
            throw new RtfResponseException (res);
        }
    }

    /**
     * 签名验证返回结果
     *
     * @param result
     */
    private static boolean verifyResult(String[] result, Object param) {

        try {
            String signResponse = null;
            String signVerify = null;
            for (String s : result) {
                if (s.indexOf ("sign=") >= 0) {
                    signResponse = s.split ("=")[1];
                } else if (s.indexOf ("resData=") >= 0) {
                    signVerify = MD5.sign (s.split ("=")[1].trim (), ConfigUtil.getInstance().getRtfKey(), "utf-8");
                }
            }
            if (signResponse != null && signVerify != null && signResponse.equals (signVerify)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace ();
            throw new SignException ("融托富签名参数异常");
        }
    }

}
