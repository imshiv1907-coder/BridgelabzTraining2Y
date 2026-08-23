package com.gla.Arrays.SortingAlgorithms;
import java.util.Scanner;

public class InsertionSortEmployeeIDs {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();

            int[] employeeIds = new int[n];

            System.out.println("Enter employee IDs:");
            for (int i = 0; i < n; i++) {
                employeeIds[i] = sc.nextInt();
            }

            // Insertion Sort
            for (int i = 1; i < n; i++) {
                int key = employeeIds[i];
                int j = i - 1;

                while (j >= 0 && employeeIds[j] > key) {
                    employeeIds[j + 1] = employeeIds[j];
                    j--;
                }

                employeeIds[j + 1] = key;
            }

            // Display sorted employee IDs
            System.out.println("Employee IDs in ascending order:");
            for (int id : employeeIds) {
                System.out.print(id + " ");
            }

            sc.close();
        }
}
