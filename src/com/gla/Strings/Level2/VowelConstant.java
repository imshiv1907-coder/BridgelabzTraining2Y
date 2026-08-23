package com.gla.Strings.Level2;
import java.util.Scanner;

public class VowelConstant {

        // Method to check if a character is vowel, consonant, or not a letter
        public static String checkChar(char c) {

            // Convert uppercase to lowercase using ASCII logic
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }

            // Check for vowel
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            }

            // Check for consonant
            if (c >= 'a' && c <= 'z') {
                return "Consonant";
            }

            // Not a letter
            return "NotLetter";
        }

        // Method to count vowels and consonants in a string
        // Returns an array where [0] = vowel count, [1] = consonant count
        public static int[] countVowelsConsonants(String text) {
            int vowelCount = 0;
            int consonantCount = 0;

            for (int i = 0; i < text.length(); i++) {
                String result = checkChar(text.charAt(i));
                if (result.equals("Vowel")) {
                    vowelCount++;
                } else if (result.equals("Consonant")) {
                    consonantCount++;
                }
            }

            return new int[] { vowelCount, consonantCount };
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Take user input
            System.out.print("Enter text: ");
            String input = sc.nextLine();

            // Call method to count vowels and consonants
            int[] counts = countVowelsConsonants(input);

            // Display results
            System.out.println("\nNumber of vowels     : " + counts[0]);
            System.out.println("Number of consonants : " + counts[1]);


        }

}
