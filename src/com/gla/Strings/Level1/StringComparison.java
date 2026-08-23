package com.gla.Strings.Level1;
import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first string: ");
            String str1 = sc.next();

            System.out.print("Enter second string: ");
            String str2 = sc.next();
            boolean charAtResult = true;

            if (str1.length() != str2.length()) {
                charAtResult = false;
            } else {
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        charAtResult = false;
                        break;
                    }
                }
            }

            boolean equalsResult = str1.equals(str2);

            System.out.println("\nResult using charAt(): " + charAtResult);
            System.out.println("Result using equals(): " + equalsResult);

            if (charAtResult == equalsResult) {
                System.out.println("Both methods give the SAME result.");
            } else {
                System.out.println("Both methods give DIFFERENT results.");
            }


    }


}
