package com.yocy.maker.generator.main;

/**
 * 生成代码生成器的压缩包
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description
 */
public class ZipGenerator extends GenerateTemplate {

    @Override
    protected String buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        String distPath = super.buildDist(outputPath, sourceCopyDestPath, jarPath, shellOutputFilePath);
        return super.buildZip(distPath);
    }
}
