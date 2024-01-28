package com.yocy.generator;

import com.yocy.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态文件生成
 * @author <a href="https://github.com/youngccy">YounGCY</a>
 * @description
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig maintemplateConfig = new MainTemplateConfig();
        maintemplateConfig.setLoop(false);
        maintemplateConfig.setAuthor("youngcy");
        maintemplateConfig.setOutputText("求和结果为：");
        doGenerate(inputPath, outputPath, maintemplateConfig);
    }

    /**
     * 生成文件
     *
     * @param inputPath 模板文件输入路径
     * @param outputPAth 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPAth, Object model) throws IOException, TemplateException {
        // 创建 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 指定模板文件所在的位置
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 生成
        Writer out = new FileWriter(outputPAth);
        template.process(model, out);

        // 关闭流
        out.close();
    }
}
