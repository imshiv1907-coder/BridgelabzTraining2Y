package com.gla.Strings.Level3;
import java.util.Scanner;

public class UniqueChar {

        // a. Method to find length of string without using length()
        public static int findLength(String str) {
            int count = 0;
            try {
                while (true) {
                    str.charAt(count);
                    count++;
                }
            } catch (StringIndexOutOfBoundsException e) {
                // reached end of string
            }
            return count;
        }

        // b. Method to find unique characters
        public static char[] findUniqueChars(String str) {
            int len = findLength(str);
            char[] temp = new char[len]; // temporary array to store unique chars
            int uniqueCount = 0;

            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                boolean isUnique = true;

                // check if character already exists in temp array
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

            // create final array of exact size
            char[] uniqueChars = new char[uniqueCount];
            for (int i = 0; i < uniqueCount; i++) {
                uniqueChars[i] = temp[i];
            }

            return uniqueChars;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            char[] uniqueChars = findUniqueChars(input);

            System.out.print("Unique characters: ");
            for (char ch : uniqueChars) {
                System.out.print(ch + " ");
            }

        }

}
