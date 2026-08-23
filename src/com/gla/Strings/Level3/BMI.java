package com.gla.Strings.Level3;
import java.util.Scanner;

public class BMI {

        public static String[] calculateBMIStatus(double weight, double heightCm) {
            double heightM = heightCm / 100; // convert cm to meters
            double bmi = weight / (heightM * heightM);
            String status;

            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Overweight";
            else status = "Obese";

            return new String[]{String.format("%.2f", weight),
                    String.format("%.2f", heightCm),
                    String.format("%.2f", bmi),
                    status};
        }

        // c. Method to compute BMI for all team members
        public static String[][] computeTeamBMI(double[][] teamData) {
            String[][] result = new String[teamData.length][4];
            for (int i = 0; i < teamData.length; i++) {
                result[i] = calculateBMIStatus(teamData[i][0], teamData[i][1]);
            }
            return result;
        }

        // d. Method to display results in tabular format
        public static void displayResults(String[][] data) {
            System.out.printf("%-10s | %-10s | %-10s | %-12s\n", "Weight(kg)", "Height(cm)", "BMI", "Status");
            System.out.println("-----------------------------------------------------");
            for (int i = 0; i < data.length; i++) {
                System.out.printf("%-10s | %-10s | %-10s | %-12s\n",
                        data[i][0], data[i][1], data[i][2], data[i][3]);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double[][] teamData = new double[10][2]; // 10 members: [weight, height]

            // a. Take user input
            for (int i = 0; i < 10; i++) {
                System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
                teamData[i][0] = sc.nextDouble();
                System.out.print("Enter height (cm) for person " + (i+1) + ": ");
                teamData[i][1] = sc.nextDouble();
            }

            // c. Compute BMI and status
            String[][] bmiResults = computeTeamBMI(teamData);

            // d. Display results
            displayResults(bmiResults);


        }


}
