package com.gla.Strings.Level1;
import java.util.Scanner;

public class IllegalArgumentException {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking user input
            System.out.print("Enter a string: ");
            String text = sc.next();

            // Generating IllegalArgumentException
            // start index is greater than end index
            System.out.println("Substring is:");
            System.out.println(text.substring(5, 2)); // Exception occurs here


        }


}
