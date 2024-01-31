package com.yocy.maker.model;

import lombok.Data;

/**
 * 动态模板配置
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
@Data
public class DataModel {

    /**
     * 是否生成 .gitignore 文件
     */
    public boolean needGit = false;

    /**
     * 是否循环
     */
    public boolean loop;

    /**
     * 核心模板
     */
    public MainTemplate mainTemplate;
    
    @Data
    public static class MainTemplate {
        /**
         * 作者注释
         */
        public String author = "youngcy";

        /**
         * 输出信息
         */
        public String outoutText = "sum = ";
    }
    
}
