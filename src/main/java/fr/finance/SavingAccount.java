package fr.finance;

public class SavingAccount {

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

}
