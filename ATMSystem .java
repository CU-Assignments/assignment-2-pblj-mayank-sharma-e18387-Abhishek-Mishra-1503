import java.util.Scanner;

// Custom exception for invalid PIN
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMSystem {
    private static final String CORRECT_PIN = "1234";
    private static double balance = 5000.00;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Ask user to enter PIN
            System.out.print("Enter your PIN: ");
            String enteredPin = sc.nextLine();

            // Check PIN
            if (!enteredPin.equals(CORRECT_PIN)) {
                throw new InvalidPinException("Invalid PIN entered.");
            }

            // Ask for withdrawal amount
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            // Check balance
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance for the withdrawal.");
            }

            // Perform withdrawal
            balance -= amount;
            System.out.println("Withdrawal of ₹" + amount + " successful.");

        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            System.out.printf("Remaining Balance: ₹%.2f\n", balance);
            sc.close();
        }
    }
}
