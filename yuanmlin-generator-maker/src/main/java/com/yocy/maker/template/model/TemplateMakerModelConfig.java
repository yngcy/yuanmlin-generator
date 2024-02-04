package com.yocy.maker.template.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 模板生成模型配置类
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description
 */
@Data
public class TemplateMakerModelConfig {
    
    private List<ModelInfoConfig> models;
    
    private ModelGroupConfig modelGroupConfig;
    
    @NoArgsConstructor
    @Data
    public static class ModelInfoConfig {
        
        private String fieldName;
        
        private String type;
        
        private String description;
        
        private String abbr;
        
        private Object defaultValue;
        
        // 用于替换哪些文本
        private String replaceText;
    }
    
    @Data
    public static class ModelGroupConfig {
        
        private String condition;
        
        private String groupKey;
        
        private String groupName;
        
        private String type;
        
        private String description;
    }
    
}
