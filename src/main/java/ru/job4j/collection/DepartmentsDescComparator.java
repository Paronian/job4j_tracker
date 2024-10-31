package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        int compareDepartment = rightArray[0].compareTo(leftArray[0]);
        if (compareDepartment == 0) {
            for (int i = 1; i < Math.min(leftArray.length, rightArray.length); i++) {
                if (leftArray[i].compareTo(rightArray[i]) != 0) {
                    return leftArray[i].compareTo(rightArray[i]);
                }
            }
            return Integer.compare(leftArray.length, rightArray.length);
        }
        return rightArray[0].compareTo(leftArray[0]);
    }
}

