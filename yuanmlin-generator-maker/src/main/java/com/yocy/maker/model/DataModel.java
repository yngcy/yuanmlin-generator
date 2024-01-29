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
     * 是否循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = "YounGCY";

    /**
     * 输出文本
     */
    private String outputText = "sum = ";
}
