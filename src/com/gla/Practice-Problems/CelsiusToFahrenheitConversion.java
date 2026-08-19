class CelsiusToFahrenheitConversion{
    public static void main(String[] args) {

        // Creating Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Taking Celsius input as integer
        System.out.print("Enter temperature in Celsius: ");
        int celsius = scanner.nextInt();

        // Conversion formula using int
        int fahrenheit = (celsius * 9 / 5) + 32;

        // Display result
        System.out.println("Temperature in Fahrenheit = " + fahrenheit);

        // Closing scanner
        scanner.close();
    }
}
