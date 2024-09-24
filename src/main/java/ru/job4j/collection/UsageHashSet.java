package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<Auto> autos = new HashSet<>();
        autos.add(new Auto("Lada"));
        autos.add(new Auto("Lada"));
        autos.add(new Auto("BMW"));
        autos.add(new Auto("Volvo"));
        autos.add(new Auto("Volvo"));
        autos.add(new Auto("Toyota"));

        for (Auto el : autos) {
            System.out.println(el);
        }
    }
}