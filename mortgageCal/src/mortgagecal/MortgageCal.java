package mortgagecal;

import java.util.Scanner;

public class MortgageCal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter loan amount (USD): ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter loan term (years): ");
        int loanTermYears = scanner.nextInt();

        // Convert annual interest rate to monthly interest rate
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        int numberOfPayments = loanTermYears * 12;

        // Calculate monthly payment (mortgage formula)
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        // Display result
        System.out.printf("Monthly payment: %.2f USD\n", monthlyPayment);

        scanner.close();
    }
}
