package com.yocy.maker.generator.file;

import com.yocy.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class FileGenerator {
    /**
     * 生成
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 项目根路径
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "yuanmlin-generator-demo-projects/acm-template")
                .getAbsolutePath();
        String outputPath = projectPath;
        // 1.首先生成静态文件
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
        
        // 2.再提供需要动态生成文件的路径执行生成，覆盖
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yocy/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel mainTemplateConfig = new DataModel();
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("YounGCY");
        mainTemplateConfig.setOutputText("SUM = ");
        doGenerate(mainTemplateConfig);
    }
}
