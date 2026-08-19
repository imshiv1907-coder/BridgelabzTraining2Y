class VolumeOfCylinder{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking inputs
        System.out.print("Enter radius of the cylinder: ");
        int radius = scanner.nextInt();

        System.out.print("Enter height of the cylinder: ");
        int height = scanner.nextInt();

        // Calculating volume using int (π ≈ 22/7)
        int volume = (22 * radius * radius * height) / 7;

        // Display result
        System.out.println("Volume of the cylinder = " + volume);

        // Closing scanner
        scanner.close();
    }
}
