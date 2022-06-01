package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error errDef = new Error();
        Error errAct = new Error(true, 0, "Ошибка активна");
        Error errNotNow = new Error(false, 1, "Ошибка не активна");
        Error errUnknown = new Error(true, 2, "Ошибка неизвестна");
        errDef.printInfo();
        errAct.printInfo();
        errNotNow.printInfo();
        errUnknown.printInfo();
    }
}
