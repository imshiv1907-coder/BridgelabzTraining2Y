package com.gla.Strings.Level1;
import java.util.Scanner;

public class SubstringComparision {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the string: ");
            String text = sc.next();

            System.out.print("Enter start index: ");
            int start = sc.nextInt();

            System.out.print("Enter end index: ");
            int end = sc.nextInt();

            String subCharAt = "";

            for (int i = start; i < end; i++) {
                subCharAt = subCharAt + text.charAt(i);
            }

            String subBuiltIn = text.substring(start, end);

            boolean isSame = true;

            if (subCharAt.length() != subBuiltIn.length()) {
                isSame = false;
            } else {
                for (int i = 0; i < subCharAt.length(); i++) {
                    if (subCharAt.charAt(i) != subBuiltIn.charAt(i)) {
                        isSame = false;
                        break;
                    }
                }
            }

            System.out.println("\nSubstring using charAt(): " + subCharAt);
            System.out.println("Substring using substring(): " + subBuiltIn);
            System.out.println("Are both substrings equal? " + isSame);

        }


}
