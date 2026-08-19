class ConvertKilometerToMiles{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking distance in kilometers
        System.out.print("Enter distance in kilometers: ");
        int kilometers = scanner.nextInt();

        // Converting to miles (approximation using integer arithmetic)
        int miles = (kilometers * 621371) / 1000000;

        // Displaying result
        System.out.println("Distance in miles = " + miles);

        // Closing scanner
        scanner.close();
    }
}
