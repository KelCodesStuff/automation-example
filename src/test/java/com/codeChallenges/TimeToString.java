package com.codeChallenges;

public class TimeToString {

    public static void main(String[] args) {
/*
        // generate a number between 1 - 12
        int hour = (int)(Math.random() * 12 + 1);

        // generate a number between 0 - 60
        int minute = (int)(Math.random() * 60 + 0);

        System.out.println(hour);
        System.out.println(minute);
*/
        timeInWords(8, 49);
    }

    static void timeInWords(int hour, int minute) {
        String[] numbers = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen", "Twenty", "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four",
                "Twenty Five", "Twenty Six", "Twenty Seven", "Twenty Eight", "Twenty Nine"
        };

        if (minute == 0) {
            System.out.println(numbers[hour] + " o' clock ");
        }

        else if (minute == 1) {
            System.out.println("One minute past " + numbers[hour]);
        }

        else if (minute == 15) {
            System.out.println("Quarter past " + numbers[hour]);
        }

        else if (minute == 30) {
            System.out.println("Half past " + numbers[hour]);
        }

        else if (minute < 30) {
            System.out.println(numbers[minute] + " past " + numbers[hour]);
        }

        else if (minute == 59) {
            System.out.println("One minute to " + numbers[(hour % 12) + 1]);
        }

        else if (minute == 45) {
            System.out.println("Quarter to " + numbers[(hour % 12) + 1]);
        }

        else if (minute > 30) {
            System.out.println(numbers[60 - minute] + " to " + numbers[(hour % 12) + 1]);
        }
    }
}