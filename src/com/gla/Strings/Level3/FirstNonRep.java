package com.gla.Strings.Level3;
import java.util.Scanner;

public class FirstNonRep {


        // b. Method to find the first non-repeating character
        public static char findFirstNonRepeating(String str) {
            int[] freq = new int[256]; // ASCII character frequency array
            int len = 0;

            // find length without using length()
            try {
                while (true) {
                    str.charAt(len);
                    len++;
                }
            } catch (StringIndexOutOfBoundsException e) {
                // reached end of string
            }

            // Count frequency of each character
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                freq[(int) ch]++;
            }

            // Find first non-repeating character
            for (int i = 0; i < len; i++) {
                if (freq[(int) str.charAt(i)] == 1) {
                    return str.charAt(i);
                }
            }

            return '\0'; // return null char if no non-repeating character found
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            char firstUnique = findFirstNonRepeating(input);

            if (firstUnique != '\0') {
                System.out.println("First non-repeating character: " + firstUnique);
            } else {
                System.out.println("No non-repeating character found.");
            }
        }

}
