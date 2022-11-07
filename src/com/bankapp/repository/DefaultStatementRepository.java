package com.bankapp.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.base.repository.StatementRepository;
import com.bankapp.entity.BankStatement;
import com.bankapp.entity.BankTransaction;

public class DefaultStatementRepository implements StatementRepository {
	private final String fileSourcePath;

	public DefaultStatementRepository(String fileSourcePath) {
		this.fileSourcePath = fileSourcePath;

	}

	@Override
	public BankStatement getStatement() throws IOException {
		FileReader fileReader = new FileReader(getFileSourcePath());
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<BankTransaction> bankTransactions = new ArrayList<>();

		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.isEmpty())
				break;

			String trimmedLine = line.trim();
			BankTransaction bankTransaction = new BankTransaction(Double.parseDouble(trimmedLine));
			bankTransactions.add(bankTransaction);
		}

		bufferedReader.close();

		return new BankStatement(bankTransactions);
	}

	@Override
	public void addTransaction(BankTransaction bankTransaction) throws IOException {
		boolean willAppendChanges = true;
		FileWriter fileWriter = new FileWriter(getFileSourcePath(), willAppendChanges);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		String stringAmount = String.valueOf(bankTransaction.getAmount());
		bufferedWriter.write(String.format("%s\n", stringAmount));
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private String getFileSourcePath() {
		return this.fileSourcePath;
	}
}
