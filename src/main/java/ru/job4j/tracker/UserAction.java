package ru.job4j.tracker;

public interface UserAction {
    String name();

    boolean execute(Store memTracker, Input input);
}
