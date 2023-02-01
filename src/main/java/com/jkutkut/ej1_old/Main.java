package com.jkutkut.ej1_old;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bridge bridge = new Bridge();
        Vehicle car1 = Vehicle.newCar("car1", bridge);
        Vehicle car2 = Vehicle.newCar("car2", bridge);
        Vehicle boat1 = Vehicle.newBoat("boat1", bridge);
        Vehicle boat2 = Vehicle.newBoat("boat2", bridge);

        car1.start();
        Thread.sleep(500);
        car2.start();
        boat1.start();
        Thread.sleep(500);
        boat2.start();
    }
}
