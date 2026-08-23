package com.gla.Strings.Level1;
import java.util.Scanner;

public class OutOfBound {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking user input
            System.out.print("Enter a string: ");
            String text = sc.next();

            // -------- Part 1: Generating the Exception --------
            System.out.println("\nGenerating StringIndexOutOfBoundsException:");

            try {
                // Accessing index beyond string length
                System.out.println(text.charAt(text.length()));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Exception caught: " + e);
            }

            // -------- Part 2: Handling the Exception --------
            System.out.println("\nHandling StringIndexOutOfBoundsException:");

            try {
                int invalidIndex = text.length() + 2;
                System.out.println(text.charAt(invalidIndex));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Exception handled successfully.");
            }
        }


}
