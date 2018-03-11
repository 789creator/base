package com.base.api.common.redis.rediskey;

/**
 * Created by WangSheng on 2017/7/5.
 *
 * @author WangSheng
 * @date 2017/07/05
 */
public class RedisKeyFactory {
    public static BaseRedisKey getBaseRedisKey(){
        return new BaseRedisKey();
    }
    public static StrRedisKey getStrRedisKey(){
        return new StrRedisKey();
    }
    public static ListRedisKey getListRedisKey(){
        return new ListRedisKey();
    }
    public static HashRedisKey getHashRedisKey(){
        return new HashRedisKey();
    }
    public static SetRedisKey getSetRedisKey(){
        return new SetRedisKey();
    }
    public static ZSetRedisKey getZSetRedisKey(){
        return new ZSetRedisKey();
    }
}
