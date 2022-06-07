package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Tracker tracker, Scanner scanner) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Select:");
            int select = Integer.parseInt(scanner.nextLine());
            if (select != 6) {
                System.out.println("Пользователь выбрал - " + select);
            } else {
                run = false;
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
