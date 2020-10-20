package com.myooo.designPatterns.buildPattern;

public class Director {


    public void builder() {
        Builder builder = new ConcreteBuilder();
        builder.buildBoard();
        builder.buildCPU();
        builder.buildScreen();
        builder.getComputer().show();
    }


    public static void main(String[] args) {
        Director director = new Director();
        director.builder();
    }

}
