package fr.finance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingsAccountYearTest {

    @Test
    public void startingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals("After one year", 10000, account.startingBalance(), 0.0000);
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals("After one year", 11000, account.endingBalance(), 0.0000);
    }

    @Test
    public void nextYearsStartingBalanceShouldEqualsThisYearsEndingBalance() {
        SavingsAccountYear thisYear = new SavingsAccountYear(10000, 10);
        assertEquals("After one year", thisYear.endingBalance(), thisYear.nextYear().startingBalance(), 0.0000);
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYear = new SavingsAccountYear(10000, 10);
        assertEquals("After one year", thisYear.interestRate(), thisYear.nextYear().interestRate(), 0.0000);
    }

}