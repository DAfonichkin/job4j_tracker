package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void toGo() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void takePassengers(int count) {
        System.out.println("В автобус сели " + count + " пассажиров.");
    }

    @Override
    public float refuel(float countOfFuel) {
        return countOfFuel * 45;
    }
}
