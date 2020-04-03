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
        assertEquals("", 11000, newAccount().endingBalance(), 0.0000);
    }

    @Test
    public void nextYearsStartingBalanceEqualsThisYearsEndingBalance() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals("", thisYear.endingBalance(), thisYear.nextYear().startingBalance(), 0.0000);
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals("", thisYear.interestRate(), thisYear.nextYear().interestRate(), 0.0000);
    }

    @Test
    public void withdrawingFundsAtTheBeginingOfTheYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdraw(1000);
        assertEquals("", 9900, year.endingBalance(), 0.0000);
    }

    @Test
    public void multipleWithdrawalsInAYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdraw(1000);
        year.withdraw(2000);
        assertEquals("", 7700, year.endingBalance(), 0.0000);
    }

    @Test
    public void startingPrinciple() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals("", 3000, year.startingPrinciple(), 0.0000);
    }

    @Test
    public void endingPrinciple() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals("starting principal", 3000, year.startingPrinciple(), 0.0000);
        year.withdraw(2000);
        assertEquals("ending principal", 1000, year.endingPrinciple(), 0.0000);
    }

    @Test
    public void endingPrincipleNeverGoesBelowZero() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals("starting principal", 3000, year.startingPrinciple(), 0.0000);
        year.withdraw(4000);
        assertEquals("ending principal", 0, year.endingPrinciple(), 0.0000);
    }

//    @Test
//    public void withdrawingMoreThanPrincipalIncursCapitalGainsTax() {
//        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
//        year.withdraw(3000);
//        assertEquals("", 7700, year.endingBalance(), 0.0000);
//        year.withdraw(5000);
//        assertEquals("", 2000 + 200 - (5000 * .25), year.endingBalance(), 0.0000);
//    }

    private SavingsAccountYear newAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        return account;
    }

}