class PowerCalculation{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking inputs
        System.out.print("Enter base: ");
        int base = scanner.nextInt();

        System.out.print("Enter exponent: ");
        int exponent = scanner.nextInt();

        // Calculating power (no loops, no conditionals)
        int result = (int) Math.pow(base, exponent);

        // Display result
        System.out.println("Result = " + result);

        // Closing scanner
        scanner.close();
    }
}
