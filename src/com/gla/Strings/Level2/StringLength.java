package com.gla.Strings.Level2;
import java.util.Scanner;

public class StringLength {

        // Method to find string length without using length()
        public static int findLength(String text) {

            int count = 0;

            while (true) {
                try {
                    text.charAt(count);
                    count++;
                } catch (Exception e) {
                    break;
                }
            }

            return count;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Input from user
            System.out.print("Enter a string: ");
            String input = sc.next();

            // Finding length using user-defined method
            int manualLength = findLength(input);

            // Finding length using built-in length() method
            int builtInLength = input.length();

            // Displaying results
            System.out.println("\nLength (without length()): " + manualLength);
            System.out.println("Length (using length()):    " + builtInLength);

            sc.close();
        }

}
