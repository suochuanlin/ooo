package com.myooo.myooo.practice.designPatterns.commandPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Light {

    public String on() {
        log.info("light on!");
        return "light on!";
    }

    public String off() {
        log.info("light off!");
        return "light off!";
    }

}
