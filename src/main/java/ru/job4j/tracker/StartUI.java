package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item testItem = new Item();
        testItem.setName("Заявка 1");
        LocalDateTime itemCreated = testItem.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formattedItemCreated = itemCreated.format(formatter);
        System.out.println("Дата создания объекта Item - " + formattedItemCreated);
        System.out.println(testItem);
    }
}
