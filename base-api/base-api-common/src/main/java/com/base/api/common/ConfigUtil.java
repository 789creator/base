package com.base.api.common;

import com.base.api.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConfigUtil {
    static HashMap map = new HashMap();

    Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

    private final static ConfigUtil configUtil = new ConfigUtil();

    public static ConfigUtil getInstance() {
        return configUtil;
    }

    public static HashMap getMap() {
        return map;
    }

    public static String confString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        Iterator iter = ConfigUtil.getMap().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            sb.append(String.valueOf(key));
            sb.append(":");
            if (val instanceof Date) {
                sb.append(formatter.format((Date) val));
            } else {
                sb.append(String.valueOf(val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private ConfigUtil() {
        //默认没有加载配置之前不允许访问
        map.put("site.pause", true);
        reloadConfig();
    }

    public void reloadConfig() {
        Properties properties = new Properties();
        InputStream inputStream = null;

        String site = System.getProperty("SITE");

        try {
            inputStream = ConfigUtil.class.getResourceAsStream("/config/base.properties");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            try {
                properties.load(reader);
            } catch (Exception e) {

            } finally {
                reader.close();
            }
        } catch (Exception e) {

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
        }

        try {
            inputStream = ConfigUtil.class.getResourceAsStream("/config/" + site + ".properties");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            try {
                properties.load(reader);
            } catch (Exception e) {

            } finally {
                reader.close();
            }
        } catch (Exception e) {

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
        }

        properties.forEach((key, value) -> map.put(key, value));

    }

    public void set(HashMap v) {
        map.putAll(v);
    }

    /**
     * RSA PrivateKey
     *
     * @return
     */
    public String getSysEncryptRSAPrivateKey() {
        return getConfig("sys.encrypt.rsa.private.key");
    }

    /**
     * RSA PublicKey
     *
     * @return
     */
    public String getSysEncryptRSAPublicKey() {
        return getConfig("sys.encrypt.rsa.public.key");
    }

    public String getSite() {
        return System.getProperty("SITE");
    }

    /**
     * api地址，比如酒掌柜是 https://api.nxin168.com
     */
    public String getApiUrl() {
        return getConfig("sys.api.url");
    }

    /**
     * PC地址，比如酒掌柜是 https://www.99jzg.com
     */
    public String getPCUrl() {
        return getConfig("sys.web.pc.url");
    }

    /**
     * 融托富存管是否开启
     */
    public boolean getRtfEnabled() {
        return getConfigBoolValue("sys.rtf.enabled");
    }

    /**
     * MD5
     *
     * @return
     */
    public String getSysEncryptMD5() {
        return getConfig("sys.encrypt.md5");
    }

    public String getBmAddr() {
        return getConfig("sys.web.bmaddr");
    }

    /**
     * DES
     *
     * @return
     */
    public String getSysEncryptDES() {
        return getConfig("sys.encrypt.des");
    }

    public String getDefaultChannel() {
        return getConfig("channel.default");
    }

    /**
     * 七牛Access Key
     *
     * @return
     */
    public String getQiNiuAccessKey() {
        return getConfig("qi.niu.access.key");
    }

    /**
     * 七牛Secret Key
     *
     * @return
     */
    public String getQiNiuSecretKey() {
        return getConfig("qi.niu.secret.key");
    }

    /**
     * 七牛图片路径
     *
     * @return
     */
    public String getQiNiuImgPath() {
        return getConfig("sys.qiniu.url");
    }

    /**
     * 文件上传根路径
     *
     * @return
     */
    public String getUploadFileParentPath() {
        return getConfig("upload.file.parent.path");
    }

    /**
     * 获得图片路径
     *
     * @param image
     * @return
     */
    public String getQiNiuImgPath(String image) {
        return getQiNiuImgPath() + image;
    }

    /**
     * Web地址
     *
     * @return String
     */
    public String getWebUrl() {
        return getConfig("sys.web.url");
    }


    public String getWebUrl(String key) {
        return getConfig("sys.web.url") + key;
    }

    /**
     * 获得启动Adv
     *
     * @return String
     */
    public String getStartAdv() {
        return getConfig("sys.start.adv");
    }

    /**
     * 订单支付超时,按秒计
     *
     * @return int
     */
    public int getPayOrderTimeOut() {
        int timeOut = getConfigIntValue("sys.pay.order.time.out", 3);
        return timeOut * 60;
    }

    /**
     * 充值最少金额
     *
     * @return int
     */
    public int getRechargeMinAmount() {
        return getConfigIntValue("sys.recharge.min.amount", 100);
    }


    /**
     * 提现最少金额
     *
     * @return int
     */
    public int getWithdrawMinAmount() {
        return getConfigIntValue("sys.min.amount", 1);
    }

    /**
     * 提现是否需要审核
     */
    public boolean getWithdrawNeedProve() {
        return getConfigBoolValue("sys.withdraw.needProve", false);
    }

    /**
     * 单笔最现最高
     *
     * @return
     */
    public int getWithdrawSingleMaxAmount() {
        return getConfigIntValue("sys.single.max.amount", 500000);
    }

    /**
     * 免费提现次数
     *
     * @return int
     */
    public int getBalanceWithdrawNum() {
        return getConfigIntValue("sys.balance.withdraw.num", 3);
    }

    /**
     * 每笔提现手续费
     *
     * @return int
     */
    public BigDecimal getBalanceWithdrawFee() {
        return getConfigBigDecimalValue("sys.balance.withdraw.fee", BigDecimal.valueOf(1.00).setScale(2, RoundingMode.DOWN));
    }

    /**
     * 是否开发环境
     *
     * @return
     */
    public boolean isDev() {
        String env = System.getProperty("ENV");
        if (env != null && "development".equals(env)) {
            return true;
        }
        return false;
        //return getConfigBoolValue("sys.isDev");
    }

    /**
     * 创蓝账户
     *
     * @return
     */
    public String getSmsAccount() {
        return getConfig("sys.sms.account");
    }

    /**
     * 创蓝账户密码
     *
     * @return
     */
    public String getSmsPassword() {
        return getConfig("sys.sms.password");
    }

    /**
     * 短信签名
     *
     * @return
     */
    public String getSmsSigner() {
        return getConfig("sys.sms.signer");
    }

    /**
     * 创蓝接口地址
     *
     * @return
     */
    public String getSmsServerURL() {
        return getConfig("sys.sms.url");
    }


    /**
     * 创蓝语音账户
     *
     * @return
     */
    public String getSmsVoiceAccount() {
        return getConfig("sys.sms.voice.account");
    }

    /**
     * 创蓝语音账户密码
     *
     * @return
     */
    public String getSmsVoicePassword() {
        return getConfig("sys.sms.voice.password");
    }

    /**
     * 创蓝语音接口地址
     *
     * @return
     */
    public String getSmsVoiceServerURL() {
        return getConfig("sys.sms.voice.url");
    }

    /**
     * 创蓝语音Md5
     *
     * @return
     */
    public String getSmsVoiceMd5() {
        return getConfig("sys.sms.voice.md5");
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @param defaultValue 默认是"1970-01-01 00:00:00"
     * @return
     */
    public final Date getConfigDateValue(String key, String defaultValue) {
        if (defaultValue == null || defaultValue.length() == 0) defaultValue = "1970-01-01 00:00:00";
        if (!map.containsKey(key)) {
            return DateUtils.getDateWithDateStr(defaultValue, DateUtils.YYYY_MM_DD_HH_MM_SS);
        }
        Object v = map.get(key);
        Date val = null;
        if (!(v instanceof Date)) {
            try {
                val = DateUtils.getDateWithDateStr(String.valueOf(v), DateUtils.YYYY_MM_DD_HH_MM_SS);
            } catch (Exception e) {
                return DateUtils.getDateWithDateStr(defaultValue, DateUtils.YYYY_MM_DD_HH_MM_SS);
            }
            if (val == null) return DateUtils.getDateWithDateStr(defaultValue, DateUtils.YYYY_MM_DD_HH_MM_SS);
            return val;
        }
        return (Date) v;
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @return
     */
    public final Date getConfigDateValue(String key) {
        return getConfigDateValue(key, "1970-01-01 00:00:00");
    }


    /**
     * 根据Key获得配置
     *
     * @param key
     * @param defaultValue 默认是"0.0"
     * @return
     */
    public final BigDecimal getConfigBigDecimalValue(String key, BigDecimal defaultValue) {
        if (!map.containsKey(key)) {
            return defaultValue;
        }
        Object v = map.get(key);
        BigDecimal val = null;
        if (!(v instanceof BigDecimal)) {
            try {
                val = BigDecimal.valueOf(Double.valueOf(String.valueOf(v)));
            } catch (Exception e) {
                return BigDecimal.ZERO;
            }
            if (val == null) return BigDecimal.ZERO;
            return val;
        }
        return (BigDecimal) v;
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @return
     */
    public final BigDecimal getConfigBigDecimalValue(String key) {
        return getConfigBigDecimalValue(key, BigDecimal.ZERO);
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @param defaultValue 默认是"0"
     * @return
     */
    public final int getConfigIntValue(String key, int defaultValue) {
        if (!map.containsKey(key)) {
            return defaultValue;
        }
        Object v = map.get(key);
        Integer val = null;
        if (!(v instanceof Integer)) {
            try {
                val = Integer.valueOf(String.valueOf(v));
            } catch (Exception e) {
                return 0;
            }
            if (val == null) return 0;
            return val;
        }
        return (Integer) v;
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @return
     */
    public final int getConfigIntValue(String key) {
        return getConfigIntValue(key, 0);
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @return
     */
    public final boolean getConfigBoolValue(String key, boolean defaultValue) {
        if (!map.containsKey(key)) {
            return defaultValue;
        }
        Object v = map.get(key);
        Boolean val = null;
        if (!(v instanceof Boolean)) {
            try {
                val = Boolean.valueOf(String.valueOf(v));
            } catch (Exception e) {
                return false;
            }
            if (val == null) return false;
            return val;
        }
        return (Boolean) v;
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @return
     */
    public final boolean getConfigBoolValue(String key) {
        return getConfigBoolValue(key, false);
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @return
     */
    public final String getConfig(String key, String defaultValue) {
        if (!map.containsKey(key)) {
            return defaultValue;
        }
        return String.valueOf(map.get(key));
    }

    /**
     * 根据Key获得配置
     *
     * @param key
     * @return
     */
    public final String getConfig(String key) {
        return getConfig(key, "");
    }


    /**
     * IOS推送
     */
    public String getJpushIOSMasterSecret() {
        return getConfig("jpush.ios.master.secret");
    }

    /**
     * IOS推送
     */
    public String getJpushIOSAppKey() {
        return getConfig("jpush.ios.appkey");
    }

    /**
     * Android推送
     */
    public String getJpushAndroidMasterSecret() {
        return getConfig("jpush.android.master.secret");
    }

    /**
     * Android推送
     */
    public String getJpushAndroidAppKey() {
        return getConfig("jpush.android.appkey");
    }


    /**
     * 用户，一个注册设备注册账户数量
     */
    public int getMemberRegNumDevice() {
        return getConfigIntValue("member.registerDeviceNum", 5);
    }

    /**
     * 用户，IP每天限制获取验证码次数
     */
    public int getMemberMobileCodeNumDailyIp() {
        return getConfigIntValue("member.mobileCodeNumDailyIp", 50);
    }

    /**
     * 用户，手机验证码过期时间
     */
    public int getMemberMobileCodeExpire() {
        return getConfigIntValue("member.mobileCodeExpire", 15 * 60);
    }


    public String getDownloadAppUrl() {
        return getConfig("app.download.url");
    }

    /**
     * 终端ID
     *
     * @return String
     */
    public String getBaoFooTerminalId() {
        return getConfig("sys.baofoo.terminalid");
    }

    /**
     * 认证支付商务号
     *
     * @return String
     */
    public String getBaoFooMemberId() {
        return getConfig("sys.baofoo.memberid");
    }

    /**
     * 认证支付密钥解密密码
     *
     * @return String
     */
    public String getBaoFooPassword() {
        return getConfig("sys.baofoo.password");
    }

    /**
     * 认证支付密证书
     *
     * @return String
     */
    public String getBaoFooCerPath() {
        return getConfig("sys.baofoo.cerpath");
    }

    /**
     * 认证支付密密钥
     *
     * @return String
     */
    public String getBaoFooPfxPath() {
        return getConfig("sys.baofoo.pfxpath");
    }


    /**
     * 网银支付商务号
     *
     * @return String
     */
    public String getBaoFooWangyinMemberId() {
        return getConfig("sys.baofoo.wangyin.memberid");
    }

    /**
     * 网银支付终端ID
     *
     * @return String
     */
    public String getBaoFooWangyinTerminalId() {
        return getConfig("sys.baofoo.wangyin.terminalid");
    }

    /**
     * 网银支付密钥
     *
     * @return String
     */
    public String getBaoFooWangyinMD5() {
        return getConfig("sys.baofoo.wangyin.md5");
    }

    /**
     * 网银支付页面返回地址
     *
     * @return String
     */
    public String getBaoFooWangyinPageURL() {
        return getConfig("sys.baofoo.wangyin.pageurl");
    }

    /**
     * 网银支付异步通知地址
     *
     * @return String
     */
    public String getBaoFooWangyinReturnURL() {
        return getConfig("sys.baofoo.wangyin.returnurl");
    }

    /**
     * 融托付partner
     *
     * @return String
     */
    public String getRtfPartner() {
        return getConfig("sys.rtf.partner");
    }

    /**
     * 融托付key
     *
     * @return String
     */
    public String getRtfKey() {
        return getConfig("sys.rtf.key");
    }
}
