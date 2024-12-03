package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getName().compareTo(right.getName());
        Comparator<Attachment> comparatorByLengthOfName = (left, right) -> Integer.compare(right.getName().length(), left.getName().length());
        Arrays.sort(attachments, comparator);
        System.out.println(Arrays.toString(attachments));
        Arrays.sort(attachments, comparatorByLengthOfName);
        System.out.println(Arrays.toString(attachments));
    }
}
