package com.example.project;

import java.util.Random;

public class Day4 {

    private static String[] reindeer_names = {"Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid", "Donner", "Blitzen"};

    public static class Reindeer {
        private String name;
        private int speed;          
        private int runDuration;   
        private int restDuration;   
        private int distanceTraveled;
        private int currentTime;     
        private boolean isRunning;   

        public Reindeer(String name, int speed, int runDuration, int restDuration) {
            this.name = name;
            this.speed = speed;
            this.runDuration = runDuration;
            this.restDuration = restDuration;
            this.distanceTraveled = 0;
            this.currentTime = 0;
            this.isRunning = true; 
        }

        public int getDistanceTraveled() { 
            return distanceTraveled;
        }

        public String getName() {
            return name;
        }

        public void simulateSecond() { 
            if (isRunning) {
                distanceTraveled += speed; 
                currentTime++; 
                if (currentTime >= runDuration) { 
                    isRunning = false;
                    currentTime = 0; 
                }
            } else { 
                currentTime++; 
                if (currentTime >= restDuration) { 
                    isRunning = true;
                    currentTime = 0; 
                }
            }
        }
    }

    public static String simulateRace(int time, Reindeer[] reindeers) {
        for (int t = 0; t < time; t++) {
            for (Reindeer reindeer : reindeers) {
                reindeer.simulateSecond(); 
            }
        }

        Reindeer winner = reindeers[0];
        for (Reindeer reindeer : reindeers) {
            if (reindeer.getDistanceTraveled() > winner.getDistanceTraveled()) {
                winner = reindeer;
            }
        }
        return winner.name;
    }

    public static void main(String[] args) {
        Random random = new Random();

        Reindeer[] reindeers = new Reindeer[reindeer_names.length];
        for (int i = 0; i < reindeer_names.length; i++) {
            int speed = random.nextInt(10) + 10;          
            int runDuration = random.nextInt(5) + 5;     
            int restDuration = random.nextInt(5) + 5;    
            reindeers[i] = new Reindeer(reindeer_names[i], speed, runDuration, restDuration);
        }

        int raceTime = 10;
        String winner = simulateRace(raceTime, reindeers);
        System.out.println("Winner after " + raceTime + " seconds: " + winner);
    }
}


