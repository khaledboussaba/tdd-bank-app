package fr.finance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingsAccountYearTest {

    @Test
    public void startingBalance() {
        assertEquals("", 10000, newAccount().startingBalance(), 0.0000);
    }

    @Test
    public void interestRate() {
        assertEquals("", 10, newAccount().interestRate(), 0.0000);
    }

    @Test
    public void endingBalance() {
        assertEquals("", 11000, newAccount().endingBalance(), 0.0000);
    }

    @Test
    public void nextYearsStartingBalanceShouldEqualsThisYearsEndingBalance() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals("", thisYear.endingBalance(), thisYear.nextYear().startingBalance(), 0.0000);
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals("", thisYear.interestRate(), thisYear.nextYear().interestRate(), 0.0000);
    }

    private SavingsAccountYear newAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        return account;
    }

}