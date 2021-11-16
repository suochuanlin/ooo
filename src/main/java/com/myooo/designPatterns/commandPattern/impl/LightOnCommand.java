package com.myooo.designPatterns.commandPattern.impl;

import com.myooo.designPatterns.commandPattern.ICommand;
import com.myooo.designPatterns.commandPattern.Light;

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

