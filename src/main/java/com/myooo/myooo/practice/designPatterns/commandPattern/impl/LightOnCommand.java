package com.myooo.myooo.practice.designPatterns.commandPattern.impl;

import com.myooo.myooo.practice.designPatterns.commandPattern.ICommand;
import com.myooo.myooo.practice.designPatterns.commandPattern.Light;

public class LightOnCommand implements ICommand {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
    }
}

