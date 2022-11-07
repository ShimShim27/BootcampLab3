package com.bankapp.entity;

import java.util.List;

public class BankStatement {
	private final List<BankTransaction> bankTransactions;

	public BankStatement(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public String getCurrencySymbol() {
		String currencySymbol = "";
		List<BankTransaction> bankTransactions = this.getTransactions();
		if (!bankTransactions.isEmpty()) {
			currencySymbol = bankTransactions.get(0).getCurrencySmbol();
		}

		return currencySymbol;
	}

	public double getTotalBalance() throws Exception {

		return this.getTransactions().stream().map((transaction) -> transaction.getAmount())
				.reduce((amount1, amount2) -> amount1 + amount2).orElse(0.0);

	}

	public String getTotalStringBalance() throws Exception {
		return String.format("%s%s", this.getCurrencySymbol(), this.getTotalBalance());
	}

	@Override
	public String toString() {
		String stringValue = "";
		for (BankTransaction bankTransaction : bankTransactions) {
			double amount = bankTransaction.getAmount();
			String signIndicator = "-";

			if (amount > 0) {
				signIndicator = "+";
			}

			stringValue = String.format("%s\n%s%s", stringValue, signIndicator, bankTransaction);
		}

		return stringValue.trim();
	}

	private List<BankTransaction> getTransactions() {
		return bankTransactions;
	}

}
