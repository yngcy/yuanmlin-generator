package com.yocy.web.model.dto.generator;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 使用代码生成器请求
 *
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 */
@Data
public class GeneratorUseRequest implements Serializable {

    /**
     * 生成器 id
     */
    private Long id;

    /**
     * 数据模型
     */
    Map<String, Object> dataModel;
    

    private static final long serialVersionUID = 1L;
}