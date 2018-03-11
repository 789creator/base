package com.base.api.common.redis.util;

import com.google.common.collect.Lists;
import com.base.api.common.redis.dataRedis.RedisClientUtil;
import com.base.api.common.redis.dataRedis.RedisConst;
import com.base.api.common.redis.rediskey.HashRedisKey;
import com.base.api.common.redis.rediskey.HashRedisKeyField;
import com.base.api.common.utils.BeanCopyUtil;
import com.base.api.common.web.model.MemberInfoDataRedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xiaohaizi on 2017/7/15.
 */

@Component
public class MemberRedisUtil {

    private Logger logger = LoggerFactory.getLogger(MemberRedisUtil.class);
    @Resource
    private RedisClientUtil redisClientUtil;

    /**
     * 保存用户单个信息
     * @param memberId
     * @param key
     * @param value
     */
    public void setMemberInfo(Long memberId,int clientId, String key, String value){
        HashRedisKey hashRedisKey = new HashRedisKey();
        hashRedisKey.setKeyFormat(RedisConst.MEMBER.MEMBER_INFO);
        hashRedisKey.setKeyValues(new String[]{memberId.toString(),String.valueOf(clientId)});
        HashRedisKeyField field = new HashRedisKeyField();
        field.setOriginKey(key);
        field.setValue(value);
        hashRedisKey.setField(field);
        redisClientUtil.hset(hashRedisKey);
    }

    /**
     * 保存用户信息
     * @param memberId
     * @param memberData
     */
    public void setMemberInfo(Long memberId,int clientId, MemberInfoDataRedis memberData){
        HashRedisKey hashRedisKey = new HashRedisKey();
        hashRedisKey.setKeyFormat(RedisConst.MEMBER.MEMBER_INFO);
        hashRedisKey.setKeyValues(new String[]{memberId.toString(),String.valueOf(clientId)});
        List<HashRedisKeyField> fieldList = Lists.newArrayList();
        TreeMap<String, String> data = BeanCopyUtil.toTreeMap(memberData);
        for (Map.Entry<String, String> entry : data.entrySet()) {
            HashRedisKeyField field = new HashRedisKeyField();
            field.setOriginKey(entry.getKey());
            field.setValue(entry.getValue());
            fieldList.add(field);
        }
        hashRedisKey.setFields(fieldList);
        redisClientUtil.hset(hashRedisKey);
    }


    /**
     * 获得用户缓存数据
     * @param memberId
     * @return
     */
    public MemberInfoDataRedis getMemberInfoData(Long memberId,int clientId){
        HashRedisKey hashRedisKey = new HashRedisKey();
        hashRedisKey.setKeyFormat(RedisConst.MEMBER.MEMBER_INFO);
        hashRedisKey.setKeyValues(new String[]{memberId.toString(),String.valueOf(clientId)});
        return redisClientUtil.getObjetData(hashRedisKey, MemberInfoDataRedis.class);
    }

    /**
     * 登录Token
     * @param memberId
     * @return
     */
    public String getMemberLoginToken(Long memberId,int client){

        MemberInfoDataRedis midr = getMemberInfoData(memberId,client);
        if(midr != null){
            return midr.getToken();
        }
        return null;
    }

}
