package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime dateNow = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateAndTime = dateNow.format(formatter);
        System.out.println(dateAndTime);
    }
}