package com.yocy.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class StaticGenerator {
    
    /**
     * 拷贝文件（Hutool 实现，将会输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
    
}
