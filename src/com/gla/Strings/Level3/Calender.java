package com.gla.Strings.Level3;
import java.util.Scanner;

public class Calender {
    static String[] months = { "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        // Array to store days in each month
        static int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Method to check if a year is leap
        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        // Method to get number of days in a month
        public static int getNumberOfDays(int month, int year) {
            if (month == 2 && isLeapYear(year)) {
                return 29;
            } else {
                return daysInMonth[month];
            }
        }

        // Method to get the first day of the month using Gregorian algorithm
        // Returns 0 = Sunday, 1 = Monday, ..., 6 = Saturday
        public static int getFirstDayOfMonth(int month, int year) {
            int y0 = year - (14 - month) / 12;
            int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
            int m0 = month + 12 * ((14 - month) / 12) - 2;
            int d0 = (1 + x + (31 * m0) / 12) % 7;
            return d0;
        }

        // Method to display the calendar
        public static void displayCalendar(int month, int year) {
            System.out.println("    " + months[month] + " " + year);
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

            int firstDay = getFirstDayOfMonth(month, year);
            int totalDays = getNumberOfDays(month, year);

            // First loop: print spaces for the first day
            for (int i = 0; i < firstDay; i++) {
                System.out.print("    "); // 4 spaces for alignment
            }

            // Second loop: print days of the month
            for (int day = 1; day <= totalDays; day++) {
                System.out.printf("%4d", day);

                if ((day + firstDay) % 7 == 0) {
                    System.out.println(); // Move to next line after Saturday
                }
            }
            System.out.println(); // Final newline
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input month and year
            System.out.print("Enter month (1-12): ");
            int month = scanner.nextInt();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();

            // Display calendar
            displayCalendar(month, year);

        }


}
