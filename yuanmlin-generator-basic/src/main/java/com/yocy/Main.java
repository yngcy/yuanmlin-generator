package com.yocy;

import com.yocy.cli.CommandExecutor;

/**
 * @author <a href="https://github.com/youngccy">YounGCY</a>
 * @description
 */
public class Main {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
