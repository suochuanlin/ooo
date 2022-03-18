package com.myooo.myooo.practice.designPatterns.buildPattern;

public abstract class Builder {

    public abstract void buildCPU();

    public abstract void buildBoard();

    public abstract void buildScreen();

    public abstract Computer getComputer();
}
