package com.gla.Strings.Level1;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking size of the array
            System.out.print("Enter number of names: ");
            int n = sc.nextInt();

            String[] names = new String[n];

            // Taking input for array
            for (int i = 0; i < n; i++) {
                System.out.print("Enter name " + (i + 1) + ": ");
                names[i] = sc.next();
            }

            System.out.println("\nGenerating ArrayIndexOutOfBoundsException:");

            // Accessing index larger than array length
            // This will crash the program
            System.out.println("Accessing invalid index: " + names[n]);


        }


}
