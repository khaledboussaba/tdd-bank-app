package fr.finance;

public class SavingsAccountYear {

    private double startingBalance;
    private double interestRate;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(double startingBalance, double interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public double startingBalance() {
        return startingBalance;
    }

    public double interestRate() {
        return interestRate;
    }

    public void deposit(double amount) {
        startingBalance += amount;
    }

    public void withdraw(double amount) {
        startingBalance -= amount;
    }

    public double balance() {
        return startingBalance;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public double endingBalance() {
        return balance() + (balance() * interestRate) / 100;
    }

}
