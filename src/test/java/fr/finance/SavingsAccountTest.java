package fr.finance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingsAccountTest {

    @Test
    public void depositAndWithDrawal() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(100.00);
        assertEquals("After deposit", 100.00, account.balance(), 0.0000);
        account.withdraw(50.00);
        assertEquals("After withdrawal", 50.00, account.balance(), 0.0000);
    }

    @Test
    public void negativeBalanceIsJustFine() {
        SavingsAccount account = new SavingsAccount();
        account.withdraw(75);
        assertEquals("After withdrawal", -75, account.balance(), 0.0000);
    }

    @Test
    public void nextYear() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(10000);
        SavingsAccount nextYear = account.nextYear(10);
        assertEquals("After one year", 11000, nextYear.balance(), 0.0000);
    }

}