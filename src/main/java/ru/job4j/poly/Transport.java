package ru.job4j.poly;

public interface Transport {
    void toGo();

    void takePassengers(int count);

    float refuel(float countOfFuel);
}
