package com.yocy.maker.template.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 模板生成文件配置类
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description 用于封装所有和文件相关的配置
 */
@Data
public class TemplateMakerFileConfig {
    
    private List<FileInfoConfig> files;
    
    private FileGroupConfig fileGroupConfig;
    
    @NoArgsConstructor
    @Data
    public static class FileInfoConfig {
        
        private String path;
        
        private List<FileFilterConfig> fileFilterConfigList;
    }
    
    @Data
    public static class FileGroupConfig {
        
        private String condition;
        
        private String groupKey;
        
        private String groupName;
    }
}
