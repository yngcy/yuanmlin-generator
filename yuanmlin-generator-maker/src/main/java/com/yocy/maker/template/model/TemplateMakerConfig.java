package com.yocy.maker.template.model;

import com.yocy.maker.meta.Meta;
import lombok.Data;

/**
 * 模板制作配置
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Data
public class TemplateMakerConfig {
    
    private Long id;
    
    private Meta meta = new Meta();
    
    private String originProjectPath;
    
    TemplateMakerFileConfig fileConfig = new TemplateMakerFileConfig();
    
    TemplateMakerModelConfig modelConfig = new TemplateMakerModelConfig();
    
    TemplateMakerOutputConfig outputConfig = new TemplateMakerOutputConfig();
}
