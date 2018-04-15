package com.base.api.common.redis.util;


import com.base.api.common.enums.system.SmsBusinessEnum;
import com.base.api.common.redis.dataRedis.RedisClientUtil;
import com.base.api.common.redis.dataRedis.RedisConst;
import com.base.api.common.redis.rediskey.RedisKeyFactory;
import com.base.api.common.redis.rediskey.StrRedisKey;
import com.base.api.common.utils.DateUtils;
import com.base.api.common.utils.StrUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by xiaohaizi on 2017/7/13.
 */
@Component
public class SmsRedisUtil {

    @Resource
    private RedisClientUtil redisClientUtil;


    /**
     * 检查手机号码是否正确
     * @param smsEnum
     * @param mobile
     * @param code
     * @return
     */
    public boolean checkSmsCode(SmsBusinessEnum smsEnum, String mobile, String code){
        if(getSmsValidNum(smsEnum, mobile) > 3){
            return false;
        }
        String smsCode = getSMSCode(smsEnum, mobile);
        if(!StrUtils.isNotEmpty(smsCode)) {
            return false;
        }
        if(!smsCode.equals(code)){
            saveCodeValidNum(smsEnum, mobile);
            return false;
        }
        //删除校验次数
        delSmsVaildNum(smsEnum, mobile);
        return true;
    }



    /**
     * 设置短信发送记录
     * @param smsEnum
     * @param mobile
     * @param code
     */
    public void saveSMSByMobile(SmsBusinessEnum smsEnum, String mobile, String code){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS);
        strRedisKey.setKeyValues(new String[]{smsEnum.getCode().toString(), mobile});
        strRedisKey.setValue(code);
        strRedisKey.setExpireSecond(180);
        redisClientUtil.set(strRedisKey);
        //保存手机号获取短信的数量
        saveMobileGetSMSNum(mobile, 60);
        //删除校验次数
        delSmsVaildNum(smsEnum, mobile);
    }

    /**
     *
     * @param smsEnum
     * @param mobile
     */
    public void saveCodeValidNum(SmsBusinessEnum smsEnum, String mobile){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS_VALID_COUNT);
        strRedisKey.setKeyValues(new String[]{smsEnum.getCode().toString(), mobile});
        strRedisKey.setExpireSecond(180);
        redisClientUtil.incrBy(strRedisKey);
    }

    /**
     * 删除短信
     * @param smsEnum
     * @param mobile
     */
    public void delSms(SmsBusinessEnum smsEnum, String mobile){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS);
        strRedisKey.setKeyValues(new String[]{smsEnum.getCode().toString(), mobile});
        redisClientUtil.delete(strRedisKey);
    }

    /**
     * 删除短信校验次数
     * @param smsEnum
     * @param mobile
     */
    public void delSmsVaildNum(SmsBusinessEnum smsEnum, String mobile){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS_VALID_COUNT);
        strRedisKey.setKeyValues(new String[]{smsEnum.getCode().toString(), mobile});
        redisClientUtil.delete(strRedisKey);
    }

    /**
     * 获得短信校验次数
     * @param smsEnum
     * @param mobile
     * @return
     */
    public int getSmsValidNum(SmsBusinessEnum smsEnum, String mobile){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS_VALID_COUNT);
        strRedisKey.setKeyValues(new String[]{smsEnum.getCode().toString(), mobile});
        String value = redisClientUtil.get(strRedisKey);
        if(StrUtils.isNotEmpty(value)){
            return Integer.parseInt(value);
        }
        return 0;
    }


    /**
     * 获得短信验证码
     * @param smsEnum
     * @param mobile
     * @return
     */
    public String getSMSCode(SmsBusinessEnum smsEnum, String mobile){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS);
        strRedisKey.setKeyValues(new String[]{smsEnum.getCode().toString(), mobile});
        return redisClientUtil.get(strRedisKey);
    }


    /**
     * 记录IP每天获得IP总数
     * @param ip
     */
    public void saveIPGetSMSNum(String ip){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.IP);
        strRedisKey.setKeyValues(new String[]{ip});
        strRedisKey.setExpireSecond(DateUtils.getTodayEndSeconds());
        redisClientUtil.incrBy(strRedisKey);
    }


    /**
     * 保存手机号获得短信数次
     * @param mobile
     */
    public void saveMobileGetSMSNum(String mobile, int expireSecond){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS_COUNT);
        strRedisKey.setKeyValues(new String[]{mobile});
        strRedisKey.setExpireSecond(expireSecond);
        redisClientUtil.incrBy(strRedisKey);
    }

    /**
     * 是否可以获取短信
     * @param mobile
     * @return
     */
    public boolean isGetSmsByMobile(String mobile){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.SMS_COUNT);
        strRedisKey.setKeyValues(new String[]{mobile});
        String value = redisClientUtil.get(strRedisKey);
        if(StrUtils.isNotEmpty(value)){
            return false;
        }
        return true;
    }


    /**
     * IP是否可以获得短信
     * @param ip
     * @return
     */
    public boolean isGetSmsByIP(String ip){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.SMS.IP);
        strRedisKey.setKeyValues(new String[]{ip});
        strRedisKey.setExpireSecond(3600*24); //一天
        String value = redisClientUtil.get(strRedisKey);
        if(StrUtils.isNotEmpty(value)){
           if(Integer.parseInt(value) > 30){
               return false;
           }
        }
        return true;
    }
}
