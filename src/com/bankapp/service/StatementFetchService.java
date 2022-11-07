package com.bankapp.service;

import com.bankapp.entity.BankStatement;
import com.bankapp.repository.base.StatementRepository;

public class StatementFetchService {
	private final StatementRepository statementRepository;

	public StatementFetchService(StatementRepository statementRepository) {
		this.statementRepository = statementRepository;
	}

	private StatementRepository getStatementRepository() {
		return this.statementRepository;
	}

	public BankStatement getBankStatement() throws Exception {
		return this.getStatementRepository().getStatement();
	}

	
}
