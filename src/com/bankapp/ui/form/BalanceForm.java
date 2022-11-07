package com.bankapp.ui.form;

import com.bankapp.entity.BankStatement;
import com.bankapp.helper.MenuChoicesStringBuilder;
import com.bankapp.service.StatementFetchService;
import com.bankapp.ui.config.UiConfig;
import com.bankapp.ui.form.base.InputUiForm;

public class BalanceForm extends InputUiForm {
	public static String ID = "BalanceForm";
	private StatementFetchService statementFetchService;

	public BalanceForm(UiConfig uiConfig, StatementFetchService statementFetchService) {
		super(uiConfig);
		this.statementFetchService = statementFetchService;

	}

	@Override
	public void display() {
		try {
			BankStatement bankStatement = this.statementFetchService.getBankStatement();
			this.renderText(String.format("Current Balance: %s", bankStatement.getTotalStringBalance()));

			try {
				MenuChoicesStringBuilder menuChoicesStringBuilder = new MenuChoicesStringBuilder();
				menuChoicesStringBuilder.addChoice("1", "Deposit");
				menuChoicesStringBuilder.addChoice("2", "Withdraw");
				menuChoicesStringBuilder.addChoice("Any Key", "Main Menu");
				this.renderText(menuChoicesStringBuilder.generateMenuString());
				this.renderText("What's your next transaction? ");
				this.handleUserInput(this.getInputText());
			} catch (Exception e) {

			}
		} catch (Exception e) {
			this.renderText(e.getMessage());
		}
	}

	@Override
	protected void handleUserInput(String input) {
		String uiFormId = null;
		switch (input.toLowerCase()) {
		case "1":
			uiFormId = DepositForm.ID;
			break;
		case "2":
			uiFormId = WithdrawForm.ID;
			break;
		}

		if (uiFormId != null) {
			this.displayFormViaId(uiFormId);
		}
	}

}
