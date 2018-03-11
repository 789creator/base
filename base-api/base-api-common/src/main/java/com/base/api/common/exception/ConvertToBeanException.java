package com.base.api.common.exception;

/**
 * 通过泛型操作设置到bean中 异常
 *
 * @author zhj
 * @date 2017/12/11.
 */
public class ConvertToBeanException extends RuntimeException {
    public ConvertToBeanException(String message) {
        super (message);
    }
}
