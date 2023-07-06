package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt for customer name
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        // Prompt for customer ID
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        // Create an instance of BankAccount with the provided data
        BankAccount account = new BankAccount(customerName, customerId);

        // Show the menu options to the customer
        account.showMenu(scanner);
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    void showMenu(Scanner scanner) {
        char option;
        do {
            // Show customer name and ID
            System.out.println("Welcome, " + customerName);
            System.out.println("Your ID is: " + customerId);
            System.out.println();

            // Show menu options
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");

            // Prompt for option
            System.out.print("Enter an option: ");
            option = scanner.next().charAt(0);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("Balance = " + balance);
                    System.out.println();
                    break;

                case 'B':
                    System.out.print("Enter an amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.print("Enter an amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println();
                    break;

                case 'D':
                    getPreviousTransaction();
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("Thank you for using our services!");
                    break;

                default:
                    System.out.println("Invalid option! Please enter a valid option.");
                    System.out.println();
                    break;
            }
        } while (option != 'E');
    }
}
