package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int leftLength = left.length();
        int rightLength = right.length();
        int length = Math.min(leftLength, rightLength);
        for (int i = 0; i < length; i++) {
            if (Character.compare(left.charAt(i), right.charAt(i)) != 0) {
               rsl = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
            if (i == length - 1) {
                rsl = leftLength - rightLength;
            }
        }
        return rsl;
    }
}
