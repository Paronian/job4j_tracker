package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            StringBuilder start = new StringBuilder();
            for (String element : value.split("/")) {
                if (start.length() == 0) {
                    temp.add(element);
                    start = new StringBuilder(element);
                } else {
                    temp.add(start + "/" + element);
                    start.append("/").append(element);
                }
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments, Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        Collections.sort(departments, new DepartmentsDescComparator());
    }
}

