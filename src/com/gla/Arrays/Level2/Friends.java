package com.gla.Arrays.Level2;
import java.util.Scanner;
class Friends {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] names = {"Amar", "Akbar", "Anthony"};
            int[] ages = new int[3];
            double[] heights = new double[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter age of " + names[i] + ": ");
                ages[i] = sc.nextInt();
                System.out.print("Enter height of " + names[i] + " (in cm): ");
                heights[i] = sc.nextDouble();
            }
            int minAge = ages[0];
            String youngest = names[0];
            for (int i = 1; i < 3; i++) {
                if (ages[i] < minAge) {
                    minAge = ages[i];
                    youngest = names[i];
                }
            }
            double maxHeight = heights[0];
            String tallest = names[0];
            for (int i = 1; i < 3; i++) {
                if (heights[i] > maxHeight) {
                    maxHeight = heights[i];
                    tallest = names[i];
                }
            }

            // Display results
            System.out.println("\nYoungest friend: " + youngest + " (" + minAge + " years)");
            System.out.println("Tallest friend: " + tallest + " (" + maxHeight + " cm)");


        }


}
