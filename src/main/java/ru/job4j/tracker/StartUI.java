package ru.job4j.tracker;

import javax.swing.*;

public class StartUI {

    public void init(Tracker tracker, Input input, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            run = actions[select].execute(tracker, input);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };

        new StartUI().init(tracker, input, actions);
    }
}
