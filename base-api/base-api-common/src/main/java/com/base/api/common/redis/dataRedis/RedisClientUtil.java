package com.base.api.common.redis.dataRedis;

import com.alibaba.fastjson.JSONObject;
import com.base.api.common.redis.rediskey.*;
import com.base.api.common.utils.BeanCopyUtil;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.ArrayUtil;
import com.xiaoleilu.hutool.util.CollectionUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by WangSheng on 2017/7/5.
 *
 * 1. 该操作类总体思路：根据传入的RedisKey中的设置的属性值，来确认具体的操作，比如设置过期时间，是否是批量操作等等
 * 2. 本次只是1.0版本，后期可以考虑在此基础上假如更多方便功能，比如完善list hash zset操作、获取值直接返回具体的类型、简化RedisKey的赋值操作
 * 3. rediskey中的keyformat 请从RedisConst类中获取
 * 4. 简单示例代码参考TestRedisClientUtilController.java类
 *
 *
 * @author WangSheng
 * @date 2017/07/05
 */
@Component
public class RedisClientUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /*************************************common 操作***************************************/
    /**
     * 删除操作
     * 该操作包含批量删除和单个删除，如果需要对key进行格式化，请设置rediskey的keyFormat值
     * 删除时的判断顺序：批量格式删除》单个格式删除》批量原生删除》单个原生删除
     * @param redisKey
     */
    public void delete(BaseRedisKey redisKey){
        if(isBatchFormat(redisKey)){
            doDeleteBatchFormat(redisKey);
        }else if(isSingleFormat(redisKey)){
            doDeleteSingleFormat(redisKey);
        }else if(isBatchOrigin(redisKey)){
            doDeleteBatchOrigin(redisKey);
        }else if(isSingleOrigin(redisKey)){
            doDeleteSingleOrigin(redisKey);
        }
    }

    /**
     * 设置过期时间
     * 该操作包括时间点和时间段设置过期时间，如果需要对key进行格式化，请设置rediskey的keyFormat值
     * 设置时的判断顺序：格式设置时间段》格式设置时间点》原生设置时间段》原生设置时间点
     * @param redisKey
     * @return
     */
    public boolean expire(BaseRedisKey redisKey){
        if(isExpireFormat(redisKey)){
            return doExpireFormat(redisKey);
        }else if(isExpireAtFormat(redisKey)){
            return doExpireAtFormat(redisKey);
        }else if(isExpireOrigin(redisKey)){
            return doExpireOrigin(redisKey);
        }else if(isExpireAtOrigin(redisKey)){
            return doExpireAtOrigin(redisKey);
        }
        return false;
    }

    /**
     * 判断是否存在当前Key，如果需要对key进行格式化，请设置rediskey的keyFormat值
     * @param redisKey
     * @return
     */
    public boolean exists(BaseRedisKey redisKey){
        String key;
        if(isSingleFormat(redisKey)){
            key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        }else{
            key = redisKey.getOriginKey();
        }
        if(StrUtil.isNotBlank(key)){
            return redisTemplate.hasKey(key);
        }
        return false;
    }

    /*************************************str 操作******************************************/
    /**
     * 字符串设置值
     * 本操作包括带过期时间段和带过期时间点设置值，如果需要对key进行格式化，请设置rediskey的keyFormat值
     * 设置时的判断顺序：格式化带过期时间段设置》格式化带过期时间点设置》原生带过期时间段设置
     * 》原生带过期时间点设置》格式化设置区间值》原生设置区间值》格式化永不过期设置》原生永不过期设置
     * @param redisKey
     */
    public void set(StrRedisKey redisKey){
        if(isExpireFormat(redisKey)){
            doSetFormatAndExpire(redisKey);
        }else if(isExpireAtFormat(redisKey)){
            doSetFormatAndExpireAt(redisKey);
        }else if(isExpireOrigin(redisKey)){
            doSetOriginAndExpire(redisKey);
        }else if(isExpireAtOrigin(redisKey)){
            doSetOriginAndExpireAt(redisKey);
        }else if(isSetFormatRange(redisKey)){
            doSetFormatRange(redisKey);
        }else if(isSetOriginRanage(redisKey)){
            doSetOriginRanage(redisKey);
        }else if(isSingleFormat(redisKey)){
            dSetFormat(redisKey);
        }else if(isSingleOrigin(redisKey)){
            doSetOrigin(redisKey);
        }
    }

    /**
     * 获取数据
     * 本操作包括获取全部数据和获取区间数据，如果需要对key进行格式化，请设置rediskey的keyFormat值
     * 获取时判断顺序：获取格式化区间数据》获取格式化全部数据》获取原生区间数据》获取原生全部数据
     * @param redisKey
     * @return
     */
    public String get(StrRedisKey redisKey){
        if(isGetFormatRange(redisKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            return redisTemplate.opsForValue().get(key, redisKey.getStartOffset(), redisKey.getEndOffset());
        }else if(isGetFormat(redisKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            return redisTemplate.opsForValue().get(key);
        }else if(isGetOriginRange(redisKey)){
            return redisTemplate.opsForValue().get(redisKey.getOriginKey(), redisKey.getStartOffset(), redisKey.getEndOffset());
        }else if(isGetOrigin(redisKey)){
            return redisTemplate.opsForValue().get(redisKey.getOriginKey());
        }
        return null;
    }

    /**
     * 设置List对象
     * @param redisKey
     * @param list
     */
    public void setList(StrRedisKey redisKey, List list){
        String data = JSONObject.toJSONString(list);
        redisKey.setValue(data);
        set(redisKey);
    }

    /**
     * 设置Object对象
     * @param redisKey
     * @param obj
     */
    public void setObject(StrRedisKey redisKey, Object obj){
        String data = JSONObject.toJSONString(obj);
        redisKey.setValue(data);
        set(redisKey);
    }

    /**
     * 获得List对象
     * @param redisKey
     * @param cls
     * @param <T>
     * @return
     */
    public <T> List<T> getList(StrRedisKey redisKey, Class<T> cls){
        String data = get(redisKey);
        if (StrUtil.isNotEmpty(data)) {
            return JSONObject.parseArray(data, cls);
        }
        return null;
    }

    /**
     * 获得Object对象
     * @param redisKey
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T getObject(StrRedisKey redisKey, Class<T> cls){
        String data = get(redisKey);
        if (StrUtil.isNotEmpty(data)) {
            return JSONObject.parseObject(data, cls);
        }
        return null;
    }

    /**
     * 计数器，每次自增固定数值
     * @param redisKey
     * @return
     */
    public Long incrByNumber(StrRedisKey redisKey) {
        Long index = null;
        if(isSingleFormat(redisKey)){
            String key = getFormatKey(redisKey);
            index = redisTemplate.opsForValue().increment(key, Long.parseLong(redisKey.getValue()));
            this.expire(redisKey);
        }else if(isSingleOrigin(redisKey)){
            index = redisTemplate.opsForValue().increment(redisKey.getOriginKey(), Long.parseLong(redisKey.getValue()));
            this.expire(redisKey);
        }
        return index;
    }
    /**
     * 计数器，每次自增1
     * @param redisKey
     * @return
     */
    public Long incrBy(StrRedisKey redisKey) {
        redisKey.setValue("1");
        return this.incrByNumber(redisKey);
    }

    /*************************************hash 操作*****************************************/
    /**
     * 设置对象属性值
     * @param redisKey
     */
    public void hset(HashRedisKey redisKey) {
        if(isHSetFormatBatch(redisKey)){
            doHSetFormatBatch(redisKey);
        }else if(isHSetOriginBatch(redisKey)){
            doHSetOriginBatch(redisKey);
        }else if(isHSetFormatSingle(redisKey)){
            doHSetFormatSingle(redisKey);
        }else if(isHSetOriginSingle(redisKey)){
            doHSetOriginSingle(redisKey);
        }
        this.expire(redisKey);
    }

    /**
     * 获得对象属性值
     * @param redisKey
     * @return
     */
    public String hget(HashRedisKey redisKey){
        if(isSingleFormat(redisKey) && ObjectUtil.isNotNull(redisKey.getField())){
            return doHGetFormat(redisKey).toString();
        }else if(isSingleOrigin(redisKey) && ObjectUtil.isNotNull(redisKey.getField())){
            return doHGetOrigin(redisKey).toString();
        }
        return null;
    }
    /**
     * 泛型获得对象属性值
     * @param redisKey
     * @return
     */
    public <T> T hget(HashRedisKey redisKey, Class<T> cls){
        if(isSingleFormat(redisKey) && ObjectUtil.isNotNull(redisKey.getField())){
            return JSONObject.parseObject(doHGetFormat(redisKey).toString(), cls);
        }else if(isSingleOrigin(redisKey) && ObjectUtil.isNotNull(redisKey.getField())){
            return JSONObject.parseObject(doHGetOrigin(redisKey).toString(), cls);
        }
        return null;
    }

    /**
     * 删除HashMap field字段
     * @param redisKey
     */
    public Long hdel(HashRedisKey redisKey) {
        if(isHDelFormatBatch(redisKey)){
            return doHDelFormatBatch(redisKey);
        }else if(isHDelFormatSingle(redisKey)){
            return doHDelFormatSingle(redisKey);
        }else if(isHDelOriginBatch(redisKey)){
            return doHDelOriginBatch(redisKey);
        }else if(isHDelOriginSingle(redisKey)){
            return doHDelOriginSingle(redisKey);
        }
        return null;
    }

    /**
     * 将HashMap中的Key对应的Value加上一个Long值
     * @param redisKey
     */
    public Long hIncrByLong(HashRedisKey redisKey) {
        String result = "";
        if(isSingleFormat(redisKey)){
            result = doHIncrByFormat(redisKey, 0);
        }else if(isSingleOrigin(redisKey)){
            result = doHIncrByOrigin(redisKey, 0);
        }
        return StrUtil.isBlank(result)? null : Long.parseLong(result);
    }
    /**
     * 将HashMap中的Key对应的Value加上1
     * @param redisKey
     */
    public Long hIncrBy(HashRedisKey redisKey) {
        redisKey.getField().setValue("1");
        return hIncrByLong(redisKey);
    }
    /**
     * 将HashMap中的Key对应的Value加上一个Double值
     * @param redisKey
     */
    public Double hIncrByDouble(HashRedisKey redisKey) {
        String result = "";
        if(isSingleFormat(redisKey)){
            result = doHIncrByFormat(redisKey, 1);
        }else if(isSingleOrigin(redisKey)){
            result = doHIncrByOrigin(redisKey, 1);
        }
        return StrUtil.isBlank(result)? null : Double.parseDouble(result);
    }

    /*************************************list 操作*****************************************/
    /**
     * 将一个或多个值插入到列表头部
     * @param redisKey
     */
    public Long lpush(ListRedisKey redisKey){
        if(isLpushFormatBatch(redisKey)){
            return doLpushFormatBatch(redisKey);
        }else if(isLpushOriginBatch(redisKey)){
            return doLpushOriginBatch(redisKey);
        }else if(isLpushFormatSingle(redisKey)){
            return doLpushFormatSingle(redisKey);
        }else if(isLpushOriginSingle(redisKey)){
            return doLpushOriginSingle(redisKey);
        }
        return null;
    }

    /**
     * 通过key从list的头部删除一个value,并返回该value
     * @param redisKey
     * @return
     */
    public String lpop(ListRedisKey redisKey){
        if(isSingleFormat(redisKey)){
            String key = getFormatKey(redisKey);
            return redisTemplate.opsForList().leftPop(key);
        }else if(isSingleOrigin(redisKey)){
            return redisTemplate.opsForList().leftPop(redisKey.getOriginKey());
        }
        return null;
    }
    /**
     * 泛型通过key从list的头部删除一个value,并返回该value
     * @param redisKey
     * @return
     */
    public <T> T lpop(ListRedisKey redisKey, Class<T> cls){
        return JSONObject.parseObject(lpop(redisKey), cls);
    }
    /*************************************set 操作******************************************/
    /**
     * 获取key下面所有值
     * @param redisKey
     * @return
     */
    public Set smembers(SetRedisKey redisKey){
        if(isSingleFormat(redisKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            return redisTemplate.opsForSet().members(key);
        }else if(isSingleOrigin(redisKey)){
            return redisTemplate.opsForSet().members(redisKey.getOriginKey());
        }
        return null;
    }

    /**
     * 查询key的数量
     * @param redisKey
     * @return
     */
    public Long scard(SetRedisKey redisKey) {
        if(isSingleFormat(redisKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            return redisTemplate.opsForSet().size(key);
        }else if(isSingleOrigin(redisKey)){
            return redisTemplate.opsForSet().size(redisKey.getOriginKey());
        }
        return null;
    }

    /**
     * 求所有所有key的并集
     * @param redisKey
     * @return
     */
    public Set sunion(SetRedisKey redisKey) {
        String key = "";
        if(isBatchFormat(redisKey)){
            Set<String> batchKeyValues = getFormatBatchKeyValues(redisKey);
            return redisTemplate.opsForSet().union(key, batchKeyValues);
        }else if(isBatchOrigin(redisKey)){
            return redisTemplate.opsForSet().union(key, redisKey.getBatchOriginKey());
        }
        return null;
    }

    /**
     * 求redisKey1与redisKey2的差集
     * @param redisKey1
     * @param redisKey2
     * @return
     */
    public Set sdiff(SetRedisKey redisKey1, SetRedisKey redisKey2) {
        String key1 = "", key2 = "";
        if(isSingleFormat(redisKey1)){
            key1 = format(redisKey1.getKeyFormat(), redisKey1.getKeyValues());
        }else if(isSingleOrigin(redisKey1)){
            key1 = redisKey1.getOriginKey();
        }
        if(isSingleFormat(redisKey2)){
            key2 = format(redisKey2.getKeyFormat(), redisKey2.getKeyValues());
        }else if(isSingleOrigin(redisKey2)){
            key2 = redisKey2.getOriginKey();
        }
        return redisTemplate.opsForSet().difference(key1, key2);
    }

    /**
     * 向集合添加元素
     * @param redisKey
     * @return
     */
    public Long sadd(SetRedisKey redisKey) {
        if(isSingleFormat(redisKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            return redisTemplate.opsForSet().add(key, redisKey.getValue());
        }else if(isSingleOrigin(redisKey)){
            return redisTemplate.opsForSet().add(redisKey.getOriginKey(), redisKey.getValue());
        }
        return null;
    }

    /**
     * 移除单个元素
     * @param redisKey
     * @return
     */
    public Long srem(SetRedisKey redisKey) {
        if(isSingleFormat(redisKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            return redisTemplate.opsForSet().remove(key, redisKey.getValue());
        }else if(isSingleOrigin(redisKey)){
            return redisTemplate.opsForSet().remove(redisKey.getOriginKey(), redisKey.getValue());
        }
        return null;
    }
    /*************************************zset 操作*****************************************/



    public <T> T getObjetData(HashRedisKey redisKey, Class<T> clas){
        Map<Object, Object> data = null;
        if(isSingleFormat(redisKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            data = redisTemplate.opsForHash().entries(key);
        }else if(isSingleOrigin(redisKey)){
            data = redisTemplate.opsForHash().entries(redisKey.getOriginKey());
        }
        if(data != null){
            return BeanCopyUtil.map(data, clas);
        }
        return null;
    }




    /*************************************以下是私有方法区*****************************************/
    /**
     * 将HashMap中的原生Key对应的field的Value加上一个值
     * @param redisKey
     * @param type
     * @return
     */
    private String doHIncrByOrigin(HashRedisKey redisKey, int type) {
        String fieldKey = "";
        HashRedisKeyField field = redisKey.getField();
        if(isFormatField(field)){
            fieldKey = getFormatFieldKey(field);
        }else if(isOriginField(field)){
            fieldKey = field.getOriginKey();
        }
        if(StrUtil.isNotBlank(fieldKey)){
            if(type == 1){
                return redisTemplate.opsForHash().increment(redisKey.getOriginKey(), fieldKey, Double.parseDouble(field.getValue().toString())).toString();
            }else{
                return redisTemplate.opsForHash().increment(redisKey.getOriginKey(), fieldKey, Long.parseLong(field.getValue().toString())).toString();
            }
        }
        return null;
    }

    /**
     * 将HashMap中的格式化Key对应的field的Value加上一个值
     * @param redisKey
     * @param type 0或者不传:新增Long   1：新增Double
     * @return
     */
    private String doHIncrByFormat(HashRedisKey redisKey, int type) {
        String key = getFormatKey(redisKey);
        String fieldKey = "";
        HashRedisKeyField field = redisKey.getField();
        if(isFormatField(field)){
            fieldKey = getFormatFieldKey(field);
        }else if(isOriginField(field)){
            fieldKey = field.getOriginKey();
        }
        if(StrUtil.isNotBlank(fieldKey)){
            if(type == 1){
                return redisTemplate.opsForHash().increment(key, fieldKey, Double.parseDouble(field.getValue().toString())).toString();
            }else{
                return redisTemplate.opsForHash().increment(key, fieldKey, Long.parseLong(field.getValue().toString())).toString();
            }
        }
        return null;
    }
    /**
     * 原生单个删除
     * @param redisKey
     * @return
     */
    private boolean isHDelOriginSingle(HashRedisKey redisKey) {
        return isSingleOrigin(redisKey) && isSingleField(redisKey);
    }

    /**
     * 原生批量删除
     * @param redisKey
     * @return
     */
    private boolean isHDelOriginBatch(HashRedisKey redisKey) {
        return isSingleOrigin(redisKey) && isBatchField(redisKey);
    }

    /**
     * 单个格式化删除
     * @param redisKey
     * @return
     */
    private boolean isHDelFormatSingle(HashRedisKey redisKey) {
        return isSingleFormat(redisKey) && isSingleField(redisKey);
    }

    /**
     * 批量格式化删除
     * @param redisKey
     * @return
     */
    private boolean isHDelFormatBatch(HashRedisKey redisKey) {
        return isSingleFormat(redisKey) && isBatchField(redisKey);
    }
    private Long doLpushOriginSingle(ListRedisKey redisKey) {
        return redisTemplate.opsForList().leftPush(redisKey.getOriginKey(), redisKey.getValue());
    }

    private Long doLpushFormatSingle(ListRedisKey redisKey) {
        String key = getFormatKey(redisKey);
        return redisTemplate.opsForList().leftPush(key, redisKey.getValue());
    }

    private Long doLpushOriginBatch(ListRedisKey redisKey) {
        return redisTemplate.opsForList().leftPushAll(redisKey.getOriginKey(), redisKey.getValues());
    }

    private Long doLpushFormatBatch(ListRedisKey redisKey) {
        String key = getFormatKey(redisKey);
        return redisTemplate.opsForList().leftPushAll(key, redisKey.getValues());
    }

    private boolean isLpushOriginSingle(ListRedisKey redisKey) {
        return isSingleOrigin(redisKey) && isSingleValueList(redisKey);
    }

    private boolean isLpushFormatSingle(ListRedisKey redisKey) {
        return isSingleFormat(redisKey) && isSingleValueList(redisKey);
    }

    private boolean isSingleValueList(ListRedisKey redisKey) {
        return ObjectUtil.isNotNull(redisKey.getValue());
    }

    private boolean isLpushOriginBatch(ListRedisKey redisKey) {
        return isSingleOrigin(redisKey) && isBatchValueList(redisKey);
    }

    private boolean isLpushFormatBatch(ListRedisKey redisKey) {
        return isSingleFormat(redisKey) && isBatchValueList(redisKey);
    }

    private boolean isBatchValueList(ListRedisKey redisKey) {
        return CollectionUtil.isNotEmpty(redisKey.getValues());
    }
    private Long doHDelOrigin(HashRedisKey redisKey) {
        if(isBatchField(redisKey)){
            return doHDelOriginBatch(redisKey);
        }else if(isSingleField(redisKey)){
            return doHDelOriginSingle(redisKey);
        }
        return null;
    }

    private Long doHDelOriginSingle(HashRedisKey redisKey) {
        String fieldKey = "";
        if(isFormatField(redisKey.getField())){
            fieldKey = getFormatFieldKey(redisKey.getField());
        }else if(isOriginField(redisKey.getField())){
            fieldKey = redisKey.getField().getOriginKey();
        }
        if(StrUtil.isNotBlank(fieldKey)){
            return redisTemplate.opsForHash().delete(redisKey.getOriginKey(), fieldKey);
        }
        return null;
    }

    private Long doHDelOriginBatch(HashRedisKey redisKey) {
        String[] fieldKeys = getBatchFieldKey(redisKey);
        if(ArrayUtil.isNotEmpty(fieldKeys)){
            return redisTemplate.opsForHash().delete(redisKey.getOriginKey(), fieldKeys);
        }
        return null;
    }

    private Long doHDelFormatSingle(HashRedisKey redisKey) {
        String key = getFormatKey(redisKey);
        String fieldKey = "";
        if(isFormatField(redisKey.getField())){
            fieldKey = getFormatFieldKey(redisKey.getField());
        }else if(isOriginField(redisKey.getField())){
            fieldKey = redisKey.getField().getOriginKey();
        }
        if(StrUtil.isNotBlank(fieldKey)){
            return redisTemplate.opsForHash().delete(key, fieldKey);
        }
        return null;
    }

    private Long doHDelFormatBatch(HashRedisKey redisKey) {
        String key = getFormatKey(redisKey);
        String[] fieldKeys = getBatchFieldKey(redisKey);
        if(ArrayUtil.isNotEmpty(fieldKeys)){
            return redisTemplate.opsForHash().delete(key, fieldKeys);
        }
        return null;
    }

    private String[] getBatchFieldKey(HashRedisKey redisKey) {
        String[] fieldKeys = new String[redisKey.getFields().size()];
        int index = 0;
        for(HashRedisKeyField field : redisKey.getFields()){
            if(isFormatField(field)){
                String key = format(field.getKeyFormat(), field.getKeyValues());
                fieldKeys[index] = key;
                index ++;
            }else if(isOriginField(field)){
                fieldKeys[index] = field.getOriginKey();
                index ++;
            }
        }
        return fieldKeys;
    }

    private boolean isSingleField(HashRedisKey redisKey) {
        return ObjectUtil.isNotNull(redisKey.getField());
    }

    private boolean isBatchField(HashRedisKey redisKey) {
        return CollectionUtil.isNotEmpty(redisKey.getFields());
    }
    private Object doHGetOrigin(HashRedisKey redisKey) {
        if(isFormatField(redisKey.getField())){
            String fieldKey = getFormatFieldKey(redisKey.getField());
            return redisTemplate.opsForHash().get(redisKey.getOriginKey(), fieldKey);
        }else if(isOriginField(redisKey.getField())){
            return redisTemplate.opsForHash().get(redisKey.getOriginKey(), redisKey.getField().getOriginKey());
        }
        return null;
    }

    private Object doHGetFormat(HashRedisKey redisKey) {
        if(isFormatField(redisKey.getField())){
            String key = getFormatKey(redisKey);
            String fieldKey = getFormatFieldKey(redisKey.getField());
            return redisTemplate.opsForHash().get(key, fieldKey);
        }else if(isOriginField(redisKey.getField())){
            String key = getFormatKey(redisKey);
            return redisTemplate.opsForHash().get(key, redisKey.getField().getOriginKey());
        }
        return null;
    }

    private String getFormatFieldKey(HashRedisKeyField field) {
        return format(field.getKeyFormat(), field.getKeyValues());
    }

    private String getFormatKey(BaseRedisKey redisKey){
        return format(redisKey.getKeyFormat(), redisKey.getKeyValues());
    }

    private void doHSetOriginSingle(HashRedisKey redisKey) {
        String fieldKey = "";
        if(isFormatField(redisKey.getField())){
            fieldKey = format(redisKey.getField().getKeyFormat(), redisKey.getField().getKeyValues());
        }else if(isOriginField(redisKey.getField())){
            fieldKey = redisKey.getField().getOriginKey();
        }
        if(StrUtil.isNotBlank(fieldKey)){
            redisTemplate.opsForHash().put(redisKey.getOriginKey(), fieldKey, redisKey.getField().getValue());
        }
    }

    private void doHSetFormatSingle(HashRedisKey redisKey) {
        String fieldKey = "";
        if(isFormatField(redisKey.getField())){
            fieldKey = format(redisKey.getField().getKeyFormat(), redisKey.getField().getKeyValues());
        }else if(isOriginField(redisKey.getField())){
            fieldKey = redisKey.getField().getOriginKey();
        }
        if(StrUtil.isNotBlank(fieldKey)){
            String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
            redisTemplate.opsForHash().put(key, fieldKey, redisKey.getField().getValue());
        }
    }

    private boolean isFormatField(HashRedisKeyField field){
        return StrUtil.isNotBlank(field.getKeyFormat()) && ArrayUtil.isNotEmpty(field.getKeyValues());
    }
    private boolean isOriginField(HashRedisKeyField field){
        return StrUtil.isBlank(field.getKeyFormat()) && StrUtil.isNotBlank(field.getOriginKey());
    }

    private void doHSetOriginBatch(HashRedisKey redisKey) {
        Map<String, Object> map = getHSetBatchMap(redisKey);
        redisTemplate.opsForHash().putAll(redisKey.getOriginKey(), map);
    }

    private void doHSetFormatBatch(HashRedisKey redisKey) {
        Map<String, Object> map = getHSetBatchMap(redisKey);
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 是否是批量设置hash值
     * @param redisKey
     * @return
     */
    private boolean isHSetOriginBatch(HashRedisKey redisKey) {
        return isSingleOrigin(redisKey) && CollectionUtil.isNotEmpty(redisKey.getFields());
    }

    /**
     * 是否是单个设置hash值
     * @param redisKey
     * @return
     */
    private boolean isHSetOriginSingle(HashRedisKey redisKey) {
        return isSingleOrigin(redisKey) && ObjectUtil.isNotNull(redisKey.getField());
    }
    /**
     * 是否是批量设置hash值
     * @param redisKey
     * @return
     */
    private boolean isHSetFormatBatch(HashRedisKey redisKey) {
        return isSingleFormat(redisKey) && CollectionUtil.isNotEmpty(redisKey.getFields());
    }

    /**
     * 是否是单个设置hash值
     * @param redisKey
     * @return
     */
    private boolean isHSetFormatSingle(HashRedisKey redisKey) {
        return isSingleFormat(redisKey) && ObjectUtil.isNotNull(redisKey.getField());
    }

    private Map<String,Object> getHSetBatchMap(HashRedisKey redisKey) {
        Map<String, Object> map = new HashMap<>();
        for(HashRedisKeyField field : redisKey.getFields()){
            if(StrUtil.isNotBlank(field.getKeyFormat()) && ArrayUtil.isNotEmpty(field.getKeyValues())){
                String key = format(field.getKeyFormat(), field.getKeyValues());
                map.put(key, field.getValue());
            }else if(StrUtil.isBlank(field.getKeyFormat()) && StrUtil.isNotBlank(field.getOriginKey())){
                map.put(field.getOriginKey(), field.getValue());
            }
        }
        return map;
    }
    /**
     * 原生设置区间值
     * @param redisKey
     */
    private void doSetOriginRanage(StrRedisKey redisKey) {
        redisTemplate.opsForValue().set(redisKey.getOriginKey(), redisKey.getValue(), redisKey.getStartOffset());
    }

    /**
     * 格式化设置区间值
     * @param redisKey
     */
    private void doSetFormatRange(StrRedisKey redisKey) {
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        redisTemplate.opsForValue().set(key, redisKey.getValue(), redisKey.getStartOffset());
    }

    /**
     * 判断是否是原生区间设置值
     * @param redisKey
     * @return
     */
    private boolean isSetOriginRanage(StrRedisKey redisKey) {
        return isSingleOrigin(redisKey) && ObjectUtil.isNotNull(redisKey.getStartOffset());
    }

    /**
     * 判断是否是格式化区间设置值
     * @param redisKey
     * @return
     */
    private boolean isSetFormatRange(StrRedisKey redisKey) {
        return isSingleFormat(redisKey) && ObjectUtil.isNotNull(redisKey.getStartOffset());
    }
    /**
     * 原生获取全部数据
     * @param redisKey
     * @return
     */
    private boolean isGetOrigin(StrRedisKey redisKey) {
        return isSingleOrigin(redisKey);
    }
    /**
     * 原生获取区间数据
     * @param redisKey
     * @return
     */
    private boolean isGetOriginRange(StrRedisKey redisKey) {
        return isSingleOrigin(redisKey)
            && ObjectUtil.isNotNull(redisKey.getStartOffset())
            && ObjectUtil.isNotNull(redisKey.getEndOffset());
    }

    /**
     * 格式化获取全部数据
     * @param redisKey
     * @return
     */
    private boolean isGetFormat(StrRedisKey redisKey) {
        return isSingleFormat(redisKey);
    }

    /**
     * 格式化获取区间数据
     * @param redisKey
     * @return
     */
    private boolean isGetFormatRange(StrRedisKey redisKey) {
        return isSingleFormat(redisKey)
            && ObjectUtil.isNotNull(redisKey.getStartOffset())
            && ObjectUtil.isNotNull(redisKey.getEndOffset());
    }

    /**
     * 格式化带过期时间段的设置值
     * @param redisKey
     */
    private void doSetFormatAndExpire(StrRedisKey redisKey) {
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        redisTemplate.opsForValue().set(key, redisKey.getValue(), redisKey.getExpireSecond(), redisKey.getExpireSecondUnit());
    }

    /**
     * 格式化带过期时间点的设置值
     * @param redisKey
     */
    private void doSetFormatAndExpireAt(StrRedisKey redisKey) {
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        long milliSecond =  redisKey.getExpireDate().getTime() - DateUtil.current(false);
        redisTemplate.opsForValue().set(key, redisKey.getValue(), milliSecond, TimeUnit.MILLISECONDS);
    }
    /**
     * 原生带过期时间段设置
     * @param redisKey
     */
    private void doSetOriginAndExpire(StrRedisKey redisKey) {
        redisTemplate.opsForValue().set(redisKey.getOriginKey(), redisKey.getValue(), redisKey.getExpireSecond(), redisKey.getExpireSecondUnit());
    }
    /**
     * 原生带过期时间点设置
     * @param redisKey
     */
    private void doSetOriginAndExpireAt(StrRedisKey redisKey) {
        long milliSecond =  redisKey.getExpireDate().getTime() - DateUtil.current(false);
        redisTemplate.opsForValue().set(redisKey.getOriginKey(), redisKey.getValue(), milliSecond, TimeUnit.MILLISECONDS);
    }
    /**
     * 格式化永不过期设置
     * @param redisKey
     */
    private void dSetFormat(StrRedisKey redisKey) {
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        redisTemplate.opsForValue().set(key, redisKey.getValue());
    }
    /**
     * 原生永不过期设置
     * @param redisKey
     */
    private void doSetOrigin(StrRedisKey redisKey) {
        redisTemplate.opsForValue().set(redisKey.getOriginKey(), redisKey.getValue());
    }

    /**
     * 格式设置时间段
     * @param redisKey
     * @return
     */
    private boolean doExpireFormat(BaseRedisKey redisKey){
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        return redisTemplate.expire(key, redisKey.getExpireSecond(), redisKey.getExpireSecondUnit());
    }

    /**
     * 格式设置时间点
     * @param redisKey
     * @return
     */
    private boolean doExpireAtFormat(BaseRedisKey redisKey){
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        return redisTemplate.expireAt(key, redisKey.getExpireDate());
    }

    /**
     * 原生设置时间段
     * @param redisKey
     * @return
     */
    private boolean doExpireOrigin(BaseRedisKey redisKey){
        return redisTemplate.expire(redisKey.getOriginKey(), redisKey.getExpireSecond(), redisKey.getExpireSecondUnit());
    }

    /**
     * 原生设置时间点
     * @param redisKey
     * @return
     */
    private boolean doExpireAtOrigin(BaseRedisKey redisKey){
        return redisTemplate.expireAt(redisKey.getOriginKey(), redisKey.getExpireDate());
    }

    /**
     * 是否是格式化设置过期时间段
     * @param redisKey
     * @return
     */
    private boolean isExpireFormat(BaseRedisKey redisKey){
        return isSingleFormat(redisKey)
            && ObjectUtil.isNotNull(redisKey.getExpireSecond())
            && redisKey.getExpireSecond().intValue() > 0
            && ObjectUtil.isNotNull(redisKey.getExpireSecondUnit());
    }
    /**
     * 是否是格式化设置过期时间点
     * @param redisKey
     * @return
     */
    private boolean isExpireAtFormat(BaseRedisKey redisKey){
        return isSingleFormat(redisKey)
            && ObjectUtil.isNotNull(redisKey.getExpireDate());
    }
    /**
     * 是否是原生设置过期时间段
     * @param redisKey
     * @return
     */
    private boolean isExpireOrigin(BaseRedisKey redisKey){
        return isSingleOrigin(redisKey)
            && ObjectUtil.isNotNull(redisKey.getExpireSecond())
            && redisKey.getExpireSecond().intValue() > 0
            && ObjectUtil.isNotNull(redisKey.getExpireSecondUnit());
    }
    /**
     * 是否是原生设置过期时间点
     * @param redisKey
     * @return
     */
    private boolean isExpireAtOrigin(BaseRedisKey redisKey){
        return isSingleOrigin(redisKey)
            && ObjectUtil.isNotNull(redisKey.getExpireDate());
    }

    /**
     * 批量格式删除
     * @param redisKey
     */
    private void doDeleteBatchFormat(BaseRedisKey redisKey){
        Set<String> keySet = getFormatBatchKeyValues(redisKey);
        redisTemplate.delete(keySet);
    }
    private Set<String> getFormatBatchKeyValues(BaseRedisKey redisKey){
        Set<String> keySet = new HashSet<>();
        for(String[] strs : redisKey.getBatchKeyValues()){
            String key = format(redisKey.getKeyFormat(), strs);
            keySet.add(key);
        }
        return keySet;
    }
    /**
     * 单个格式删除
     * @param redisKey
     */
    private void doDeleteSingleFormat(BaseRedisKey redisKey){
        String key = format(redisKey.getKeyFormat(), redisKey.getKeyValues());
        redisTemplate.delete(key);
    }
    /**
     * 批量原生删除
     * @param redisKey
     */
    private void doDeleteBatchOrigin(BaseRedisKey redisKey){
        redisTemplate.delete(redisKey.getBatchOriginKey());
    }
    /**
     * 单个原生删除
     * @param redisKey
     */
    private void doDeleteSingleOrigin(BaseRedisKey redisKey){
        redisTemplate.delete(redisKey.getOriginKey());
    }
    /**
     * 是否是批量format操作
     * @param redisKey
     * @return
     */
    private boolean isBatchFormat(BaseRedisKey redisKey){
        return StrUtil.isNotBlank(redisKey.getKeyFormat())
            && CollectionUtil.isNotEmpty(redisKey.getBatchKeyValues());
    }
    /**
     * 是否是单个format操作
     * @param redisKey
     * @return
     */
    private boolean isSingleFormat(BaseRedisKey redisKey){
        return StrUtil.isNotBlank(redisKey.getKeyFormat())
            && ArrayUtil.isNotEmpty(redisKey.getKeyValues());
    }
    /**
     * 是否是批量原生操作
     * @param redisKey
     * @return
     */
    private boolean isBatchOrigin(BaseRedisKey redisKey){
        return StrUtil.isBlank(redisKey.getKeyFormat())
            && CollectionUtil.isNotEmpty(redisKey.getBatchOriginKey());
    }
    /**
     * 是否是单个原生操作
     * @param redisKey
     * @return
     */
    private boolean isSingleOrigin(BaseRedisKey redisKey){
        return StrUtil.isBlank(redisKey.getKeyFormat())
            && StrUtil.isNotBlank(redisKey.getOriginKey());
    }

    /**
     * 格式化Key
     */
    private String format(String formatKey, String... keyValues) {
        if (keyValues == null || keyValues.length == 0) {
            return formatKey;
        }
        StringBuilder key = new StringBuilder();
        char[] chars = formatKey.toCharArray();
        int index = -1;
        boolean inmark = false;
        boolean firstinmark = false;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '{') {
                index++;
                inmark = true;
                firstinmark = true;
            } else if (ch == '}') {
                inmark = false;
            } else if (inmark) {
                if (firstinmark) {
                    firstinmark = false;
                    key.append(keyValues[index]);
                }
            } else {
                key.append(chars[i]);
            }
        }
        return key.toString();
    }

    private String stepFormat(String formatKey, String... keyValues) {
        if (keyValues == null || keyValues.length == 0) {
            return formatKey;
        }
        StringBuilder key = new StringBuilder();
        char[] chars = formatKey.toCharArray();
        int index = -1;
        boolean inmark = false;
        boolean firstinmark = false;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '{') {
                index++;
                inmark = true;
                firstinmark = true;
            } else if (ch == '}') {
                inmark = false;
            } else if (inmark) {
                if (firstinmark) {
                    firstinmark = false;
                    if(index<keyValues.length){
                        key.append(keyValues[index]);
                    }else {
                        key.append(chars,i-1,chars.length-i+1);
                    }
                }
            } else {
                key.append(chars[i]);
            }
        }
        return key.toString();
    }
}
