package fr.finance;

public class SavingsAccountYear {

    private double startingBalance;
    private double startingPrincipal;
    private double interestRate;
    private double capitalGainsAmount;
    private double totalWithdrawn;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(double startingBalance, double interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(double startingBalance, double startingPrincipal, double interestRate) {
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.capitalGainsAmount = startingBalance - startingPrincipal;
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

    public double totalWithdrawn() {
        return totalWithdrawn;
    }

    public double endingPrinciple() {
        double result = startingPrinciple() - totalWithdrawn();
        return (result < 0) ? 0 : result;
    }

    public double endingBalance(double capitalGainsTaxRate) {
        double modifiedStart = startingBalance - totalWithdrawn() - capitalGainsTaxIncurred(capitalGainsTaxRate);
        return modifiedStart + (modifiedStart * interestRate) / 100;
    }

    public SavingsAccountYear nextYear(double capitalGainsTaxRate) {
        return new SavingsAccountYear(this.endingBalance(capitalGainsTaxRate), interestRate);
    }

    public void withdraw(double amount) {
        this.totalWithdrawn += amount;
    }

    public double capitalGainsWithdrawn() {
        double result = -1 * (startingPrinciple() - totalWithdrawn());
        return (result < 0) ? 0 : result;
    }

    public double capitalGainsTaxIncurred(double taxRate) {
        double dblTaxRate = taxRate / 100;
        double dblCapGains = capitalGainsWithdrawn();
        return dblCapGains / (1 - dblTaxRate) - dblCapGains;
    }
}
