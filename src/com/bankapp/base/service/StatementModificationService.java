package com.bankapp.base.service;

import com.bankapp.base.repository.StatementRepository;
import com.bankapp.entity.BankTransaction;

public abstract class StatementModificationService {
	private final StatementRepository statementRepository;

	public StatementModificationService(StatementRepository statementRepository) {
		this.statementRepository = statementRepository;
	}

	protected abstract void checkTransactionAmountValid(double amount) throws Exception;

	protected void addTransactionAmount(double amount, boolean isDeduction) throws Exception {
		this.checkTransactionAmountValid(amount);
		
		
		if(isDeduction) {
			amount*=-1;
		}
		
		BankTransaction bankTransaction = new BankTransaction(amount);
		this.getStatementRepository().addTransaction(bankTransaction);
	}

	private StatementRepository getStatementRepository() {
		return this.statementRepository;
	}

}
