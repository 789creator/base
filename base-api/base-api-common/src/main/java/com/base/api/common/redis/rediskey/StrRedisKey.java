package com.base.api.common.redis.rediskey;

/**
 * Created by WangSheng on 2017/7/5.
 *
 * @author WangSheng
 * @date 2017/07/05
 */
public class StrRedisKey extends BaseRedisKey {
    private String value;
    /**
     * 开始位置 从0 开始 负数表示从右边开始截取
     */
    private Long startOffset;
    /**
     * 结束位置
     */
    private Long endOffset;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(Long startOffset) {
        this.startOffset = startOffset;
    }

    public Long getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(Long endOffset) {
        this.endOffset = endOffset;
    }
}
