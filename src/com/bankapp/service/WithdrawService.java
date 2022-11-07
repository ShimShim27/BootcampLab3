package com.bankapp.service;

import com.bankapp.repository.base.StatementRepository;
import com.bankapp.service.base.StatementModificationService;

public class WithdrawService extends StatementModificationService {
	private static double MAX_WTIHDRAW_AMOUNT = 10_000;
	private static double MIN_WITHDRAW_AMOUNT = 0;
	
	private StatementFetchService statementFetchService;

	public WithdrawService(StatementRepository statementRepository, StatementFetchService statementFetchService) {
		super(statementRepository);
		this.statementFetchService = statementFetchService;

	}

	public void withdraw(double amount) throws Exception {
		this.addTransactionAmount(amount, true);
	}

	@Override
	protected void checkTransactionAmountValid(double amount) throws Exception {
		if (amount <= MIN_WITHDRAW_AMOUNT) {
			throw new IllegalArgumentException("Withdraw amount should be greater than 0");
		}

		if (amount > MAX_WTIHDRAW_AMOUNT) {
			throw new IllegalArgumentException(String.format("Maximum withdraw limit is %s.", MAX_WTIHDRAW_AMOUNT));
		}

		
		if (amount % 1 != 0) {
			throw new IllegalArgumentException("Withdraw amount should not contain any decimals.");
		}
		
		
		if (amount % 100 != 0) {
			throw new IllegalArgumentException("Withdraw amount should be divisible by 100.");
		}

		

		double totalBalance = this.getStatementFetchService().getBankStatement().getTotalBalance();
		if (totalBalance < amount) {
			throw new IllegalArgumentException(
					String.format("Withdraw amount should be less than or equal to %s.", totalBalance));
		}

	}

	private StatementFetchService getStatementFetchService() {
		return statementFetchService;
	}

}
