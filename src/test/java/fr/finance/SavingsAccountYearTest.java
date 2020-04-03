package fr.finance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingsAccountYearTest {

    @Test
    public void depositAndWithDrawal() {
        SavingsAccountYear account = new SavingsAccountYear();
        account.deposit(100.00);
        assertEquals("After deposit", 100.00, account.balance(), 0.0000);
        account.withdraw(50.00);
        assertEquals("After withdrawal", 50.00, account.balance(), 0.0000);
    }

    @Test
    public void negativeBalanceIsJustFine() {
        SavingsAccountYear account = new SavingsAccountYear();
        account.withdraw(75);
        assertEquals("After withdrawal", -75, account.balance(), 0.0000);
    }

    @Test
    public void nextYear() {
        SavingsAccountYear account = new SavingsAccountYear();
        account.deposit(10000);
        SavingsAccountYear nextYear = account.nextYear(10);
        assertEquals("After one year", 11000, nextYear.balance(), 0.0000);
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals("After one year", 11000, account.endingBalance(), 0.0000);
    }

}