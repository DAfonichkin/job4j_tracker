package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftLength = left.length();
        int rightLength = right.length();
        int smallestLength = Math.min(left.length(), right.length());
        for (int i = 0; i < smallestLength; i++) {
            int chrCompareRsl = Character.compare(left.charAt(i), right.charAt(i));
            if (chrCompareRsl != 0) {
                return chrCompareRsl;
            }
        }
        return Integer.compare(leftLength, rightLength);
    }
}