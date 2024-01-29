package com.yocy.cli.pattern;

/**
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class RemoteControl {
    
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void pressButton() {
        command.execute();
    }
}
