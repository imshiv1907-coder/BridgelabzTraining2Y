package com.gla.Strings.Level2;
import java.util.Scanner;

public class WordLength2D {


        public static int findLength(String text) {
            int count = 0;
            while (true) {
                try {
                    text.charAt(count);
                    count++;
                } catch (Exception e) {
                    break;
                }
            }
            return count;
        }

        // Method to split the text into words manually using charAt()
        public static String[] manualSplit(String text) {

            // count words
            int wordCount = 1;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    wordCount++;
                }
            }

            // store indexes of spaces
            int[] spaceIndexes = new int[wordCount - 1];
            int index = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    spaceIndexes[index] = i;
                    index++;
                }
            }

            // extract words
            String[] words = new String[wordCount];
            int start = 0;

            for (int w = 0; w < wordCount; w++) {
                int end;
                if (w < spaceIndexes.length) {
                    end = spaceIndexes[w];
                } else {
                    end = text.length();
                }

                String word = "";
                for (int j = start; j < end; j++) {
                    word += text.charAt(j);
                }
                words[w] = word;
                start = end + 1;
            }

            return words;
        }

        // Method to create a 2D array [word][length]
        public static String[][] wordLengthArray(String[] words) {

            String[][] data = new String[words.length][2];

            for (int i = 0; i < words.length; i++) {
                data[i][0] = words[i];
                int len = findLength(words[i]);
                data[i][1] = String.valueOf(len);  // converting int length to String
            }

            return data;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // 1. split into words
            String[] words = manualSplit(text);

            // 2. get 2D array with word and length
            String[][] result2D = wordLengthArray(words);

            // display table
            System.out.println("\nWord\t\tLength");
            System.out.println("----------------------");
            for (int i = 0; i < result2D.length; i++) {
                System.out.println(result2D[i][0] + "\t\t" +
                        Integer.parseInt(result2D[i][1]));
            }

        }

}
