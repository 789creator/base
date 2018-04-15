package com.base.api.common.redis.rediskey;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by WangSheng on 2017/7/5.
 *
 * @author WangSheng
 * @date 2017/07/05
 */
public class BaseRedisKey implements RedisKey {
    /**
     * format的格式
     */
    private String keyFormat;
    /**
     * 单个操作的格式化的值
     */
    private String[] keyValues;
    /**
     * 批量操作的格式化的值
     */
    private Collection<String[]> batchKeyValues;
    /**
     * 过期时间段
     */
    private Integer expireSecond;
    /**
     * 过期时间段单位
     */
    private TimeUnit expireSecondUnit = TimeUnit.SECONDS;
    /**
     * 过期时间点
     */
    private Date expireDate;
    /**
     * 单个操作的原生的key
     */
    private String originKey;
    /**
     * 批量操作的原生的key
     */
    private Collection<String> batchOriginKey;

    public String getKeyFormat() {
        return keyFormat;
    }

    public void setKeyFormat(String keyFormat) {
        this.keyFormat = keyFormat;
    }

    public String[] getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(String[] keyValues) {
        this.keyValues = keyValues;
    }

    public Collection<String[]> getBatchKeyValues() {
        return batchKeyValues;
    }

    public void setBatchKeyValues(Collection<String[]> batchKeyValues) {
        this.batchKeyValues = batchKeyValues;
    }

    public Integer getExpireSecond() {
        return expireSecond;
    }

    public void setExpireSecond(Integer expireSecond) {
        this.expireSecond = expireSecond;
    }

    public TimeUnit getExpireSecondUnit() {
        return expireSecondUnit;
    }

    public void setExpireSecondUnit(TimeUnit expireSecondUnit) {
        this.expireSecondUnit = expireSecondUnit;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getOriginKey() {
        return originKey;
    }

    /**
     * 暂时关闭原生设置key，都要通过格式化
     * @param originKey
     */
    private void setOriginKey(String originKey) {
        this.originKey = originKey;
    }

    public Collection<String> getBatchOriginKey() {
        return batchOriginKey;
    }

    /**
     * 暂时关闭原生设置key，都要通过格式化
     * @param batchOriginKey
     */
    private void setBatchOriginKey(Collection<String> batchOriginKey) {
        this.batchOriginKey = batchOriginKey;
    }
}
