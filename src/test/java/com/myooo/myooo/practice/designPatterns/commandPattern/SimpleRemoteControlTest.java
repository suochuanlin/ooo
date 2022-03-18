package com.myooo.myooo.practice.designPatterns.commandPattern;

import com.myooo.myooo.practice.designPatterns.commandPattern.impl.LightOnCommand;
import org.junit.jupiter.api.Test;

class SimpleRemoteControlTest {  //1、命令模式的客户

    @Test
    void buttonWasPressed() {

        SimpleRemoteControl remote = new SimpleRemoteControl(); //2、遥控器 调用者
        Light light = new Light();//3、电灯对象 请求的接收者
        LightOnCommand lightOn = new LightOnCommand(light); //4、创建一个命令，然后将接收者传给它
        remote.setCommand(lightOn); //5、将接收者传给它
        remote.buttonWasPressed(); //6、按下按钮

    }
}
