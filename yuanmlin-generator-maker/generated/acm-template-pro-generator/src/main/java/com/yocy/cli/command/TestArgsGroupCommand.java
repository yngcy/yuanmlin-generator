package com.yocy.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yocy.generator.MainGenerator;
import com.yocy.model.DataModel;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
* @author YounGCY
* @description
*/
@Command(name = "test", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class TestArgsGroupCommand implements Runnable {
    
    @Data
    static class MainTemplate {
        @CommandLine.Option(names = {"-mainTemplate.a", "--mainTemplate.author"}, arity = "0..1", description = "作者注释", interactive = true, echo = true)
        private String author = "youngcy";
        @CommandLine.Option(names = {"-mainTemplate.o", "--mainTemplate.outputText"}, arity = "0..1", description = "输出信息", interactive = true, echo = true)
        private String outputText = "sum = ";
    }
    
   
    @Option(names = {"--needGit"}, arity = "0..1", description = "是否生成.gitignore文件", interactive = true, echo = true)
    private boolean needGit = true;
    
   
    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否生成循环", interactive = true, echo = true)
    private boolean loop = false;
    
   
    @CommandLine.ArgGroup(exclusive = false, heading = "核心模板%n")
    private MainTemplate mainTemplate;

    @Override
    public void run() {
        System.out.println(needGit);
        System.out.println(loop);
        System.out.println(mainTemplate);
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(TestArgsGroupCommand.class);
        commandLine.execute("-l", "-mainTemplate.a", "--mainTemplate.outputText");
//        commandLine.execute("--help");
    }
}
