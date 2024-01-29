package com.yocy.generator;

import com.yocy.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import sun.awt.im.InputMethodWindow;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class MainGenerator {
    /**
     * 生成
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String inputRootPath = "D:\\java-workspace\\yuanmlin-generator\\yuanmlin-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "D:\\java-workspace\\yuanmlin-generator\\acm-template-pro";
        
        String inputPath;
        String outputPath;
        
        inputPath = new File(inputRootPath, "src/com/yocy/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/com/yocy/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);      
        
        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("YounGCY");
        mainTemplateConfig.setOutputText("SUM = ");
        doGenerate(mainTemplateConfig);
    }
}
