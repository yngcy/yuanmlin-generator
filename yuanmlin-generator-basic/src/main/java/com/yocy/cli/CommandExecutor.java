package com.yocy.cli;

import com.yocy.cli.command.ConfigCommand;
import com.yocy.cli.command.GenerateCommand;
import com.yocy.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author <a href="https://github.com/youngccy">YounGCY</a>
 * @description
 */
@Command(name = "yuanmlin", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{
    
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }


    @Override
    public void run() {
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
