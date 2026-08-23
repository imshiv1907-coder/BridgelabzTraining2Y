package com.gla.Strings.Level2;
import java.util.Scanner;

public class TrimMethod {

        // a. Method to find start and end index after trimming
        public static int[] findTrimIndices(String str) {
            int start = 0;
            int end = str.length() - 1;

            // Trim leading spaces
            while (start <= end && str.charAt(start) == ' ') {
                start++;
            }

            // Trim trailing spaces
            while (end >= start && str.charAt(end) == ' ') {
                end--;
            }

            // Return start and end indices
            return new int[]{start, end};
        }

        // b. Method to create a substring using charAt()
        public static String customSubstring(String str, int start, int end) {
            String result = "";
            for (int i = start; i <= end; i++) {
                result += str.charAt(i);
            }
            return result;
        }

        // c. Method to compare two strings using charAt()
        public static boolean compareStrings(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Input string
            System.out.print("Enter a string with spaces: ");
            String input = sc.nextLine();

            // Using custom trim
            int[] indices = findTrimIndices(input);
            String trimmedCustom = customSubstring(input, indices[0], indices[1]);

            // Using built-in trim()
            String trimmedBuiltIn = input.trim();

            // Display results
            System.out.println("Custom trimmed string: '" + trimmedCustom + "'");
            System.out.println("Built-in trimmed string: '" + trimmedBuiltIn + "'");

            // Compare both trimmed strings
            boolean areEqual = compareStrings(trimmedCustom, trimmedBuiltIn);
            System.out.println("Are custom trim and built-in trim equal? " + areEqual);

        }

}
