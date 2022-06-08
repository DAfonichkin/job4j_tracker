package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Tracker tracker, Scanner scanner) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select:");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно");
                } else {
                    System.out.println("Ошибка замены заявки");
                }
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Пользователь выбрал - " + select);
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Scanner scanner = new Scanner(System.in);
        new StartUI().init(tracker, scanner);
    }
}
