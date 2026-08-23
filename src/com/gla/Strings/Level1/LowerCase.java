package com.gla.Strings.Level1;
import java.util.Scanner;

public class LowerCase {
   public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking full text input
            System.out.print("Enter complete text: ");
            String text = sc.nextLine();

            // Manually converting to lowercase using charAt() and ASCII
            String manualLower = "";

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                // if uppercase A–Z, convert to lowercase
                if (c >= 'A' && c <= 'Z') {
                    char lowerC = (char)(c + 32);
                    manualLower += lowerC;
                } else {
                    manualLower += c;
                }
            }

            // Using built‑in toLowerCase()
            String builtInLower = text.toLowerCase();

            // Comparing manualLower and builtInLower using charAt()
            boolean isSame = true;

            if (manualLower.length() != builtInLower.length()) {
                isSame = false;
            } else {
                for (int i = 0; i < manualLower.length(); i++) {
                    if (manualLower.charAt(i) != builtInLower.charAt(i)) {
                        isSame = false;
                        break;
                    }
                }
            }

            // Displaying results
            System.out.println("\nManual lowercase text  : " + manualLower);
            System.out.println("Built‑in lowercase text: " + builtInLower);
            System.out.println("Are both results equal? " + isSame);

        }


}
