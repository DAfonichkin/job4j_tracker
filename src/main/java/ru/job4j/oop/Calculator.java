package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int devide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        Calculator calculator = new Calculator();
        return sum(a) + minus(a) + calculator.multiply(a) + calculator.devide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        rsl = calculator.devide(5);
        System.out.println(rsl);
        rsl = sum(5);
        System.out.println(rsl);
        rsl = minus(5);
        System.out.println(rsl);
        rsl = calculator.sumAllOperation(5);
        System.out.println(rsl);
    }
}