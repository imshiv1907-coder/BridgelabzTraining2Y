package com.gla.Strings.Level2;
import java.util.Scanner;

public class CharTable {

        // Method to check type of character
        public static String getCharType(char c) {

            // Convert uppercase letter to lowercase using ASCII if needed
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }

            // Check if vowel
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            }

            // Check if consonant (letter case)
            if (c >= 'a' && c <= 'z') {
                return "Consonant";
            }

            // Not a letter (digit, space, symbol, etc.)
            return "Not a Letter";
        }

        // Method to get a 2D array [character][type]
        public static String[][] analyzeText(String text) {

            String[][] result = new String[text.length()][2];

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                result[i][0] = String.valueOf(c);           // character
                result[i][1] = getCharType(c);              // type
            }

            return result;
        }

        // Method to display the 2D array in a table
        public static void displayTable(String[][] table) {
            System.out.println("\nCharacter\tType");
            System.out.println("-----------------------------");

            for (int i = 0; i < table.length; i++) {
                System.out.println(table[i][0] + "\t\t" + table[i][1]);
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter text: ");
            String input = sc.nextLine();

            // analyze characters and get table
            String[][] charTable = analyzeText(input);

            // display in tabular format
            displayTable(charTable);

        }


}
