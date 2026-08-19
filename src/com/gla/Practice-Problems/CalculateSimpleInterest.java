class CalculateSimpleInterest{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking inputs
        System.out.print("Enter Principal amount: ");
        int principal = scanner.nextInt();

        System.out.print("Enter Rate of Interest: ");
        int rate = scanner.nextInt();

        System.out.print("Enter Time (in years): ");
        int time = scanner.nextInt();

        // Calculating Simple Interest
        int simpleInterest = (principal * rate * time) / 100;

        // Display result
        System.out.println("Simple Interest = " + simpleInterest);

        // Closing scanner
        scanner.close();
    }
}
