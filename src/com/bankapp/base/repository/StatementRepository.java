package com.bankapp.base.repository;

import com.bankapp.entity.BankStatement;
import com.bankapp.entity.BankTransaction;

public interface StatementRepository {
	public BankStatement getStatement() throws Exception;

	public void addTransaction(BankTransaction bankTransaction) throws Exception;
}
