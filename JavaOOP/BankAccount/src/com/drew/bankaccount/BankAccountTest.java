package com.drew.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount first = new BankAccount();
		System.out.println(first.getAccountNumber());
		first.depositMoney(500, 'C');
		first.totalBalance();
		first.depositMoney(250, 'S');
		first.totalBalance();
		BankAccount second = new BankAccount();
		second.depositMoney(1500, 'S');
		second.withdrawMoney(100, 'C');
		second.withdrawMoney(100, 's');
		System.out.println(first.getTotalAccountBalances());
		System.out.println(first.getNumberOfAccounts());
	}

}
