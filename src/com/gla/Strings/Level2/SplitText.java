package com.gla.Strings.Level2;
import java.util.Scanner;

public class SplitText {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // --- Manually split the text into words ---

            // 1️⃣ Count words (based on spaces)
            int wordCount = 1;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    wordCount++;
                }
            }

            // 2️⃣ Collect space indexes
            int[] spaceIndexes = new int[wordCount - 1];
            int idx = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    spaceIndexes[idx] = i;
                    idx++;
                }
            }

            // 3️⃣ Extract words manually
            String[] manualWords = new String[wordCount];
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

                manualWords[w] = word;
                start = end + 1;
            }

            // --- Built‑in split() ---
            String[] builtinWords = text.split(" ");

            // --- Compare the two arrays ---
            boolean isSame = true;

            if (manualWords.length != builtinWords.length) {
                isSame = false;
            } else {
                for (int i = 0; i < manualWords.length; i++) {
                    if (!manualWords[i].equals(builtinWords[i])) {
                        isSame = false;
                        break;
                    }
                }
            }

            // --- Display Results ---

            System.out.println("\nManual split words:");
            for (String w : manualWords) {
                System.out.println(w);
            }

            System.out.println("\nBuilt‑in split words:");
            for (String w : builtinWords) {
                System.out.println(w);
            }

            System.out.println("\nAre both results equal? " + isSame);

            sc.close();
        }


}
