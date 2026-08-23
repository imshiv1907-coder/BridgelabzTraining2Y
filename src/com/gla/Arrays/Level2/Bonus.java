package com.gla.Arrays.Level2;
import java.util.Scanner;
class Bonus {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double[] salary = new double[10], bonus = new double[10], newSalary = new double[10];
            double totalOld = 0, totalBonus = 0, totalNew = 0;

            for (int i = 0; i < 10; i++) {
                System.out.print("Salary for employee " + (i + 1) + ": ");
                salary[i] = sc.nextDouble();
                System.out.print("Years of service: ");
                double years = sc.nextDouble();

                bonus[i] = (years > 5) ? salary[i] * 0.05 : salary[i] * 0.02;
                newSalary[i] = salary[i] + bonus[i];

                totalOld += salary[i];
                totalBonus += bonus[i];
                totalNew += newSalary[i];
            }

            System.out.println("\nEmployee Details:");
            for (int i = 0; i < 10; i++)
                System.out.println("Emp " + (i + 1) + ": Old=" + salary[i] + ", Bonus=" + bonus[i] + ", New=" + newSalary[i]);

            System.out.println("\nTotal Old=" + totalOld + ", Total Bonus=" + totalBonus + ", Total New=" + totalNew);

        }
}
