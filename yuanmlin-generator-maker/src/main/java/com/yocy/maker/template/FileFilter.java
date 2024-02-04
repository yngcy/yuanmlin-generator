package com.yocy.maker.template;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import com.yocy.maker.template.enums.FileFilterRangeEnum;
import com.yocy.maker.template.enums.FileFilterRuleEnum;
import com.yocy.maker.template.model.FileFilterConfig;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件过滤类
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description 用于对文件过滤、校验
 */
public class FileFilter {

    /**
     * 单个文件过滤
     * @param fileFilterConfigList 过滤规则
     * @param file 校验的文件
     * @return 是否保留
     */
    
    public static boolean doSingleFileFilter(List<FileFilterConfig> fileFilterConfigList, File file) {
        String fieldName = file.getName();
        String fileContent = FileUtil.readUtf8String(file);
        
        // 所有规律器校验结束的结果
        boolean result = true;
        if (CollUtil.isEmpty(fileFilterConfigList)) {
            return true;
        }
        
        for (FileFilterConfig fileFilterConfig : fileFilterConfigList) {
            String range = fileFilterConfig.getRange();
            String rule = fileFilterConfig.getRule();
            String value = fileFilterConfig.getValue();

            FileFilterRangeEnum fileFilterRangeEnum = FileFilterRangeEnum.getEnumByValue(range);
            if (fileFilterRangeEnum == null) {
                continue;
            }
            
            // 要过滤的原内容
            String content = file.getName();
            switch (fileFilterRangeEnum) {
                case FILE_NAME:
                    content = fieldName;
                    break;
                case FILE_CONTENT:
                    content = fileContent;
                    break;
            }
            
            FileFilterRuleEnum fileFilterRuleEnum = FileFilterRuleEnum.getEnumByValue(rule);
            if (fileFilterRuleEnum == null) {
                continue;
            }
            switch (fileFilterRuleEnum) {
                case CONTAINS:
                    result = content.contains(value);
                    break;
                case START_WITH:
                    result = content.startsWith(value);
                    break; 
                case END_WITH:
                    result = content.endsWith(value);
                    break;
                case REGEX:
                    result = content.matches(value);
                    break;
                case EQUALS:
                    result = content.equals(value);
                    break;
            }
            
            // 如果有一个不满足，直接返回
            if (!result) {
                return false;
            }
        }
        
        // 都满足
        return true;
    }

    /**
     * 对某个文件或目录进行过滤，返回文件列表
     * @param filePath 文件或目录
     * @param fileFilterConfigList 校验配置列表
     * @return 过滤后的文件列表
     */
    public static List<File> doFilter(String filePath, List<FileFilterConfig> fileFilterConfigList) {
        // 根据路径获取所有文件
        List<File> fileList = FileUtil.loopFiles(filePath);
        return fileList.stream()
                .filter(file -> doSingleFileFilter(fileFilterConfigList, file))
                .collect(Collectors.toList());
    }
}
