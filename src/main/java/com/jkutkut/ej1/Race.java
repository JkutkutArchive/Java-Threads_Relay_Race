package com.jkutkut.ej1;

public class Race {
    private static final int RUNNERS_PER_TEAM = 3;

    public static void main(String[] args) {
        String[] teams = {"Sintria", "Arda", "Traunt", "Iberan"};

        Baton[] batons = {
            new Baton(teams[0], RUNNERS_PER_TEAM),
            new Baton(teams[1], RUNNERS_PER_TEAM),
            new Baton(teams[2], RUNNERS_PER_TEAM),
            new Baton(teams[3], RUNNERS_PER_TEAM)
        };

        Runner[][] runners = {
            {
                new Runner("Aragorn", batons[0]),
                new Runner("Legolas", batons[0]),
                new Runner("Gimli", batons[0])
            },
            {
                new Runner("Frodo", batons[1]),
                new Runner("Sam", batons[1]),
                new Runner("Merry", batons[1])
            },
            {
                new Runner("Gandalf", batons[2]),
                new Runner("Boromir", batons[2]),
                new Runner("Pippin", batons[2])
            },
            {
                new Runner("Sauron", batons[3]),
                new Runner("Saruman", batons[3]),
                new Runner("Gollum", batons[3])
            }
        };

        for (int i = 0; i < RUNNERS_PER_TEAM; i++) {
            for (int j = 0; j < teams.length; j++) {
                runners[j][i].start();
            }
        }

        // wait for all runners to finish
        for (int i = 0; i < RUNNERS_PER_TEAM; i++) {
            for (int j = 0; j < teams.length; j++) {
                try {
                    runners[j][i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("\n\n");

        long[][] results = new long[teams.length][RUNNERS_PER_TEAM + 1];
        for (int i = 0; i < teams.length; i++) {
            results[i] = batons[i].getResultTimes();
        }

        // Get the winner
        int winner = 0;
        for (int i = 1; i < teams.length; i++) {
            if (results[i][RUNNERS_PER_TEAM] < results[winner][RUNNERS_PER_TEAM]) {
                winner = i;
            }
        }

        // Print results
        System.out.println("The winner is " + teams[winner] + "!");
        System.out.println("\n\nAll results:");
        for (int i = 0; i < teams.length; i++) {
            System.out.println(batons[i] + "\n");
        }
    }
}
