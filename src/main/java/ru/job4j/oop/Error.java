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
        Error message1 = new Error();
        Error message2 = new Error(true, 1, "Неустранимая ошибка");
        Error message3 = new Error(true, 2, "Некритичная ошибка");
        Error message4 = new Error(false, 3, "Ложная ошибка");
        message1.printInfo();
        message2.printInfo();
        message3.printInfo();
        message4.printInfo();
    }
}

