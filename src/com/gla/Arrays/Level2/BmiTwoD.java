package com.gla.Arrays.Level2;
import java.util.Scanner;
class BmiTwoD {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of persons: ");
            int number = sc.nextInt();
            double[][] personData = new double[number][3];
            String[] weightStatus = new String[number];
            for (int i = 0; i < number; i++) {
                System.out.println("\nPerson " + (i + 1));
                do {
                    System.out.print("Enter height (in meters): ");
                    personData[i][0] = sc.nextDouble();
                    if (personData[i][0] <= 0) {
                        System.out.println("Height must be positive. Please re-enter.");
                    }
                } while (personData[i][0] <= 0);
                do {
                    System.out.print("Enter weight (in kg): ");
                    personData[i][1] = sc.nextDouble();
                    if (personData[i][1] <= 0) {
                        System.out.println("Weight must be positive. Please re-enter.");
                    }
                } while (personData[i][1] <= 0);
            }
            for (int i = 0; i < number; i++) {
                personData[i][2] =
                        personData[i][1] / (personData[i][0] * personData[i][0]);

                if (personData[i][2] < 18.5)
                    weightStatus[i] = "Underweight";
                else if (personData[i][2] < 25)
                    weightStatus[i] = "Normal";
                else if (personData[i][2] < 30)
                    weightStatus[i] = "Overweight";
                else
                    weightStatus[i] = "Obese";
            }
            System.out.println("\n--- BMI REPORT ---");
            for (int i = 0; i < number; i++) {
                System.out.println("\nPerson " + (i + 1));
                System.out.println("Height : " + personData[i][0] + " m");
                System.out.println("Weight : " + personData[i][1] + " kg");
                System.out.printf("BMI    : %.2f\n", personData[i][2]);
                System.out.println("Status : " + weightStatus[i]);
            }

        }


}
