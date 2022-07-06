package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test (expected = NumberFormatException.class)
    public void whenWrongTaskNumber() {
        String[] input = {
                "a. Task.",
                "1. Task.",
                "2. Task."
        };
        Arrays.sort(input, new LexSort());
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenWrongSeparator() {
        String[] input = {
                "0, Task.",
                "1, Task.",
                "2? Task."
        };
        Arrays.sort(input, new LexSort());
    }
}