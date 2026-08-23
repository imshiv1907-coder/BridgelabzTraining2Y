package com.gla.Strings.Level3;
import java.util.Scanner;

public class Frequency {

        // a. Method to find unique characters
        public static char[] uniqueCharacters(String str) {
            int len = 0;
            try {
                while (true) {
                    str.charAt(len);
                    len++;
                }
            } catch (StringIndexOutOfBoundsException e) {
                // reached end of string
            }

            char[] temp = new char[len];
            int uniqueCount = 0;

            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                boolean isUnique = true;
                for (int j = 0; j < uniqueCount; j++) {
                    if (temp[j] == ch) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    temp[uniqueCount] = ch;
                    uniqueCount++;
                }
            }

            char[] uniqueChars = new char[uniqueCount];
            for (int i = 0; i < uniqueCount; i++) {
                uniqueChars[i] = temp[i];
            }

            return uniqueChars;
        }

        // b. Method to find frequency of unique characters
        public static String[][] charFrequency(String str) {
            int[] freq = new int[256]; // ASCII frequency array
            int len = 0;

            // Find length without using length()
            try {
                while (true) {
                    str.charAt(len);
                    len++;
                }
            } catch (StringIndexOutOfBoundsException e) {
            }

            // Count frequency of each character
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                freq[(int) ch]++;
            }

            // Find unique characters
            char[] uniqueChars = uniqueCharacters(str);

            // Create 2D array to store character and frequency
            String[][] result = new String[uniqueChars.length][2];
            for (int i = 0; i < uniqueChars.length; i++) {
                result[i][0] = String.valueOf(uniqueChars[i]);
                result[i][1] = String.valueOf(freq[(int) uniqueChars[i]]);
            }

            return result;
        }

        // c. Method to display frequency table
        public static void displayFrequency(String[][] table) {
            System.out.printf("%-10s | %-10s\n", "Character", "Frequency");
            System.out.println("------------------------");
            for (int i = 0; i < table.length; i++) {
                System.out.printf("%-10s | %-10s\n", table[i][0], table[i][1]);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            String[][] freqTable = charFrequency(input);

            displayFrequency(freqTable);

        }


}
