package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameIsMatch = (Person p) -> (p.getName().contains(key));
        Predicate<Person> surnameIsMatch = (Person p) -> (p.getSurname().contains(key));
        Predicate<Person> addressIsMatch = (Person p) -> (p.getAddress().contains(key));
        Predicate<Person> phoneIsMatch = (Person p) -> (p.getPhone().contains(key));
        Predicate<Person> combine = nameIsMatch.or(surnameIsMatch.or(addressIsMatch.or(phoneIsMatch)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}