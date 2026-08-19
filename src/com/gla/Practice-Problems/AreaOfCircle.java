class AreaOfCircle{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking radius input
        System.out.print("Enter radius of the circle: ");
        int radius = scanner.nextInt();

        // Calculating area using int (π ≈ 22/7)
        int area = (22 * radius * radius) / 7;

        // Display result
        System.out.println("Area of the circle = " + area);

        // Closing scanner
        scanner.close();
    }
}
