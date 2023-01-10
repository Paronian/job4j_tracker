package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Вождение автобуса по маршруту");
    }

    @Override
    public void passengers(int numbers) {
        System.out.println("В автобусе находится " + numbers + " пассажиров");
    }

    @Override
    public double refuel(double volume) {
        return volume * 15;
    }
}

