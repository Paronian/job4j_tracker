package ru.job4j.collection;

public record User(String name, int age) implements Comparable<User> {

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name) == 0 ? Integer.compare(this.age, o.age)
                                                : this.name.compareTo(o.name);
    }
}
