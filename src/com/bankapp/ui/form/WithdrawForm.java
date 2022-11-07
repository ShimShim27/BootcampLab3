package com.bankapp.ui.form;

import com.bankapp.helper.MenuChoicesStringBuilder;
import com.bankapp.service.StatementFetchService;
import com.bankapp.service.WithdrawService;
import com.bankapp.ui.config.UiConfig;
import com.bankapp.ui.form.base.InputUiForm;

public class WithdrawForm extends InputUiForm {
	public static String ID = "WithdrawForm";
	private WithdrawService withdrawService;
	private StatementFetchService statementFetchService;

	public WithdrawForm(UiConfig uiConfig, WithdrawService withdrawService,
			StatementFetchService statementFetchService) {
		super(uiConfig);
		this.withdrawService = withdrawService;
		this.statementFetchService = statementFetchService;

	}

	@Override
	public void display() {
		MenuChoicesStringBuilder menuChoicesStringBuilder = new MenuChoicesStringBuilder();
		menuChoicesStringBuilder.addChoice("X", "Main Menu");
		this.renderText(menuChoicesStringBuilder.generateMenuString());

		try {
			this.renderText(String.format("Available balance for withdraw: %s", this.getCurrentStringBalance()));
		} catch (Exception e) {
		}

		this.renderText("Enter amount to withdraw:");
		this.handleUserInput(this.getInputText());
		this.renderText("");

	}

	@Override
	protected void handleUserInput(String input) {
		try {
			double depositAmount = Double.parseDouble(input);
			this.withdrawService.withdraw(depositAmount);

			this.renderText(
					String.format("Transaction successful ! New account balance: %s", this.getCurrentStringBalance()));

		} catch (Exception e) {
			if (!input.toLowerCase().matches("x")) {
				this.renderText(String.format("Failed to deposit: %s", e.getMessage()));
			}

		}
	}

	private String getCurrentStringBalance() throws Exception {
		return statementFetchService.getBankStatement().getTotalStringBalance();
	}

}
