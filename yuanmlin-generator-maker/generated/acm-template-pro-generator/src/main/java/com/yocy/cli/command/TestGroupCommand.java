package com.yocy.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yocy.generator.MainGenerator;
import com.yocy.model.DataModel;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
* @author YounGCY
* @description
*/
@Command(name = "test", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class TestGroupCommand implements Runnable {
    
    
    @Option(names = {"--needGit"}, arity = "0..1", description = "是否生成.gitignore文件", interactive = true, echo = true)
    private boolean needGit = true;
    
   
    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否生成循环", interactive = true, echo = true)
    private boolean loop = false;
    
    
    static DataModel.MainTemplate mainTemplate = new DataModel.MainTemplate();
    
    @CommandLine.Command(name = "mainTemplate")
    @Data
    public static class MainTemplateCommand implements Runnable {
        
        @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
        private String author = "youngcy";
        
        @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
        private String outputText = "sum = ";
        @Override
        public void run() {
            mainTemplate.author = author;
            mainTemplate.outputText = outputText;
        }
    }

    @Override
    public void run() {
        System.out.println(needGit);
        System.out.println(loop);
        if (true) {
            System.out.println("输入核心模板配置");
            CommandLine commmandLine = new CommandLine(MainTemplateCommand.class);
            commmandLine.execute("-a", "-o");
            System.out.println(mainTemplate);
        }
        // 需要赋值给 DataModel
//        DataModel dataModel = new DataModel();
//        BeanUtil.copyProperties(this, dataModel);
//        dataModel.mainTemplate = mainTemplate;
//        MainGenerator.doGenerate(dataModel);
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(TestGroupCommand.class);
        commandLine.execute("-l");
//        commandLine.execute("--help");
    }
}
