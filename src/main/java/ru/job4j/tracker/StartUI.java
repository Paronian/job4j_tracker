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
                    Item item0 = new Item(name0);
                    tracker.add(item0);
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
                    int id2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name2 = scanner.nextLine();
                    Item item2 = new Item(name2);
                    if (tracker.replace(id2, item2)) {
                        System.out.println("Заявка изменена успешно.");
                    } else {
                        System.out.println("Ошибка замены заявки.");
                    }
                    break;
                case 3:
                    System.out.println("=== Delete item ===");
                    System.out.print("Enter id: ");
                    int id3 = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(id3)) {
                        System.out.println("Заявка удалена успешно.");
                    } else {
                        System.out.println("Ошибка удаления заявки.");
                    }
                    break;
                case 4:
                    System.out.println("=== Find item by id ===");
                    System.out.print("Enter id: ");
                    int id4 = Integer.parseInt(scanner.nextLine());
                    Item item4 = tracker.findById(id4);
                    if (item4 != null) {
                        System.out.println(item4);
                    } else {
                        System.out.println("Заявка с введенным id: " + id4 + " не найдена.");
                    }
                    break;
                case 5:
                    System.out.println("=== Find items by name ===");
                    System.out.print("Enter name: ");
                    String name5 = scanner.nextLine();
                    Item[] items5 = tracker.findByName(name5);
                    if (items5.length > 0) {
                        for (Item item5 : items5) {
                            System.out.println(item5);
                        }
                    } else {
                        System.out.println("Заявки с именем: " + name5 + " не найдены.");
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


