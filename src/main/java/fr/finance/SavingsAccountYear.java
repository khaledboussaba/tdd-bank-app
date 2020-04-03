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

    public double endingBalance() {
        return startingBalance + (startingBalance * interestRate) / 100;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

}
