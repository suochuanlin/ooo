package com.myooo.myooo.practice.designPatterns.buildPattern;

public class ConcreteBuilder extends Builder{

    private Computer computer = new Computer();
    @Override
    public void buildCPU() {
        System.out.println("cpu");
        computer.add("cpu");
    }

    @Override
    public void buildBoard() {
        System.out.println("board");
        computer.add("board");
    }

    @Override
    public void buildScreen() {
        System.out.println("screen");
        computer.add("board");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
