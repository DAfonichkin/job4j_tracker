package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] rightStringArray = right.split("\\. ");
        String[] leftStringArray = left.split("\\. ");
        if (leftStringArray.length == 1 || rightStringArray.length == 1) {
            throw new IllegalArgumentException("Task name doesn't contain point separator");
        }
        try {
            int rightNum = Integer.parseInt(rightStringArray[0]);
            int leftNum = Integer.parseInt(leftStringArray[0]);
            return Integer.compare(leftNum, rightNum);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Task number is not int");
        }
    }
}