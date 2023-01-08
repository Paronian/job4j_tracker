package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());

            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ===");
                    System.out.print("Enter name: ");
                    String name0 = scanner.nextLine();
                    Item item = new Item(name0);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== Show all items ===");
                    Item[] items = tracker.findAll();
                    if (items.length > 0) {
                        for (Item item1 : items) {
                            System.out.println(item1);
                        }
                    } else {
                        System.out.println("Хранилище еще не содержит заявок");
                    }
                    break;
                case 2:
                    System.out.println("=== Edit item ===");
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item2 = new Item(name);
                    if (tracker.replace(id, item2)) {
                        System.out.println("Заявка изменена успешно.");
                    } else {
                        System.out.println("Ошибка замены заявки.");
                    }
                    break;
                case 6:
                    System.out.println("Вы выбрали выход из программы");
                    run = false;
                    break;
                default:
                    System.out.println("Недопустимое значение");
                    break;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

