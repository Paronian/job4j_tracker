package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error message_1 = new Error();
        Error message_2 = new Error(true, 1, "Неустранимая ошибка");
        Error message_3 = new Error(true, 2, "Некритичная ошибка");
        Error message_4 = new Error(false, 3, "Ложная ошибка");
        message_1.printInfo();
        message_2.printInfo();
        message_3.printInfo();
        message_4.printInfo();
    }
}
