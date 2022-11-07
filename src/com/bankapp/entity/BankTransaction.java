package com.bankapp.entity;

public class BankTransaction {
	private double amount;
	private String currencySymbol = "₱";

	public BankTransaction(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getCurrencySmbol() {
		return this.currencySymbol;
	}

	@Override
	public String toString() {
		return String.format("%s%s", this.getCurrencySmbol(), Math.abs(this.getAmount()));
	}
}
