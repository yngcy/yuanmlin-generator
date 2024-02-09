package com.yocy.web.model.dto.generator;

import com.yocy.maker.meta.Meta;
import lombok.Data;

/**
 * 制作代码生成器请求
 * 
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Data
public class GeneratorMakeRequest {

    /**
     * 元信息
     */
    private Meta meta;

    /**
     * 模板文件压缩包路径
     */
    private String zipFilePath;
    
    
    
    private static final long serialVersionUID = 1L;
}
