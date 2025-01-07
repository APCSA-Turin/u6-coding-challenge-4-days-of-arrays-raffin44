package com.example.project;
import java.util.Random;

public class Day2{
    public static String[][] nameSort(String[] names){ // your will be tested on this method
        String[][] list = new String[2][names.length];
        Random random = new Random();
        for (int i = 0; i < names.length; i++){
            int pick = random.nextInt(2);
            list[pick][i] = names[i];
        }


        return list; //you must return a two dimensional string array
    }

    public static void main(String[] args) {

    }
}