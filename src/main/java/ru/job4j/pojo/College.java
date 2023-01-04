package ru.job4j.pojo;

import java.util.Date;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Поляков Иван Алексеевич");
        student.setGroup("МТ7");
        student.setDate(new Date());
        System.out.println("Студент: " + student.getFullName() + " обучается в группе " + student.getGroup() + " начиная с даты " + student.getDate());
    }
}
