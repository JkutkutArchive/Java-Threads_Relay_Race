package com.jkutkut.ej1;

import java.util.Arrays;

public class Baton {
    private final String team;
    private final int nRunners;
    private int currentRunner;
    private final long[][] times;
    private final String[] runners;

    public Baton(String team, int nRunners) {
        this.team = team;
        this.nRunners = nRunners;
        this.currentRunner = 0;
        times = new long[nRunners][2];
        runners = new String[nRunners];
    }

    public synchronized void takeBatonAndRun(Runner runner) {
        runners[currentRunner] = runner.toString();
        times[currentRunner][0] = System.currentTimeMillis();
        System.out.println(team + ": " + runner + " is running with the baton!");
        try {
            Thread.sleep(runner.getRunTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        times[currentRunner][1] = System.currentTimeMillis();
        System.out.println(team + ": " + runner + " is done running with the baton!");

        currentRunner++;
    }

    public long[] getResultTimes() {
        if (currentRunner != nRunners) {
            return null; // If not all runners have run, return null
        }

        long[] result = new long[nRunners + 1];
        for (int i = 0; i < nRunners; i++) {
            result[i] = times[i][1] - times[i][0]; // end - start
        }
        result[nRunners] = times[nRunners - 1][1] - times[0][0]; // Real end - Real start
        return result;
    }

    @Override
    public String toString() {
        /*
Team: "fjasdklfjaskl"
|------------------------------------------------|
|  Name  |  Start  |  End  |  Time  | Total Time |
|------------------------------------------------|
|        |         |       |        |            |
...
|------------------------------------------------|
         */
        if (currentRunner != nRunners) {
            return "Baton for " + team + " is not ready yet!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Team: ").append(team).append("\n");
        sb.append("|--------------------------------------------------|\n");
        sb.append("|   Name   |  Start  |  End  |  Time  | Total Time |\n");
        sb.append("|--------------------------------------------------|\n");
        for (int i = 0; i < nRunners; i++) {
            sb.append(String.format("| %8s | %7d | %5d | %6d | %10d |\n",
                    runners[i],
                    times[i][0] - times[0][0],
                    times[i][1] - times[0][0],
                    times[i][1] - times[i][0],
                    times[i][1] - times[0][0]
            ));
        }
        sb.append("|--------------------------------------------------|\n");
        return sb.toString();
    }
}
