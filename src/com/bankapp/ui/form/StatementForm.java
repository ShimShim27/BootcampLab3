package com.bankapp.ui.form;

import com.bankapp.base.ui.form.UiForm;
import com.bankapp.config.UiConfig;
import com.bankapp.entity.BankStatement;
import com.bankapp.service.StatementFetchService;

public class StatementForm extends UiForm {
	public static String ID = "StatementForm";
	private StatementFetchService statementFetchService;

	public StatementForm(UiConfig uiConfig, StatementFetchService statementFetchService) {
		super(uiConfig);
		this.statementFetchService = statementFetchService;

	}

	@Override
	public void display() {
		try {
			this.renderText("Statement:");

			BankStatement bankStatement = this.statementFetchService.getBankStatement();
			this.renderText(bankStatement);
			this.renderText(String.format("Total Balance: %s", bankStatement.getTotalStringBalance()));

		} catch (Exception e) {
			e.printStackTrace();
			this.renderText(e.getMessage());
		}

	}

}