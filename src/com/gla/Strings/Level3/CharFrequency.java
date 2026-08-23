package com.gla.Strings.Level3;
import java.util.Scanner;

public class CharFrequency {

        // a. Method to find frequency of characters
        public static String[][] findCharFrequency(String str) {
            int[] freq = new int[256]; // ASCII frequency array
            int len = 0;

            // Find length without using length()
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

            // Count number of unique characters
            int uniqueCount = 0;
            for (int i = 0; i < 256; i++) {
                if (freq[i] > 0) uniqueCount++;
            }

            // Create result 2D array
            String[][] result = new String[uniqueCount][2];
            int index = 0;
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                if (freq[(int) ch] != 0) { // if not already added
                    result[index][0] = String.valueOf(ch);
                    result[index][1] = String.valueOf(freq[(int) ch]);
                    freq[(int) ch] = 0; // mark as added
                    index++;
                }
            }

            return result;
        }

        // b. Display the frequency table
        public static void displayFrequency(String[][] freqTable) {
            System.out.printf("%-10s | %-10s\n", "Character", "Frequency");
            System.out.println("------------------------");
            for (int i = 0; i < freqTable.length; i++) {
                System.out.printf("%-10s | %-10s\n", freqTable[i][0], freqTable[i][1]);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            String[][] freqTable = findCharFrequency(input);

            displayFrequency(freqTable);

        }


}
