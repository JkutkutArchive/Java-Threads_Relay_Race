package com.jkutkut.ej1_old;

public class Bridge {

    public Bridge() {
    }

    public synchronized void cross(Vehicle vehicle) {
        if (vehicle.isBoat()) {
            System.out.println("BRIDGE: Opening the bridge for the boat " + vehicle);
        }
        try {
            Thread.sleep(vehicle.getCrossingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (vehicle.isBoat()) {
            System.out.println("BRIDGE: Closing the bridge for the boat " + vehicle);
        }
    }
}
