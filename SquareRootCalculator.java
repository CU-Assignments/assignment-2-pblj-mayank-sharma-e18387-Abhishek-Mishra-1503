import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input from user
            System.out.print("Enter a number to find its square root: ");
            String input = sc.nextLine();

            // Try parsing the input to a double
            double number = Double.parseDouble(input);

            // Check for negative number
            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
            }

            double sqrt = Math.sqrt(number);
            System.out.printf("Square root of %.2f is %.4f\n", number, sqrt);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
