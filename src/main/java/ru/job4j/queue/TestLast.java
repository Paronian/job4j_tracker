package ru.job4j.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLast {
    /**
     * fdfg
     * dfg
     * d
     * fdfgfdfg
     * df
     * g
     * df
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.contains(list);
    }
}
