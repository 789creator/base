package com.base.api.common.redis.rediskey;

/**
 * Created by WangSheng on 2017/7/5.
 *
 * @author WangSheng
 * @date 2017/07/05
 */
public class SetRedisKey extends BaseRedisKey {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
