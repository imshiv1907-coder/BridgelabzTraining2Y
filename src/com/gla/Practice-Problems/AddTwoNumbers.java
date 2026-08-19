class AddTwoNumbers{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking input from user
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // Calculating sum
        int sum = num1 + num2;

        // Printing result
        System.out.println("Sum = " + sum);

        // Closing scanner
        scanner.close();
    }
}
