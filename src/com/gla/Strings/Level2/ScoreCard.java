package com.gla.Strings.Level2;

import java.util.Random;

public class ScoreCard {

        // Method to generate random 2-digit PCM scores for n students
        public static int[][] generateScores(int n) {
            int[][] scores = new int[n][3]; // 3 subjects: Physics, Chemistry, Math
            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    scores[i][j] = 40 + rand.nextInt(61); // scores between 40-100
                }
            }

            return scores;
        }

        // Method to calculate total, average, percentage
        public static double[][] calculateTotalsPercentages(int[][] scores) {
            int n = scores.length;
            double[][] result = new double[n][3]; // total, average, percentage

            for (int i = 0; i < n; i++) {
                int total = 0;
                for (int j = 0; j < 3; j++) {
                    total += scores[i][j];
                }
                double average = total / 3.0;
                double percentage = (total / 300.0) * 100;

                result[i][0] = Math.round(total * 100.0) / 100.0;
                result[i][1] = Math.round(average * 100.0) / 100.0;
                result[i][2] = Math.round(percentage * 100.0) / 100.0;
            }

            return result;
        }

        // Method to assign grade based on percentage
        public static String[] calculateGrades(double[][] percentages) {
            int n = percentages.length;
            String[] grades = new String[n];

            for (int i = 0; i < n; i++) {
                double perc = percentages[i][2];
                if (perc >= 80) grades[i] = "A";
                else if (perc >= 70) grades[i] = "B";
                else if (perc >= 60) grades[i] = "C";
                else if (perc >= 50) grades[i] = "D";
                else if (perc >= 40) grades[i] = "E";
                else grades[i] = "R";
            }

            return grades;
        }

        // Method to display the scorecard
        public static void displayScorecard(int[][] scores, double[][] totals, String[] grades) {
            System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
            System.out.println("--------------------------------------------------------------------------");

            for (int i = 0; i < scores.length; i++) {
                System.out.print((i + 1) + "\t"); // Student number
                for (int j = 0; j < 3; j++) {
                    System.out.print(scores[i][j] + "\t");
                }
                System.out.print(totals[i][0] + "\t" + totals[i][1] + "\t" + totals[i][2] + "\t" + grades[i]);
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int n = 10; // Number of students

            // Generate random scores
            int[][] scores = generateScores(n);

            // Calculate total, average, percentage
            double[][] totals = calculateTotalsPercentages(scores);

            // Calculate grades
            String[] grades = calculateGrades(totals);

            // Display the scorecard
            displayScorecard(scores, totals, grades);
        }

}
