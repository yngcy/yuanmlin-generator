package com.yocy.cli.pattern;

/**
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 * @description
 */
public class Device {
    private String name;
    public Device(String name) {
        this.name = name;
    }
    
    public void turnOff() {
        System.out.println(name + " is off.");
    }
    
    public void turnOn() {
        System.out.println(name + " is on.");
    }
}
