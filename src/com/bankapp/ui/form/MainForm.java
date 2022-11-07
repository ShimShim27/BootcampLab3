package com.bankapp.ui.form;

import com.bankapp.helper.MenuChoicesStringBuilder;
import com.bankapp.ui.config.UiConfig;
import com.bankapp.ui.form.base.InputUiForm;

public class MainForm extends InputUiForm {
	public static String ID = "MainForm";
	private boolean shouldFormExit;

	public MainForm(UiConfig uiConfig) {
		super(uiConfig);

	}

	@Override
	public void display() {
		MenuChoicesStringBuilder menuChoicesStringBuilder = new MenuChoicesStringBuilder();

		while (!this.isShouldFormExit()) {
			this.renderText("Enter any of the options below");

			menuChoicesStringBuilder.addChoice("1", "Deposit");
			menuChoicesStringBuilder.addChoice("2", "Withdrawal");
			menuChoicesStringBuilder.addChoice("3", "Statement");
			menuChoicesStringBuilder.addChoice("4", "Balance");
			menuChoicesStringBuilder.addChoice("5", "Exit");

			this.renderText(menuChoicesStringBuilder.generateMenuString());
			this.renderText("Enter your choice:");
			this.handleUserInput(this.getInputText());

			menuChoicesStringBuilder.clearChoices();
			this.renderText("");
		}

	}

	private boolean isShouldFormExit() {
		return shouldFormExit;
	}

	private void setShouldFormExit() {
		this.shouldFormExit = true;
	}

	@Override
	protected void handleUserInput(String input) {
		String uiFormId = null;
		switch (input) {
		case "1":
			uiFormId = DepositForm.ID;
			break;
		case "2":
			uiFormId = WithdrawForm.ID;
			break;
		case "3":
			uiFormId = StatementForm.ID;
			break;
		case "4":
			uiFormId = BalanceForm.ID;
			break;
		case "5":
			this.setShouldFormExit();
			this.renderText("Application exited.");
			break;
		default:
			this.renderText("Input is not in choice.");
		}

		if (uiFormId != null) {
			this.displayFormViaId(uiFormId);
		}

	}

}
