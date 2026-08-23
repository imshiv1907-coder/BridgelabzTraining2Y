package com.gla.Strings.Level3;
import java.util.Scanner;

public class FrequencyNested {

        // a. Method to find frequency of characters using nested loops
        public static String[] findCharFrequency(String str) {
            char[] chars = str.toCharArray();
            int len = chars.length;
            int[] freq = new int[len]; // frequency for each character

            // Initialize frequency array
            for (int i = 0; i < len; i++) {
                if (chars[i] != '0') { // not marked as duplicate
                    freq[i] = 1;
                    for (int j = i + 1; j < len; j++) {
                        if (chars[i] == chars[j]) {
                            freq[i]++;
                            chars[j] = '0'; // mark duplicate
                        }
                    }
                }
            }

            // Count number of unique/non-zero characters
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (chars[i] != '0') count++;
            }

            // Create result array
            String[] result = new String[count];
            int index = 0;
            for (int i = 0; i < len; i++) {
                if (chars[i] != '0') {
                    result[index] = chars[i] + " : " + freq[i];
                    index++;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            String[] freqTable = findCharFrequency(input);

            System.out.println("\nCharacter Frequencies:");
            for (String s : freqTable) {
                System.out.println(s);
            }

         }


}
