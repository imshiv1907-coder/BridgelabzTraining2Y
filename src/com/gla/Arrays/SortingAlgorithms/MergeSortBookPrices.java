package com.gla.Arrays.SortingAlgorithms;
import java.util.Scanner;

public class MergeSortBookPrices {

        static void merge(double[] prices, int left, int middle, int right) {
            int n1 = middle - left + 1;
            int n2 = right - middle;

            double[] leftArray = new double[n1];
            double[] rightArray = new double[n2];

            for (int i = 0; i < n1; i++) {
                leftArray[i] = prices[left + i];
            }

            for (int j = 0; j < n2; j++) {
                rightArray[j] = prices[middle + 1 + j];
            }

            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    prices[k] = leftArray[i];
                    i++;
                } else {
                    prices[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                prices[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < n2) {
                prices[k] = rightArray[j];
                j++;
                k++;
            }
        }

        static void mergeSort(double[] prices, int left, int right) {
            if (left < right) {
                int middle = left + (right - left) / 2;

                mergeSort(prices, left, middle);
                mergeSort(prices, middle + 1, right);

                merge(prices, left, middle, right);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of books: ");
            int n = sc.nextInt();

            double[] prices = new double[n];

            System.out.println("Enter book prices:");
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextDouble();
            }

            mergeSort(prices, 0, n - 1);

            System.out.println("Book prices in ascending order:");
            for (double price : prices) {
                System.out.printf("%.2f ", price);
            }

            sc.close();
        }

}
