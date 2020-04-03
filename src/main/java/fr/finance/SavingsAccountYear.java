package fr.finance;

public class SavingsAccountYear {

    private double balance;
    private double interestRate;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(double startingBalance, double interestRate) {
        this.balance = startingBalance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double balance() {
        return balance;
    }

    public SavingsAccountYear nextYear(double interestRate) {
        SavingsAccountYear nextYear = new SavingsAccountYear();
        nextYear.balance = balance() + (balance() * interestRate) / 100;
        return nextYear;
    }

    public double endingBalance() {
        return balance() + (balance() * interestRate) / 100;
    }
}
