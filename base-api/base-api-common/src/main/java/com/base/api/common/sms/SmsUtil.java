package com.base.api.common.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.base.api.common.ConfigUtil;
import com.base.api.common.httpclient.HttpClientUtil;
import com.base.api.common.httpclient.builder.HCB;
import com.base.api.common.httpclient.common.HttpConfig;
import com.base.api.common.sms.chuanglan.request.SmsSendRequest;
import com.base.api.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送服务
 */
@Component
public class SmsUtil {

    private static Logger logger = LoggerFactory.getLogger(SmsUtil.class);


    /**
     * 发送短信
     * @param mobile
     * @param content
     * @param isVoice
     */
    public static void sendSMS(String mobile, String content, boolean isVoice){
        if(!ConfigUtil.getInstance().isDev()){
            if(isVoice){
                sendVoiceSMS(mobile, content);
            }else{
                sendSMS(mobile, content);
            }
        }
    }

    /**
     * 发送短信
     * @param mobile
     * @param content
     */
    public static void sendSMS(String mobile, String content){
        String signer = ConfigUtil.getInstance().getSmsSigner();
        if(!(null == signer || "".equals(signer))){
            content = signer + content;
        }
        SmsSendRequest smsg = new SmsSendRequest(ConfigUtil.getInstance().getSmsAccount(),ConfigUtil.getInstance().getSmsPassword(),content,mobile,"true");
        String requestJson = JSON.toJSONString(smsg);
        String response = sendSmsByPost(ConfigUtil.getInstance().getSmsServerURL(), requestJson);
        logger.info("手机号：{},短信内容：{},发送状态：{}", mobile, content, response);
    }

    /**
     * 发送语音
     * @param mobile
     * @param content
     */
    public static void sendVoiceSMS(String mobile, String content){
        String organization= ConfigUtil.getInstance().getSmsVoiceAccount();
        String passwd= ConfigUtil.getInstance().getSmsVoicePassword();
        String key=ConfigUtil.getInstance().getSmsVoiceMd5();
        String timestamp = DateUtils.getStringDate(DateUtils.getCurrentDate(),"yyyyMMddHHmmss"); //当前时间戳
        String md5 = MD5(key+mobile+passwd+timestamp);
        JSONObject param = new JSONObject();
        JSONObject data = new JSONObject();
        //必填内容
        data.put("organization", organization);
        data.put("phonenum", mobile);
        data.put("content", md5);
        data.put("vfcode", ""+content); //验证码
        data.put("shownum", "95213141");
        //选填内容
        data.put("timestamp", timestamp);
        data.put("uniqueid", null);
        data.put("ringtime", null);
        data.put("maxtalktime", null);
        data.put("playnum", null);
        data.put("ivrfileid", null);
        param.put("voiceinfo", data);
        Map<String, Object> map = new HashMap<String ,Object>();
        map.put("method","vcfplay");
        map.put("voiceinfo", param.toString());
        try {
            String response = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom().timeout(30000).build()).url(ConfigUtil.getInstance().getSmsVoiceServerURL()).map(map));
            logger.info("手机号{},短信内容：{},语音发送状态{}", mobile, content, response);
        } catch (Exception e) {
            logger.error("语音验证码发送异常", e);
        }
    }


    /**
     * MD5加密
     * @param decript
     * @return
     */
    private static String MD5(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    private static  String sendSmsByPost(String path, String postContent) {
        URL url = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            httpURLConnection.setConnectTimeout(10000);//连接超时 单位毫秒
            httpURLConnection.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            OutputStream os=httpURLConnection.getOutputStream();
            os.write(postContent.getBytes("UTF-8"));
            os.flush();
            StringBuilder sb = new StringBuilder();
            int httpRspCode = httpURLConnection.getResponseCode();
            if (httpRspCode == HttpURLConnection.HTTP_OK) {
                // 开始获取数据
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                return sb.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static  void main(String args[]){
//        sendSMS("15968192937","hello");
        sendVoiceSMS("15968192937","登录验证码：123456");
    }

}
