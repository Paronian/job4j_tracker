package ru.job4j.poly;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Движется со средней скоростью потока");
    }

    @Override
    public void noise() {
        System.out.println("Шум при езде средний");
    }
}

