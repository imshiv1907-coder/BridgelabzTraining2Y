package com.gla.Strings.Level2;
import java.util.Scanner;
import java.util.Random;

public class Voting {

        public static int[] generateRandomAges(int n) {
            int[] ages = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                ages[i] = rand.nextInt(83) + 10; // Random ages from 10 to 92
            }
            return ages;
        }

        // b. Method to check voting eligibility and return a 2D String array
        public static String[][] checkVotingEligibility(int[] ages) {
            String[][] result = new String[ages.length][2];

            for (int i = 0; i < ages.length; i++) {
                result[i][0] = String.valueOf(ages[i]); // Store age as string

                // Validate age
                if (ages[i] < 0) {
                    result[i][1] = "Cannot Vote (Invalid Age)";
                } else if (ages[i] >= 18) {
                    result[i][1] = "Can Vote";
                } else {
                    result[i][1] = "Cannot Vote";
                }
            }

            return result;
        }

        // c. Method to display the 2D array in tabular format
        public static void displayTable(String[][] table) {
            System.out.printf("%-10s | %-15s\n", "Age", "Voting Eligibility");
            System.out.println("----------------------------");
            for (int i = 0; i < table.length; i++) {
                System.out.printf("%-10s | %-15s\n", table[i][0], table[i][1]);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] ages = new int[10];

            // Option 1: User input for ages
            System.out.println("Enter ages of 10 students:");
            for (int i = 0; i < 10; i++) {
                System.out.print("Student " + (i + 1) + ": ");
                ages[i] = sc.nextInt();
            }

            // Optionally, you can use random ages instead
            // ages = generateRandomAges(10);

            // Check voting eligibility
            String[][] votingResults = checkVotingEligibility(ages);

            // Display table
            displayTable(votingResults);

        }


}
