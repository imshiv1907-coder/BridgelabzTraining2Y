package com.gla.Strings.Level2;
import java.util.Scanner;

public class ShortLong {


        // Method to find length without using length()
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

        // Method to split text into words without split()
        public static String[] manualSplit(String text) {

            // count words based on spaces
            int wordCount = 1;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    wordCount++;
                }
            }

            // collect space indexes
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

        // Method to create 2D array of words & lengths
        public static String[][] createWordLengthArray(String[] words) {

            String[][] data = new String[words.length][2];

            for (int i = 0; i < words.length; i++) {
                data[i][0] = words[i];
                int len = findLength(words[i]);
                data[i][1] = String.valueOf(len);
            }

            return data;
        }

        // Method to find shortest and longest word
        // Returns an array: [indexOfShortestWord, indexOfLongestWord]
        public static int[] findShortestLongest(String[][] wordData) {

            int shortestIndex = 0;
            int longestIndex = 0;

            int shortestLength = Integer.parseInt(wordData[0][1]);
            int longestLength = Integer.parseInt(wordData[0][1]);

            for (int i = 1; i < wordData.length; i++) {

                int currentLength = Integer.parseInt(wordData[i][1]);

                if (currentLength < shortestLength) {
                    shortestLength = currentLength;
                    shortestIndex = i;
                }
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestIndex = i;
                }
            }

            return new int[] { shortestIndex, longestIndex };
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // split text manually
            String[] words = manualSplit(text);

            // create 2D array word + length
            String[][] wordData = createWordLengthArray(words);

            // find shortest & longest words
            int[] resultIndexes = findShortestLongest(wordData);

            int shortestIdx = resultIndexes[0];
            int longestIdx = resultIndexes[1];

            // display the words with lengths
            System.out.println("\nWord\t\tLength");
            System.out.println("--------------------------");
            for (int i = 0; i < wordData.length; i++) {
                System.out.println(wordData[i][0] + "\t\t" + wordData[i][1]);
            }

            System.out.println("\nShortest word: " + wordData[shortestIdx][0] +
                    " (Length: " + wordData[shortestIdx][1] + ")");
            System.out.println("Longest word : " + wordData[longestIdx][0] +
                    " (Length: " + wordData[longestIdx][1] + ")");

        }


}
