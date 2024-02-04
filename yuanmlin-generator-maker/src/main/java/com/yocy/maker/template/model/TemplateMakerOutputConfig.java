package com.yocy.maker.template.model;

import lombok.Data;

/**
 * 生成模板输出配置
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Data
public class TemplateMakerOutputConfig {
    
    // 从未分组的文件中移出组内的同名文件
    private boolean removeGroupFilesFromRoot = true;
}
