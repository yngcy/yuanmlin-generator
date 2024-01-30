package com.yocy.maker;

import com.yocy.maker.generator.main.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}
