package com.yocy.web.model.dto.generator;

import lombok.Data;

import java.io.Serializable;

/**
 * 缓存代码生成请求
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Data
public class GeneratorCacheRequest implements Serializable {

    /**
     * 生成器id
     */
    private Long id;
    
    private static final long serialVersionUID = 1L;
}
