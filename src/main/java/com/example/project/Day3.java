package com.example.project;

public class Day3 {
    public static String[][] generateSnowflake(int size) { // You will be tested on this method
        String[][] grid = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = " ";
            }
        }

        int mid = size / 2; 

        for (int i = 0; i < size; i++) {
            grid[mid][i] = "*"; 
            grid[i][mid] = "*"; 
            grid[i][i] = "*";   
            grid[i][size - 1 - i] = "*"; 
        }

        return grid;
    }

    public static void printSnowflake(String[][] snowflake) {
        for (int i = 0; i < snowflake.length; i++) {
            for (int j = 0; j < snowflake[i].length; j++) {
                System.out.print(snowflake[i][j]);
            }
            System.out.println();
        }
    }

    // Test
    public static void main(String[] args) {
        int size = 5; 
        String[][] snowflake = generateSnowflake(size);
        printSnowflake(snowflake);
    }
}
