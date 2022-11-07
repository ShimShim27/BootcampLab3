package com.bankapp.service;

import com.bankapp.repository.base.StatementRepository;
import com.bankapp.service.base.StatementModificationService;

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
