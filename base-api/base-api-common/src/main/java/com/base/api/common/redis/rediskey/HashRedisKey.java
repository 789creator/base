package com.base.api.common.redis.rediskey;

import java.util.Collection;

/**
 * Created by WangSheng on 2017/7/5.
 *
 * @author WangSheng
 * @date 2017/07/05
 */
public class HashRedisKey extends BaseRedisKey {
    private HashRedisKeyField field;
    private Collection<HashRedisKeyField> fields;

    public HashRedisKeyField getField() {
        return field;
    }

    public void setField(HashRedisKeyField field) {
        this.field = field;
    }

    public Collection<HashRedisKeyField> getFields() {
        return fields;
    }

    public void setFields(Collection<HashRedisKeyField> fields) {
        this.fields = fields;
    }
}
