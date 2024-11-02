package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        int compareDepartment = rightArray[0].compareTo(leftArray[0]);
        return compareDepartment != 0 ? compareDepartment : left.compareTo(right);
    }
}

