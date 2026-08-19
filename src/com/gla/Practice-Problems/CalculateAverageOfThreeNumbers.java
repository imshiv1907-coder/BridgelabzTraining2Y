class CalculateAverageOfThreeNumbers{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking three numbers as input
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        // Calculating average (integer division)
        int average = (num1 + num2 + num3) / 3;

        // Displaying the result
        System.out.println("Average = " + average);

        // Closing scanner
        scanner.close();
    }
}
