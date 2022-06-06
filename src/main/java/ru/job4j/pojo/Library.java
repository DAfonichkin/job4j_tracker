package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 500);
        Book pinocchio = new Book("Pinocchio", 100);
        Book warAndPeace = new Book("War and Peace", 800);
        Book coreJava = new Book("Core Java Volume I – Fundamentals", 1000);
        Book[] bookLib = new Book[4];
        bookLib[0] = cleanCode;
        bookLib[1] = pinocchio;
        bookLib[2] = warAndPeace;
        bookLib[3] = coreJava;
        for (int index = 0; index < bookLib.length; index++) {
            Book currentBook = bookLib[index];
            System.out.println(currentBook.getName() + " - " + currentBook.getCountOfPages());
        }
        Book temp = bookLib[0];
        bookLib[0] = bookLib[3];
        bookLib[3] = temp;
        for (int index = 0; index < bookLib.length; index++) {
            Book currentBook = bookLib[index];
            System.out.println(currentBook.getName() + " - " + currentBook.getCountOfPages());
        }
        for (int index = 0; index < bookLib.length; index++) {
            Book currentBook = bookLib[index];
            if ("Clean code".equals(currentBook.getName())) {
                System.out.println(currentBook.getName() + " - " + currentBook.getCountOfPages());
            }
        }
    }
}
