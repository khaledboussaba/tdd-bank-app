package fr.finance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingsAccountYearTest {

    @Test
    public void startingBalanceMatchesConstructor() {
        assertEquals("", 10000, newAccount().startingBalance(), 0.0000);
    }

    @Test
    public void interestRateMatchesConstructor() {
        assertEquals("", 10, newAccount().interestRate(), 0.0000);
    }

    @Test
    public void endingBalanceAppliesInterestRate() {
        assertEquals("", 11000, newAccount().endingBalance(25), 0.0000);
    }

    @Test
    public void nextYearsStartingBalanceEqualsThisYearsEndingBalance() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals("", thisYear.endingBalance(25), thisYear.nextYear(25).startingBalance(), 0.0000);
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals("", thisYear.interestRate(), thisYear.nextYear(25).interestRate(), 0.0000);
    }

    @Test
    public void withdrawingFundsAtTheBeginingOfTheYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdraw(1000);
        assertEquals("", 9900, year.endingBalance(25), 0.0000);
    }

    @Test
    public void multipleWithdrawalsInAYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdraw(1000);
        year.withdraw(2000);
        assertEquals("", 3000, year.totalWithdrawn(), 0.0000);
    }

    @Test
    public void startingPrinciple() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        assertEquals("", 3000, year.startingPrinciple(), 0.0000);
    }

    @Test
    public void endingPrinciple() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdraw(2000);
        assertEquals("ending principal", 1000, year.endingPrinciple(), 0.0000);
    }

    @Test
    public void endingPrincipleNeverGoesBelowZero() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdraw(4000);
        assertEquals("ending principal", 0, year.endingPrinciple(), 0.0000);
    }

    @Test
    public void capitalGainsWithdrawn() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdraw(1000);
        assertEquals("", 0, year.capitalGainsWithdrawn(), 0.0000);
        year.withdraw(3000);
        assertEquals("", 1000, year.capitalGainsWithdrawn(), 0.0000);
    }

    @Test
    public void capitalGainsTaxIncurred_NeedsToCoverCapitalGainsWithdrawn_And_theAdditionalCapitalGainsWithdrawnToPayCapitalGainsTax() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdraw(5000);
        assertEquals("", 2000, year.capitalGainsWithdrawn(), 0.0000);
        assertEquals("", 666, (int)year.capitalGainsTaxIncurred(25), 0.0);
    }

    @Test
    public void capitalGainsTaxIsIncludedInEndingBalance() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        double amountWithdrawn = 5000;
        year.withdraw(amountWithdrawn);
        double expectedCapitalGainsTax = 666;
        assertEquals("", expectedCapitalGainsTax, (int)year.capitalGainsTaxIncurred(25), 0.0000);
        double expectedStartingBalanceAfterWithrawals = 10000 - expectedCapitalGainsTax - amountWithdrawn;
        assertEquals("", (int)(expectedStartingBalanceAfterWithrawals * 1.10), (int)Math.round(year.endingBalance(25)), 0.0000);
    }

    private SavingsAccountYear newAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        return account;
    }

}