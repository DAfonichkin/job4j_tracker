package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Петрович");
        student.setGroup("205");
        student.setEnterDate(new Date(2021, 6, 5));
        System.out.println(student.getFullName() + " enrolled in group " + student.getGroup() + "  dated " + student.getEnterDate());
    }
}
