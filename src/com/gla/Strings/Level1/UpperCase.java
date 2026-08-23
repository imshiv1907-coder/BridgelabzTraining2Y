package com.gla.Strings.Level1;
import java.util.Scanner;

public class UpperCase {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter complete text: ");
            String text = sc.nextLine();

            String manualUpper = "";

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (c >= 'a' && c <= 'z') {
                    char upperC = (char)(c - 32);
                    manualUpper += upperC;
                } else {
                    manualUpper += c;
                }
            }

            String builtInUpper = text.toUpperCase();

            boolean isSame = true;

            if (manualUpper.length() != builtInUpper.length()) {
                isSame = false;
            } else {
                for (int i = 0; i < manualUpper.length(); i++) {
                    if (manualUpper.charAt(i) != builtInUpper.charAt(i)) {
                        isSame = false;
                        break;
                    }
                }
            }

            // Display results
            System.out.println("\nManual uppercase text : " + manualUpper);
            System.out.println("Built‑in uppercase text: " + builtInUpper);
            System.out.println("Are both results equal? " + isSame);

        }

}
