package com.base.api.common.redis.rediskey;

import java.util.Arrays;

/**
 * Created by WangSheng on 2017/7/6.
 *
 * @author WangSheng
 * @date 2017/07/06
 */
public class HashRedisKeyField {
    /**
     * format的格式
     */
    private String keyFormat;
    /**
     * 单个操作的格式化的值
     */
    private String[] keyValues;
    /**
     * 单个操作的原生的key
     */
    private String originKey;
    /**
     * 值
     */
    private String value;

    public HashRedisKeyField() {
    }

    public HashRedisKeyField(String keyFormat, String[] keyValues, String value) {
        this.keyFormat = keyFormat;
        this.keyValues = keyValues;
        this.value = value;
    }
    public HashRedisKeyField(String keyFormat, String[] keyValues) {
        this.keyFormat = keyFormat;
        this.keyValues = keyValues;
    }

    public HashRedisKeyField(String originKey, String value) {
        this.originKey = originKey;
        this.value = value;
    }
    public HashRedisKeyField(String originKey) {
        this.originKey = originKey;
        this.value = value;
    }

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

    public String getOriginKey() {
        return originKey;
    }

    public void setOriginKey(String originKey) {
        this.originKey = originKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashRedisKeyField{" +
            "keyFormat='" + keyFormat + '\'' +
            ", keyValues=" + Arrays.toString(keyValues) +
            ", originKey='" + originKey + '\'' +
            ", value=" + value +
            '}';
    }
}
