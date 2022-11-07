package com.bankapp.ui.form;

import com.bankapp.base.ui.form.InputUiForm;
import com.bankapp.config.UiConfig;
import com.bankapp.helper.MenuChoicesStringBuilder;
import com.bankapp.service.DepositService;
import com.bankapp.service.StatementFetchService;

public class DepositForm extends InputUiForm {
	public static String ID = "DepositForm";
	private final DepositService depositService;
	private final StatementFetchService statementFetchService;

	public DepositForm(UiConfig uiConfig, DepositService depositService, StatementFetchService statementFetchService) {
		super(uiConfig);
		this.depositService = depositService;
		this.statementFetchService = statementFetchService;

	}

	@Override
	public void display() {
		MenuChoicesStringBuilder menuChoicesStringBuilder = new MenuChoicesStringBuilder();
		menuChoicesStringBuilder.addChoice("X", "Main Menu");
		this.renderText(menuChoicesStringBuilder.generateMenuString());

		this.renderText("Enter amount to deposit:");
		this.handleUserInput(this.getInputText());
		this.renderText("");
	}

	@Override
	protected void handleUserInput(String input) {

		try {
			double depositAmount = Double.parseDouble(input);
			this.depositService.deposit(depositAmount);

			String accountBalance = statementFetchService.getBankStatement().getTotalStringBalance();
			this.renderText(String.format("Transaction successful ! New account balance: %s", accountBalance));

		} catch (Exception e) {
			if (!input.toLowerCase().matches("x")) {
				this.renderText(String.format("Failed to deposit: %s", e.getMessage()));
			}

		}

	}

}
