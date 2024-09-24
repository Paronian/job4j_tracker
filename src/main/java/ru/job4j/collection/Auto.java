package ru.job4j.collection;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auto auto = (Auto) o;
        return model.equals(auto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}