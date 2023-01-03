package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String bode) {
        String ln = System.lineSeparator();
        return "{" + ln + "\t\"name\" : " + "\"" + name + "\"" + ","
                + ln + "\t\"body\" : " + "\"" + bode + "\"" + ln + "}";
    }
}
