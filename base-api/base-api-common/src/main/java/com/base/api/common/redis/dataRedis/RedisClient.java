package com.base.api.common.redis.dataRedis;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * redis 操作类
 * User: hqm
 * Date: 2017/6/14
 *
 */
@Component
public class RedisClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisClient.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /*************************************key 操作******************************************/

    /**
     * @param keyFormat
     * @param keyValues
     */
    public void del(String keyFormat, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.delete(key);
    }

    /**
     * 设置key的过期时间
     *
     * @param keyFormat
     * @param keyValues
     */
    public void expire(String keyFormat, Integer seconds, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     * 在指定点时间点过期
     *
     * @param keyFormat
     * @param date
     * @param keyValues
     */
    public void expireAt(String keyFormat, Date date, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.expireAt(key, date);
    }

    /*************************************String 操作******************************************/

    /**
     * 指定key设置值
     * keyFormat KEY的格式如:KEY_{ID}_{USERID} 如果keyValues是 1234，5432 最后生成的cache key是：KEY_1234_5432
     *
     * @param keyFormat
     * @param keyValues
     */
    public void set(String keyFormat, Object value, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForValue().set(key, value);
    }


    /**
     * 指定点key设置值,并且设置过期时间
     * keyFormat KEY的格式如:KEY_{ID}_{USERID} 如果keyValues是 1234，5432 最后生成的cache key是：KEY_1234_5432
     *
     * @param keyFormat     KEY的格式如:KEY{ID}
     * @param keyValues     如：1234，最后生成：KEY1234
     * @param expireSeconds 失效时间
     * @param value         实际的值
     */
    public void set(String keyFormat, Object value, long expireSeconds, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
    }

    /**
     * keyFormat KEY的格式如:KEY_{ID}_{USERID} 如果keyValues是 1234，5432 最后生成的cache key是：KEY_1234_5432
     *
     * @param keyFormat
     * @param keyValues
     * @param <T>
     * @return
     */
    public <T> T get(String keyFormat, String... keyValues) {
        String key = format(keyFormat, keyValues);
        Object o = redisTemplate.opsForValue().get(key);
        if (o != null) {
            return (T) o;
        }
        return null;
    }

    /**
     *计数器
     */

    /**
     * keyFormat KEY的格式如:KEY_{ID}_{USERID} 如果keyValues是 1234，5432 最后生成的cache key是：KEY_1234_5432
     * 专用于计数器数值的获取
     *
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Long getNumber(String keyFormat, String... keyValues) {

        String key = format(keyFormat, keyValues);
        String result = (String) redisTemplate.opsForValue().get(key);
        if (result != null) {
            return Long.valueOf(result);
        }
        return 0L;
    }


    /**
     * 计数器的初始化
     * keyFormat KEY的格式如:KEY_{ID}_{USERID} 如果keyValues是 1234，5432 最后生成的cache key是：KEY_1234_5432
     *
     * @param keyFormat
     * @param keyValues
     */
    public void setNumber(String keyFormat, Long value, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForValue().set(key, String.valueOf(value));
    }

    /**
     * 计数器的初始化
     * keyFormat KEY的格式如:KEY_{ID}_{USERID} 如果keyValues是 1234，5432 最后生成的cache key是：KEY_1234_5432
     *
     * @param keyFormat     KEY的格式如:KEY{ID}
     * @param keyValues     如：1234，最后生成：KEY1234
     * @param expireSeconds 失效时间
     * @param value         实际的值
     */
    public void setNumber(String keyFormat, Long value, long expireSeconds, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
    }


    /**
     * 计数器，自增计数
     *
     * @param keyFormat
     * @param value
     * @param keyValues
     */
    public Long incrBy(String keyFormat, Long value, String... keyValues) {
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForValue().increment(key, value);
    }


    /**********************************set操作*******************************************/
    /**
     * 获取set中所有的集合
     *
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Set<String> sMembers(String keyFormat, String... keyValues) {
        String key = format(keyFormat, keyValues);
        Set<String> values = redisTemplate.opsForSet().members(key);
        return values;
    }

    /**
     * 查询key的数量
     *
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Long scard(String keyFormat, String... keyValues) {
        String key = format(keyFormat, keyValues);
        Long count = redisTemplate.opsForSet().size(key);
        if (count == null) {
            return 0L;
        }
        return count;
    }


    /**
     * 求所有所有key的并集
     *
     * @param keys
     * @return
     */
    public Set<String> sUnion(Set<String> keys) {
        String key = "";
        Set<String> values = redisTemplate.opsForSet().union(key, keys);
        return values;
    }

    /**
     * 求所有keys的并集，结果存入指定的key
     *
     * @param keys
     * @param resultKey
     * @return
     */
    public Long sUnionAndStore(Set<String> keys, String resultKey) {
        if (CollectionUtils.isEmpty(keys)) {
            return -1L;
        }

        String key = keys.iterator().next();
        keys.remove(key);

        Long result = redisTemplate.opsForSet().unionAndStore(key, keys, resultKey);
        return result;
    }


    /**
     * key1与key2的差集
     *
     * @param key1
     * @param key2
     * @return
     */
    public Set<String> sDiff(String key1, String key2) {
        Set<String> values = redisTemplate.opsForSet().difference(key1, key2);
        return values;
    }

    /**
     * 向集合添加元素
     *
     * @param key1
     * @param value
     * @param keyValues
     * @return
     */
    public Long sAdd(String key1, String value, String... keyValues) {
        String key = format(key1, keyValues);
        Long result = redisTemplate.opsForSet().add(key, value);
        return result;
    }

    /**
     * 移除单个元素
     *
     * @param key1
     * @param value
     * @param keyValues
     * @return
     */
    public Long sRem(String key1, String value, String... keyValues) {
        String key = format(key1, keyValues);
        return redisTemplate.opsForSet().remove(key, value);
    }


    /**********************************zset操作*******************************************/


    /**
     * *******************************List操作******************************************
     */


    /*********************************hash操作******************************************/


    /**
     * 将HashMap中的Key对应的Value加上一个值
     *
     * @param keyFormat
     * @param field
     * @param value
     * @param keyValues
     */
    public void hIncrBy(String keyFormat, String field, long value,
                        String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForHash().increment(key, field, value);
    }

    /**
     * 删除HashMap field字段
     *
     * @param keyFormat
     * @param field
     * @param keyValues
     */
    public void hDel(String keyFormat, String field, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForHash().delete(key, field);
    }


    /**
     * 获取HashMap 所有值
     *
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Map<String, String> hGetAll(String keyFormat, String... keyValues) {
        String key = format(keyFormat, keyValues);
        Map<String, String> result = redisTemplate.opsForHash().entries(key);
        return result;
    }

    /**
     * @param keyFormat
     * @param hashKey
     * @param keyValues
     * @return
     */
    public void hPut(String keyFormat, String hashKey, String value, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForHash().put(key, hashKey, value);
    }


    /**
     * 获取分布式锁
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public boolean getDistributedLock(String keyFormat,String... keyValues){

        String key = format(keyFormat, keyValues);

        try {
            String value=String.valueOf(System.currentTimeMillis());

            while (true){
                Boolean getLock=redisTemplate.opsForValue().setIfAbsent(key, value);
                if(getLock){
                    //获取锁成功
                    LOGGER.debug(Thread.currentThread().getName() + " get distributed lock success a");
                    return true;
                }else {
                    //获取锁失败
                    LOGGER.debug(Thread.currentThread().getName() + " get distributed lock fail b");

                    while (true){
                        Object t1Object=redisTemplate.opsForValue().get(key);
                        long t1,t2=0;
                        if(t1Object!=null){
                            t1=Long.parseLong(t1Object.toString());
                            if(System.currentTimeMillis()-t1>3000){
                                //锁过期
                                LOGGER.debug(Thread.currentThread().getName() + " get distributed lock expire c");

                                Object t2Object= redisTemplate.opsForValue().getAndSet(key, System.currentTimeMillis());
                                if(t2Object!=null){
                                    t2=Long.parseLong(t2Object.toString());
                                    if(t1==t2){
                                        //获得锁
                                        LOGGER.debug(Thread.currentThread().getName() + " get distributed lock success d");

                                        return true;
                                    }else {
                                        //在这之前已经有其他客户端获取锁，等待重试
                                        LOGGER.debug(Thread.currentThread().getName() + " get distributed lock retry e");

                                        try {
                                            Thread.sleep(50);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }else {
                                    //锁被释放，可以获得锁
                                    LOGGER.debug(Thread.currentThread().getName() + " get distributed lock retry f");

                                    break;
                                }
                            }else {
                                //锁正在有效期被其他客户端使用，等待重试
                                LOGGER.debug(Thread.currentThread().getName() + " get distributed lock retry h");

                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }else {
                            //锁被释放，可以进行获取锁操作
                            LOGGER.debug(Thread.currentThread().getName()+" get distributed lock retry i");

                            break;
                        }
                    }
                }
            }
        }catch (Exception ex){
            LOGGER.error(ex.getMessage(),ex);
            return true;
        }
    }

    public boolean tryGetDistributedLock(String keyFormat,String... keyValues){
        String key = format(keyFormat, keyValues);
        String value=String.valueOf(System.currentTimeMillis());

        Boolean getLock=redisTemplate.opsForValue().setIfAbsent(key, value);
        if(getLock){
            //获取锁成功
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public boolean releaseDistributedLock(String keyFormat,String... keyValues){
        String key = format(keyFormat, keyValues);
        redisTemplate.delete(key);

        LOGGER.info(Thread.currentThread().getName() + " release distributed lock");

        return true;
    }




    /**
     * 格式化Key
     */
    public static String format(String formatKey, String... keyValues) {
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

    public static String stepFormat(String formatKey, String... keyValues) {
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

    /*********************************补充方法**********************************/
    /*********************************String补充********************************/
    /**
     * <p>判断key是否存在</p>
     * @param keyFormat 格式化格式
     * @param keyValues key的原生字符串
     * @return true OR false
     */
    public Boolean exists(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.hasKey(key);
    }

    /**
     * <p>通过key向指定的value值追加值</p>
     * @param keyFormat 格式化格式
     * @param value 要追加的值
     * @param keyValues 要追加的key的原生字符串
     * @return 成功返回 添加后value的长度 失败 返回 添加的 value 的长度  异常返回0L
     */
    public Integer append(String keyFormat, String value ,String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForValue().append(key,value);
    }

    /**
     * <p>设置key value,如果key已经存在则返回false,nx==> not exist</p>
     * @param keyFormat 格式化格式
     * @param value 要追加的值
     * @param keyValues 要追加的key的原生字符串
     * @return 成功返回true 如果存在 和 发生异常 返回 false
     */
    public boolean setIfAbsent(String keyFormat, String value, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * <p>通过key 和offset 从指定的位置开始将原先value替换</p>
     * <p>下标从0开始,offset表示从offset下标开始替换</p>
     * <p>如果替换的字符串长度过小则会这样</p>
     * <p>example:</p>
     * <p>value : bigsea@zto.cn</p>
     * <p>str : abc </p>
     * <P>从下标7开始替换  则结果为</p>
     * <p>RES : bigsea.abc.cn</p>
     * @param keyFormat 格式化格式
     * @param value 值
     * @param offset 下标位置
     * @param keyValues key的原生值
     * @return 返回替换后  value 的长度
     */
    public void setRange(String keyFormat, Object value, long offset, String... keyValues) {
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForValue().set(key, value, offset);
    }

    /**
     * <p>通过批量的key获取批量的value</p>
     * 此方法中的key是keyFormat之后的key
     * @param keys 批量的集合key
     * @return 成功返回value的集合, 失败返回null的集合 ,异常返回空
     */
    public List multiGet(Collection keys){
        return redisTemplate.opsForValue().multiGet(keys);
    }
    /**
     * <p>批量的设置key:value,可以一个</p>
     * 此方法中的key是keyFormat之后的key
     * @param m 要设置的元素的key和value
     *
     */
    public void multiSet(Map m){
        redisTemplate.opsForValue().multiSet(m);
    }

    /**
     * <p>批量的设置key:value,可以一个,如果key已经存在则会失败,操作会回滚</p>
     * 此方法中的key是keyFormat之后的key
     * @param m 要设置的元素的key和value
     * @return 成功返回true 失败返回false
     */
    public Boolean multiSetIfAbsent(Map m){
        return redisTemplate.opsForValue().multiSetIfAbsent(m);
    }

    /**
     * <p>设置key的值,并返回一个旧值</p>
     * @param keyFormat 格式化格式
     * @param value 值
     * @param keyValues 要设置的值
     * @return 旧值 如果key不存在 则返回null
     */
    public Object getAndSet(String keyFormat, String value, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * <p>通过下标 和key 获取指定下标位置的 value</p>
     * @param keyFormat
     * @param startOffset 开始位置 从0 开始 负数表示从右边开始截取
     * @param endOffset
     * @param keyValues
     * @return 如果没有返回null
     */
    public String getRange(String keyFormat, int startOffset ,int endOffset, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForValue().get(key, startOffset, endOffset);
    }

    /**
     * <p>通过key获取value值的长度</p>
     * @param keyFormat
     * @param keyValues
     * @return 失败返回null
     */
    public Long serlen(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForValue().size(key);
    }

    /*********************************Hash补充***********************************/
    /**
     * <p>通过key给field设置指定的值,如果key不存在则先创建,如果field已经存在,返回0</p>
     * @param keyFormat
     * @param field
     * @param value
     * @param keyValues
     * @return
     */
    public Boolean putIfAbsent(String keyFormat, String field, String value, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForHash().putIfAbsent(key, field, value);
    }

    /**
     * <p>通过key同时设置 hash的多个field</p>
     * @param keyFormat
     * @param hash
     * @param keyValues
     * @return 返回OK 异常返回null
     */
    public void putAll(String keyFormat, Map hash, String... keyValues){
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForHash().putAll(key, hash);
    }

    /**
     * <p>通过key 和 field 获取指定的 value</p>
     * @param keyFormat
     * @param field
     * @param keyValues
     * @return 没有返回null
     */
    public Object hget(String keyFormat, String field, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * <p>通过key 和 fields 获取指定的value 如果没有对应的value则返回null</p>
     * @param keyFormat
     * @param fields
     * @param keyValues
     * @return
     */
    public List hmget(String keyFormat, Collection fields, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForHash().multiGet(key, fields);
    }

    /**
     * <p>通过key和field判断是否有指定的value存在</p>
     * @param keyFormat
     * @param field
     * @param keyValues
     * @return
     */
    public Boolean hexists(String keyFormat, String field, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * <p>通过key返回field的数量</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Long hlen(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * <p>通过key返回所有的field</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Set hkeys(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForHash().keys(key);
    }

    /*********************************list补充***********************************/
    /**
     * <p>通过key向list头部添加字符串</p>
     * @param keyFormat
     * @param value
     * @return 返回list的value个数
     */
    public Long lpush(String keyFormat, Object value, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().leftPush(key, value);
    }
    /**
     * <p>通过key向list头部添加字符串</p>
     * @param keyFormat
     * @param values
     * @return 返回list的value个数
     */
    public Long lpushAll(String keyFormat, Collection values, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * <p>在pivot之前插入元素</p>
     * @param keyFormat
     * @param pivot list里面的value
     * @param value 添加的value
     * @param value keyValues
     * @return
     */
    public Long linsert(String keyFormat, String pivot, String value, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    /**
     * <p>通过key设置list指定下标位置的value</p>
     * <p>如果下标超过list里面value的个数则报错</p>
     * @param keyFormat
     * @param index 从0开始
     * @param value
     * @param keyValues
     */
    public void lset(String keyFormat, Long index, String value, String... keyValues){
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForList().set(key, index,value);
    }

    /**
     * <p>通过key从对应的list中删除指定的count个 和 value相同的元素</p>
     * @param keyFormat
     * @param count 当count为0时删除全部
     * @param value
     * @param keyValues
     * @return 返回被删除的个数
     */
    public Long lrem(String keyFormat, long count,String value, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().remove(key,count,value);
    }

    /**
     * <p>通过key保留list中从strat下标开始到end下标结束的value值</p>
     * @param keyFormat
     * @param start
     * @param end
     * @param keyValues
     */
    public void ltrim(String keyFormat, long start ,long end, String... keyValues){
        String key = format(keyFormat, keyValues);
        redisTemplate.opsForList().trim(key, start, end);
    }

    /**
     * <p>通过key从list的头部删除一个value,并返回该value</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Object lpop(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * <p>通过key从list尾部删除一个value,并返回该元素</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Object rpop(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * <p>通过key获取list中指定下标位置的value</p>
     * @param keyFormat
     * @param index
     * @param keyValues
     * @return 如果没有返回null
     */
    public Object lindex(String keyFormat, long index, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * <p>通过key返回list的长度</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Long llen(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().size(key);
    }
    /**
     * <p>通过key获取list指定下标位置的value</p>
     * <p>如果start 为 0 end 为 -1 则返回全部的list中的value</p>
     * @param keyFormat
     * @param start
     * @param end
     * @param keyValues
     * @return
     */
    public List lrange(String keyFormat, long start,long end, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForList().range(key, start, end);
    }

    /*********************************set补充***********************************/
    /**
     * <p>通过key随机删除一个set中的value并返回该值</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Object spop(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * <p>通过key判断value是否是set中的元素</p>
     * @param keyFormat
     * @param member
     * @param keyValues
     * @return
     */
    public Boolean sismember(String keyFormat, String member, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForSet().isMember(key, member);
    }

    /**
     * <p>通过key获取set中随机的value,不删除元素</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Object srandmember(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * <p>通过key获取set中所有的value</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Set smembers(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForSet().members(key);
    }

    /*********************************zset补充***********************************/
    /**
     * <p>通过key向zset中添加value,score,其中score就是用来排序的</p>
     * <p>如果该value已经存在则根据score更新元素</p>
     * @param keyFormat
     * @param score
     * @param member
     * @param keyValues
     * @return
     */
    public Boolean zadd(String keyFormat, double score,String member, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().add(key, member, score);
    }

    /**
     * <p>通过key删除在zset中指定的value</p>
     * @param keyFormat
     * @param values
     * @param keyValues
     * @return
     */
    public Long zrem(String keyFormat, Collection values, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().remove(key, values);
    }

    /**
     * <p>通过key增加该zset中value的score的值</p>
     * @param keyFormat
     * @param score
     * @param member
     * @param keyValues
     * @return
     */
    public Double zincrby(String keyFormat, double score, String member, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().incrementScore(key, member, score);
    }

    /**
     * <p>通过key返回zset中value的排名</p>
     * <p>下标从小到大排序</p>
     * @param keyFormat
     * @param member
     * @param keyValues
     * @return
     */
    public Long zrank(String keyFormat, String member, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().rank(key, member);
    }

    /**
     * <p>通过key将获取score从start到end中zset的value</p>
     * <p>socre从大到小排序</p>
     * <p>当start为0 end为-1时返回全部</p>
     * @param keyFormat
     * @param start
     * @param end
     * @param keyValues
     * @return
     */
    public Set zrevrange(String keyFormat, long start ,long end, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * <p>通过key返回指定score内zset中的value</p>
     * @param keyFormat
     * @param min
     * @param max
     * @param keyValues
     * @return
     */
    public Set zrangebyscore(String keyFormat, double min, double max, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * <p>返回指定区间内zset中value的数量</p>
     * @param keyFormat
     * @param min
     * @param max
     * @param keyValues
     * @return
     */
    public Long zcount(String keyFormat, double min,double max, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    /**
     * <p>通过key返回zset中的value个数</p>
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public Long zcard(String keyFormat, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().zCard(key);
    }

    /**
     * <p>通过key获取zset中value的score值</p>
     * @param keyFormat
     * @param member
     * @param keyValues
     * @return
     */
    public Double zscore(String keyFormat, String member, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().score(key, member);
    }

    /**
     * <p>通过key删除给定区间内的元素</p>
     * @param keyFormat
     * @param start
     * @param end
     * @param keyValues
     * @return
     */
    public Long zremrangeByRank(String keyFormat, long start, long end, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    /**
     * <p>通过key删除指定score内的元素</p>
     * @param keyFormat
     * @param start
     * @param end
     * @param keyValues
     * @return
     */
    public Long zremrangeByScore(String keyFormat, double start,double end, String... keyValues){
        String key = format(keyFormat, keyValues);
        return redisTemplate.opsForZSet().removeRangeByScore(key, start, end);
    }

    /**
     * <p>返回满足pattern表达式的所有key</p>
     * <p>keys(*)</p>
     * <p>返回所有的key</p>
     * @param pattern
     * @return
     */
    public Set keys(Object pattern){
        return redisTemplate.keys(pattern);
    }
}
