package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        String print = switch (position) {
            case 1  -> "Пусть бегут неуклюже";
            case 2  -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(print);
    }

    public static void main(String[] args) {
        Jukebox object = new Jukebox();
        object.music(1);
        object.music(2);
        object.music(3);
    }
}

