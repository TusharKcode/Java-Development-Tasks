package tasks.intermediate;

import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        if (initialBalance < 0){
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    //    Deposit Method
    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Deposit amount must be greater than 0!");
            return;
        }
        balance += amount;
        System.out.println("Successfully Deposited: ₹ " + amount);
    }

    //    Withdraw Method
    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Withdraw amount must be greater than 0!");
            return;
        }

        if (amount > balance){
            System.out.println("Insufficient amount! Your current balance is: ₹ " + balance);
            return;
        }

        balance -= amount;
        System.out.println("Successfully withdraw: ₹ " + amount);
    }

    //    Get/Check Balance Method
    public double getBalance(){
        return balance;
    }
}

public class BankingAppTask {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BankAccount account = new BankAccount(0); // Initial Balance will be 0

        boolean running = true;

        System.out.println("===== Simple Banking System =====");
        while(running){
            System.out.println("\nChoose an option");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("\nEnter Choice: ");

            int choice = scn.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter Deposit amount: ");
                    double depAmt = scn.nextDouble();
                    account.deposit(depAmt);
                    break;

                case 2:
                    System.out.println("Enter Withdraw amount: ");
                    double wdAmt = scn.nextDouble();
                    account.withdraw(wdAmt);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹ " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting.... Thank you for using the banking system!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Choice! Please Try again.");
            }
        }
    }
}
