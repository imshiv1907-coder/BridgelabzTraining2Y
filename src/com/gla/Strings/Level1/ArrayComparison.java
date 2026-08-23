package com.gla.Strings.Level1;
import java.util.Scanner;

public class ArrayComparison {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the string: ");
            String text = sc.next();

            char[] manualArray = new char[text.length()];

            for (int i = 0; i < text.length(); i++) {
                manualArray[i] = text.charAt(i);
            }

            char[] builtInArray = text.toCharArray();

            boolean isSame = true;

            if (manualArray.length != builtInArray.length) {
                isSame = false;
            } else {
                for (int i = 0; i < manualArray.length; i++) {
                    if (manualArray[i] != builtInArray[i]) {
                        isSame = false;
                        break;
                    }
                }
            }

            System.out.print("\nCharacters using charAt(): ");
            for (char c : manualArray) {
                System.out.print(c + " ");
            }

            System.out.print("\nCharacters using toCharArray(): ");
            for (char c : builtInArray) {
                System.out.print(c + " ");
            }

            System.out.println("\n\nAre both character arrays equal? " + isSame);

        }

}
