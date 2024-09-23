package ru.job4j.collection;

public class Auto {

    private String model;

    public Auto(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Марка автомобиля " + model;
    }
}