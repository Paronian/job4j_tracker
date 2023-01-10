package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Передвигается очень быстро");
    }

    @Override
    public void noise() {
        System.out.println("Достаточно шумный вид трансорта");
    }
}
