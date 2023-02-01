package com.jkutkut.ej1_old;

public class Vehicle extends Thread {
    private static final String CAR = "CAR";
    private static final String BOAT = "BOAT";

    private static final int CAR_PRIORITY = 1;
    private static final int BOAT_PRIORITY = 2;

    private static final int CAR_CROSSING_TIME = 1000;
    private static final int BOAT_CROSSING_TIME = 2000;

    private final String type;
    private final String name;
    private int crossingTime;
    private final Bridge bridge;

    private Vehicle(String type, String name, Bridge bridge) {
        this.type = type;
        switch (type) {
            case CAR -> this.crossingTime = CAR_CROSSING_TIME;
            case BOAT -> this.crossingTime = BOAT_CROSSING_TIME;
        }
        this.name = name;
        this.bridge = bridge;
    }

    public static Vehicle newCar(String name, Bridge bridge) {
        Vehicle v = new Vehicle(CAR, name, bridge);
        v.setPriority(CAR_PRIORITY);
        return v;
    }

    public static Vehicle newBoat(String name, Bridge bridge) {
        Vehicle v = new Vehicle(BOAT, name, bridge);
        v.setPriority(BOAT_PRIORITY);
        return v;
    }

    @Override
    public void run() {
        System.out.println(this + " is ready to cross!");

        this.bridge.cross(this);

        System.out.println(this + " has crossed the bridge!");
    }

    // GETTERS
    public int getCrossingTime() {
        return crossingTime;
    }

    public boolean isBoat() {
        return this.type.equals(BOAT);
    }

    @Override
    public String toString() {
        return type + ": " + name;
    }
}
