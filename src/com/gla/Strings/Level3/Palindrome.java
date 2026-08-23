package com.gla.Strings.Level3;
import java.util.Scanner;

public class Palindrome {

        public static boolean isPalindromeIterative(String str) {
            int start = 0;
            int end = str.length() - 1;

            while (start < end) {
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }


        public static boolean isPalindromeRecursive(String str, int start, int end) {
            if (start >= end) return true;
            if (str.charAt(start) != str.charAt(end)) return false;
            return isPalindromeRecursive(str, start + 1, end - 1);
        }

        public static boolean isPalindromeReverseArray(String str) {
            int len = str.length();
            char[] original = str.toCharArray();
            char[] reversed = new char[len];

            // Reverse using charAt()
            for (int i = 0; i < len; i++) {
                reversed[i] = str.charAt(len - 1 - i);
            }

            // Compare original and reversed arrays
            for (int i = 0; i < len; i++) {
                if (original[i] != reversed[i]) return false;
            }

            return true;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a text to check palindrome: ");
            String input = sc.nextLine();

            // Remove spaces and convert to lowercase for consistent checking
            String text = input.replaceAll("\\s+", "").toLowerCase();

            System.out.println("\nPalindrome Check Results:");
            System.out.println("Logic 1 (Iterative): " + (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));
            System.out.println("Logic 2 (Recursive): " + (isPalindromeRecursive(text, 0, text.length() - 1) ? "Palindrome" : "Not Palindrome"));
            System.out.println("Logic 3 (Reverse Array): " + (isPalindromeReverseArray(text) ? "Palindrome" : "Not Palindrome"));

        }

}
