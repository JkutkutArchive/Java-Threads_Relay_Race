package com.jkutkut.ej1;

public class Runner extends Thread {
    private static final int MIN_TIME = 2000;
    private static final int MAX_TIME = 3500;

    private final Baton baton;
    private final String fullName;
    private final int runTime;

    public Runner(String fullName, Baton baton) {
        this.fullName = fullName;
        this.baton = baton;
        this.runTime = (int) (Math.random() * (MAX_TIME - MIN_TIME) + MIN_TIME);
    }

    @Override
    public void run() {
        System.out.println(this + " is ready to run!");
        baton.takeBatonAndRun(this);
        System.out.println(this + " is done with the race!");
    }

    public int getRunTime() {
        return this.runTime;
    }

    @Override
    public String toString() {
        return this.fullName;
    }
}
