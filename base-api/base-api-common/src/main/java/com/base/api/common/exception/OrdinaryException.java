package com.base.api.common.exception;

/**
 * 普通业务异常
 *
 * @author zhj
 * @date 2017/12/13
 */
public class OrdinaryException extends RuntimeException{

    public OrdinaryException(String message){
        super(message);
    }
}
