package com.gla.Strings.Level1;
import java.util.Scanner;

public class NumberFormatException {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking user input as String
            System.out.print("Enter a value: ");
            String text = sc.next();

            // Generating NumberFormatException
            // If input is not numeric, this will crash the program
            int num = Integer.parseInt(text);

            System.out.println("Converted number: " + num);

        }

}
