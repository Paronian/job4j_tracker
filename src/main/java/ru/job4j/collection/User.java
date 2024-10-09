package ru.job4j.collection;

public record User(String name, int age) implements Comparable<User> {

    @Override
    public int compareTo(User o) {
        int compareName = this.name.compareTo(o.name);
        return compareName == 0 ? Integer.compare(this.age, o.age)
                                                : compareName;
    }
}


