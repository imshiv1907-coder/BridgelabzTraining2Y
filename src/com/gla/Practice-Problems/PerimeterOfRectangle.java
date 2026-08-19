class PerimeterOfRectangle{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking inputs
        System.out.print("Enter length of the rectangle: ");
        int length = scanner.nextInt();

        System.out.print("Enter width of the rectangle: ");
        int width = scanner.nextInt();

        // Calculating perimeter
        int perimeter = 2 * (length + width);

        // Display result
        System.out.println("Perimeter of the rectangle = " + perimeter);

        // Closing scanner
        scanner.close();
    }
}
