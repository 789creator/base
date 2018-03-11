package com.base.api.common.exception;

import com.base.api.common.rtf.bean.RtfErrorResponse;

/**
 * 融托富请求结果异常
 *
 * @author zhj
 * @date 2017/12/11.`
 */
public class RtfResponseException extends RuntimeException {

    private RtfErrorResponse errorResponse;

    /**
     * 融托富接口请求参数
     */
    private String rtfRequestParam;

    public RtfResponseException(String errorMsg) {
        super (errorMsg);
    }

    public RtfResponseException(RtfErrorResponse errorResponse) {
        super (errorResponse.getErrorMsg ());
        this.errorResponse = errorResponse;
    }
    public RtfResponseException(RtfErrorResponse errorResponse,String rtfRequestParam) {
        super (errorResponse.getErrorMsg ());
        this.errorResponse = errorResponse;
        this.rtfRequestParam = rtfRequestParam;
    }

    public RtfErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(RtfErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public String getRtfRequestParam() {
        return rtfRequestParam;
    }

    public void setRtfRequestParam(String rtfRequestParam) {
        this.rtfRequestParam = rtfRequestParam;
    }
}
