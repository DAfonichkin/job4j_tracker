package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] rightStringArray = right.split("\\. ");
        String[] leftStringArray = left.split("\\. ");
        return Integer.compare(Integer.parseInt(leftStringArray[0]), Integer.parseInt(rightStringArray[0]));
    }
}