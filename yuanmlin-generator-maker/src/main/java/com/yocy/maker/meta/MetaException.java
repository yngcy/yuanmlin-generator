package com.yocy.maker.meta;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description
 */
public class MetaException extends RuntimeException {
    public MetaException(String message) {
        super(message);
    }
    
    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
