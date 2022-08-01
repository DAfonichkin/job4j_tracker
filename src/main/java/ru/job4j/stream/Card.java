package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Suit[] suits = {Suit.Diamonds, Suit.Hearts, Suit.Spades, Suit.Clubs};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        Stream.of(suits)
                .flatMap(elSuit -> Stream.of(values)
                        .map(elValue -> elSuit + " " + elValue))
                .forEach(System.out::println);
    }
}