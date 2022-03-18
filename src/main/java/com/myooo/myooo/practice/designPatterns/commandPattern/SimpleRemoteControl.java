package com.myooo.myooo.practice.designPatterns.commandPattern;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SimpleRemoteControl {

    ICommand slot;

    public void setCommand(ICommand command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
