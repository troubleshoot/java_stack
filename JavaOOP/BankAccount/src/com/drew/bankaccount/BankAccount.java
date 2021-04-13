package com.drew.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	public double checkingsBalance;
	public double savingsBalance;
	private static int numberOfAccounts;
	private static double totalAccountBalances;
	
	public BankAccount() {
		accountNumber = generateAccountNumber();
		numberOfAccounts += 1;
		
	}
	private String generateAccountNumber() {
		Random rand = new Random();
        for (int i = 0; i < 10; i++) {
        	String s = String.valueOf(rand.nextInt(9) + 0);
        	accountNumber += s;
        }
        return accountNumber.substring(4);
	}
	public void depositMoney(double amountParam, char accountParam) {
		if (accountParam == 's' || accountParam == 'S') {
			savingsBalance += amountParam;
			totalAccountBalances += amountParam;
		}
		else if (accountParam == 'c' || accountParam == 'C') {
			checkingsBalance += amountParam;
			totalAccountBalances += amountParam;
		}	
		else 
			System.out.println("Invalid input -- S for Savings.. C for Checkings");
	}
	public void withdrawMoney(double amountParam, double accountParam) {
		if(accountParam >= amountParam) {
			accountParam -= amountParam;
			totalAccountBalances -= amountParam;
		}
		else
			System.out.println("Insufficient funds.");
	}
	public void totalBalance() {
		System.out.println("Checkings Balance: $" + checkingsBalance + " | Savings Balance: $" + savingsBalance + " | Total Balance: $" + (savingsBalance + checkingsBalance));
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getCheckingsBalance() {
		return checkingsBalance;
	}
	public void setCheckingsBalance(double checkingBalance) {
		this.checkingsBalance = checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	public static void setNumberOfAccounts(int numberOfAccounts) {
		BankAccount.numberOfAccounts = numberOfAccounts;
	}
	public static double getTotalAccountBalances() {
		return totalAccountBalances;
	}
	public static void setTotalAccountBalances(double totalAccountBalances) {
		BankAccount.totalAccountBalances = totalAccountBalances;
	}
}
