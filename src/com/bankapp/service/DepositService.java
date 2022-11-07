package com.bankapp.service;

import com.bankapp.base.repository.StatementRepository;
import com.bankapp.base.service.StatementModificationService;

public class DepositService extends StatementModificationService {
	private static double MIN_WITHDRAW_AMOUNT = 0;

	public DepositService(StatementRepository statementRepository) {
		super(statementRepository);
	}

	@Override
	protected void checkTransactionAmountValid(double amount) throws Exception {
		if (amount <= MIN_WITHDRAW_AMOUNT) {
			throw new IllegalArgumentException(String.format("Deposit amount should be greater than %s", MIN_WITHDRAW_AMOUNT));
		}
	}

	public void deposit(double amount) throws Exception {
		this.addTransactionAmount(amount, false);
	}

}
