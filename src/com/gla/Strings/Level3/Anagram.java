package com.gla.Strings.Level3;
import java.util.Scanner;

public class Anagram {
        public static boolean areAnagrams(String text1, String text2) {
            text1 = text1.replaceAll("\\s", "").toLowerCase();
            text2 = text2.replaceAll("\\s", "").toLowerCase();


            if (text1.length() != text2.length()) {
                return false;
            }

            int[] freq1 = new int[256]; // ASCII size
            int[] freq2 = new int[256];

            for (int i = 0; i < text1.length(); i++) {
                freq1[text1.charAt(i)]++;
                freq2[text2.charAt(i)]++;
            }

            // Step iv: Compare the frequencies
            for (int i = 0; i < 256; i++) {
                if (freq1[i] != freq2[i]) {
                    return false;
                }
            }

            return true; // All frequencies match
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Take user input
            System.out.print("Enter first text: ");
            String text1 = scanner.nextLine();
            System.out.print("Enter second text: ");
            String text2 = scanner.nextLine();

            // Call method and display result
            if (areAnagrams(text1, text2)) {
                System.out.println("The texts are anagrams.");
            } else {
                System.out.println("The texts are NOT anagrams.");
            }

        }


}
