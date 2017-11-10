package bankservice;

import bankservice.BankAccount;
import java.util.Scanner;

public class AccountController {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(2452.78);
        bankServices(bankAccount);
    }

    private static void errMsg(){
        String errMsg = "Invalid amount. Please use positive decimal amounts and do not exceed two decimal points.";
        System.out.println(errMsg);
    }

    private static double amountHandler(String service) {
        double amount = 0;
        System.out.println("Please enter an amount to " + service + ": ");
        try {
            amount = scan.nextDouble();
            if (amount < 0 || !hasTwoDecimalPoints(amount)) {
                errMsg();
                return amountHandler(service);
            }
        } catch (InputMismatchException e) {
            if (!scan.hasNextDouble()) {
                scan.next();
                errMsg();
                return amountHandler(service);
            }
        }

        return amount;
    }

    public static void bankServices(BankAccount account) {

        Scanner scan = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            System.out.println("Please enter in a command (Deposit, Withdraw, Balance, Exit) : ");
            command = (scan.next()).toLowerCase();

            switch (command) {
                case "deposit":
                    account.deposit(amountHandler("deposit"));
                    break;
                case "withdraw":
                    account.withdraw(amountHandler("withdraw"));
                    break;
                case "balance":
                    printBalance(account);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    bankServices(account);
            }
        }
    }

    private static void printBalance(BankAccount account) {
        System.out.printf("The current balance is: $%.2f", account.getBalance());
        System.out.println();

    }

    private static boolean hasTwoDecimalPoints(double amount) {
        String text = Double.toString(Math.abs(amount));
        int integerPlaces = text.indexOf('.');
        int decimalPlaces = text.length() - integerPlaces - 1;
        return decimalPlaces < 3;
    }

}

