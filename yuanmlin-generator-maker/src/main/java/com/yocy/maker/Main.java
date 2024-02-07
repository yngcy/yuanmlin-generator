package com.yocy.maker;

import com.yocy.maker.generator.main.GenerateTemplate;
import com.yocy.maker.generator.main.MainGenerator;
import com.yocy.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        GenerateTemplate mainGenerator = new ZipGenerator();
        mainGenerator.doGenerate();
    }
}
