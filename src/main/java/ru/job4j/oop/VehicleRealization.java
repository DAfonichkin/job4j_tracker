package ru.job4j.oop;

public class VehicleRealization {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle[] vehicles = new Vehicle[]{train, bus, airplane};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
