package com.yocy.cli.pattern;

/**
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class TurnOffCommand implements Command {
    private Device device;
    
    public TurnOffCommand(Device device) {
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnOff();
    }
}
