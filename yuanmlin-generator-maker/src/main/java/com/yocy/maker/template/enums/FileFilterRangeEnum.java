package com.yocy.maker.template.enums;

import cn.hutool.core.util.ObjectUtil;

/**
 * 文件类型枚举
 *
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description
 */
public enum FileFilterRangeEnum {
    FILE_NAME("文件名称", "fileName"),
    FILE_CONTENT("文件内容", "fileContent");

    private final String text;

    private final String value;

    FileFilterRangeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     * @param value
     * @return 返回 value 对应的枚举对象
     */
    public static FileFilterRangeEnum getEnumByValue(String value) {
        if (ObjectUtil.isEmpty(value)) {
            return null;
        }
        for (FileFilterRangeEnum anEnum : FileFilterRangeEnum.values()) {
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
