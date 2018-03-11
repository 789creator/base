package com.base.api.common.redis.util;

import com.base.api.common.redis.dataRedis.RedisClientUtil;
import com.base.api.common.redis.dataRedis.RedisConst;
import com.base.api.common.redis.rediskey.RedisKeyFactory;
import com.base.api.common.redis.rediskey.StrRedisKey;
import com.base.api.common.utils.DateUtils;
import com.base.api.common.utils.StrUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by xiaohaizi on 2017/7/14.
 */

@Component
public class WithdrawRedisUtil {

    @Resource
    private RedisClientUtil redisClientUtil;


    /**
     *
     * @param memberId
     */
    public void saveWithdrawNumAndAmount(Long memberId, BigDecimal amount){

        saveWithdrawAmount(memberId, amount);

        saveWithdrawNum(memberId);

    }

    /**
     * 提现金额
     * @param memberId
     * @param amount
     */
    public void saveWithdrawAmount(Long memberId, BigDecimal amount){
        BigDecimal totalAmount = getWithdrawTotalAmount(memberId);
        totalAmount = totalAmount.add(amount);
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.WITHDRAW.WITHDRAW_AMOUNT);
        strRedisKey.setKeyValues(new String[]{memberId.toString()});
        strRedisKey.setValue(totalAmount.toString());
        strRedisKey.setExpireSecond(DateUtils.getTodayEndSeconds());
        redisClientUtil.set(strRedisKey);
    }

    /**
     * 提现次数
     * @param memberId
     */
    public void saveWithdrawNum(Long memberId){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.WITHDRAW.WITHDRAW_NUM);
        strRedisKey.setKeyValues(new String[]{memberId.toString()});
        strRedisKey.setExpireSecond(DateUtils.getWeekEndSeconds());
        redisClientUtil.incrBy(strRedisKey);
    }


    /**
     * 获得提现总金额
     * @param memberId
     * @return
     */
    public BigDecimal getWithdrawTotalAmount(Long memberId){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.WITHDRAW.WITHDRAW_AMOUNT);
        strRedisKey.setKeyValues(new String[]{memberId.toString()});
        String amount = redisClientUtil.get(strRedisKey);
        if(!StrUtils.isNotEmpty(amount)){
            return BigDecimal.ZERO;
        }
        return new BigDecimal(amount);
    }

    /**
     * 提现次数
     * @param memberId
     * @return
     */
    public int getWithdrawTotalNum(Long memberId){
        StrRedisKey strRedisKey = RedisKeyFactory.getStrRedisKey();
        strRedisKey.setKeyFormat(RedisConst.WITHDRAW.WITHDRAW_NUM);
        strRedisKey.setKeyValues(new String[]{memberId.toString()});
        String num = redisClientUtil.get(strRedisKey);
        if(StrUtils.isNotEmpty(num)){
            return Integer.parseInt(num);
        }
        return 0;
    }
}
