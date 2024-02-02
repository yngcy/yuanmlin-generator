package com.yocy.maker.template.enums;

import cn.hutool.core.util.ObjectUtil;

/**
 * 文件类型枚举
 *
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description
 */
public enum FileFilterRuleEnum {
    CONTAINS("包含", "contains"),
    START_WITH("前缀匹配", "startWith"),
    END_WITH("后缀匹配", "endWith"),
    REGEX("正则", "regex"),
    EQUALS("相等", "equals");

    private final String text;

    private final String value;

    FileFilterRuleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     * @param value
     * @return 返回 value 对应的枚举对象
     */
    public static FileFilterRuleEnum getEnumByValue(String value) {
        if (ObjectUtil.isEmpty(value)) {
            return null;
        }
        for (FileFilterRuleEnum anEnum : FileFilterRuleEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }
    
    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }

}
