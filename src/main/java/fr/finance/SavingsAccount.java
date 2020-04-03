package fr.finance;

public class SavingsAccount {

    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double balance() {
        return balance;
    }

    public SavingsAccount nextYear(double interestRate) {
        SavingsAccount nextYear = new SavingsAccount();
        nextYear.balance = balance() + (balance() * interestRate) / 100;
        return nextYear;
    }

}
