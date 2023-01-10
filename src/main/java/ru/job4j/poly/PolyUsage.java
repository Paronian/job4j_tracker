package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = new Train();
        vehicles[1] = new Train();
        vehicles[2] = new Airplane();
        vehicles[3] = new Airplane();
        vehicles[4] = new Bus();
        vehicles[5] = new Bus();
        for (Vehicle element : vehicles) {
            element.move();
            element.noise();
        }
    }
}
