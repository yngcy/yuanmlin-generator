package com.yocy.cli.command;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.yocy.generator.MainGenerator;
import com.yocy.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;

/**
 * @author <a href="https://github.com/youngccy">YounGCY</a>
 * @description
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)

public class ConfigCommand implements Runnable {


    @Override
    public void run() {
        System.out.println("参数信息：");
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("----");
        }
    }
}
