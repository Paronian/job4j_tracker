package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();

        for (String el : origin) {
            check.add(el);
        }

        for (String elText : text) {
            if (!check.contains(elText)) {
                return false;
            }
        }
        return true;
    }
}
