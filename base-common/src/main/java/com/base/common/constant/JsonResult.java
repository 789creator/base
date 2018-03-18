package com.base.common.constant;


/**
 * json结果封装类
 */
public class JsonResult {

    /**
     * 状态码：1成功，其他为失败
     */
    public int code;

    /**
     * 成功为success，其他为失败原因
     */
    public String message;

    /**
     * 数据结果集
     */
    public Object data;

    public JsonResult() {
        this.code = JsonResultConstant.SUCCESS.getCode();
        this.message = JsonResultConstant.SUCCESS.getMessage();
    }

    public JsonResult(JsonResultConstant jsonResultConstant) {
        this.code = jsonResultConstant.getCode();
        this.message = jsonResultConstant.getMessage();
    }

    public JsonResult(JsonResultConstant jsonResultConstant, Object object) {
        this.code = jsonResultConstant.getCode();
        this.message = jsonResultConstant.getMessage();
        this.data = object;
    }

    public JsonResult(JsonResultConstant jsonResultConstant, String message, Object object) {
        this.code = jsonResultConstant.getCode();
        this.message = message;
        this.data = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
