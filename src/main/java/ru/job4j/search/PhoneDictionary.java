package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameIsMatch = (p) -> (p.getName().contains(key));
        Predicate<Person> surnameIsMatch = (p) -> (p.getSurname().contains(key));
        Predicate<Person> addressIsMatch = (p) -> (p.getAddress().contains(key));
        Predicate<Person> phoneIsMatch = (p) -> (p.getPhone().contains(key));
        var combine = nameIsMatch.or(surnameIsMatch.or(addressIsMatch.or(phoneIsMatch)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}