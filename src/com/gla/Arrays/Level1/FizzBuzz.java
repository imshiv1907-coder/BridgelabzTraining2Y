package com.gla.Arrays.Level1;
import java.util.Scanner;
class FizzBuzz {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a positive integer: ");
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Please enter a positive integer.");
            } else {
                String[] result = new String[n + 1];
                    for (int i = 0; i <= n; i++) {
                        if (i != 0 && i % 3 == 0 && i % 5 == 0) {
                        result[i] = "FizzBuzz";
                    } else if (i != 0 && i % 3 == 0) {
                        result[i] = "Fizz";
                    } else if (i != 0 && i % 5 == 0) {
                        result[i] = "Buzz";
                    } else {
                        result[i] = String.valueOf(i);
                    }
                }
                for (int i = 1; i <= n; i++) {
                    System.out.println("Position " + i + " = " + result[i]);
                }
            }
    }
}
