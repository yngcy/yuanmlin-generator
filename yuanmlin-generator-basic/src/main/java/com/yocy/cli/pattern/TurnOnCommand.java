package com.yocy.cli.pattern;

/**
 * @author <a href="https://github.com/youngccy">YounGCY</a>
 * @description
 */
public class TurnOnCommand implements Command {
    private Device device;
    
    public TurnOnCommand(Device device) {
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnOn();
    }
}
