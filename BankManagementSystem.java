import java.util.Scanner;
class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Withdrawal failed! Insufficient balance or invalid amount.");
        }
    }
    public double checkBalance() {
        return balance;
    }
    public void displayAccount() {
        System.out.println("--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
    }
}
public class BankManagementSystem {
    public static void performDeposit(BankAccount account, Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);
    }
    public static void performWithdrawal(BankAccount account, Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initBalance = sc.nextDouble();
        BankAccount myAccount = new BankAccount(accNum, name, initBalance);
        performDeposit(myAccount, sc);
        performWithdrawal(myAccount, sc);
        myAccount.displayAccount();
        sc.close();
    }
}
