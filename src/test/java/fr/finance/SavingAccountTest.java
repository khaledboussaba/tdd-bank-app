package fr.finance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingAccountTest {

    @Test
    public void depositAndWithDrawal() {
        SavingAccount account = new SavingAccount();
        account.deposit(100.00);
        assertEquals("After deposit", 100.00, account.balance(), 0.0000);
        account.withdraw(50.00);
        assertEquals("After withdrawal", 50.00, account.balance(), 0.0000);
    }

    @Test
    public void negativeBalanceIsJustFine() {
        SavingAccount account = new SavingAccount();
        account.withdraw(75);
        assertEquals("After withdrawal", -75, account.balance(), 0.0000);
    }

}