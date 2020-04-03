package fr.finance;

public class SavingsAccountYear {

    private double startingBalance;
    private double interestRate;
    private double capitalGainsAmount;
    private double totalWithdrawn;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(double startingBalance, double interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(double startingBalance, double capitalGainsAmount, double interestRate) {
        this.startingBalance = startingBalance;
        this.capitalGainsAmount = capitalGainsAmount;
        this.interestRate = interestRate;
    }

    public double startingBalance() {
        return startingBalance;
    }

    public double startingPrinciple() {
        return startingBalance - capitalGainsAmount;
    }

    public double interestRate() {
        return interestRate;
    }

    public double endingPrinciple() {
        double result = startingPrinciple() - totalWithdrawn;
        return (result < 0) ? 0 : result;
    }

    public double endingBalance() {
        double modifiedStart = startingBalance - totalWithdrawn;
        return modifiedStart + (modifiedStart * interestRate) / 100;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public void withdraw(double amount) {
        this.totalWithdrawn += amount;
    }

}
