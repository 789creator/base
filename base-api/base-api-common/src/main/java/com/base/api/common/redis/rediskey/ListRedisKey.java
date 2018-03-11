package com.base.api.common.redis.rediskey;

import java.util.Collection;

/**
 * Created by WangSheng on 2017/7/5.
 *
 * @author WangSheng
 * @date 2017/07/05
 */
public class ListRedisKey extends BaseRedisKey {
    private String value;
    private Collection<String> values;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Collection<String> getValues() {
        return values;
    }

    public void setValues(Collection<String> values) {
        this.values = values;
    }
}
