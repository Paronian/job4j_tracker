package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book harry = new Book("Harry Potter", 500);
        Book enlightenment = new Book("Enlightenment", 1500);
        Book escape = new Book("The escape", 350);
        Book cleanCode = new Book("Clean code", 800);
        Book[] bookArray = new Book[4];
        bookArray[0] = harry;
        bookArray[1] = enlightenment;
        bookArray[2] = escape;
        bookArray[3] = cleanCode;
        for (int i = 0; i < bookArray.length; i++) {
            System.out.println("Название книги: " + bookArray[i].getName() + ". Количество страниц книги: " + bookArray[i].getNumberOfPages());
        }
        bookArray[0] = cleanCode;
        bookArray[3] = harry;
        System.out.println("Новый цикл");
        for (int i = 0; i < bookArray.length; i++) {
            if ("Clean code".equals(bookArray[i].getName())) {
                System.out.println("Название книги: " + bookArray[i].getName() + ". Количество страниц книги: " + bookArray[i].getNumberOfPages());
            }
        }
    }
}
