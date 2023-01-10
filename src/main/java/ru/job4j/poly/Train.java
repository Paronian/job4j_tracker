package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ездит умеренно по рельсам");

    }

    @Override
    public void noise() {
        System.out.println("Неочень шумно и даже успокаивающий звук");

    }
}
