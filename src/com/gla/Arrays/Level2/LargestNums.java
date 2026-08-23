package com.gla.Arrays.Level2;
import java.util.Scanner;

class LargestNums {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = sc.nextInt();
            int maxDigit = 10;
            int[] digits = new int[maxDigit];
            int index = 0;
            int temp = number;
            while (temp != 0) {
                digits[index] = temp % 10; // last digit
                temp = temp / 10;          // Remove last digit
                index++;
                if (index == maxDigit) break;
            }
            int largest = 0;
            int secondLargest = 0;
            for (int i = 0; i < index; i++) {
                if (digits[i] > largest) {
                    secondLargest = largest; // Previous largest becomes second largest
                    largest = digits[i];
                } else if (digits[i] > secondLargest && digits[i] != largest) {
                    secondLargest = digits[i];
                }
            }

            System.out.println("Largest digit: " + largest);
            System.out.println("Second largest digit: " + secondLargest);


    }

}
