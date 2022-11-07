package com.bankapp.service.base;

import com.bankapp.entity.BankTransaction;
import com.bankapp.repository.base.StatementRepository;

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
