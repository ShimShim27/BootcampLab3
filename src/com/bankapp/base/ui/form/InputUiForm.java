package com.bankapp.base.ui.form;

import com.bankapp.base.ui.input.TextInputSource;
import com.bankapp.config.UiConfig;

public abstract class InputUiForm extends UiForm {
	private TextInputSource textInputSource;
	public InputUiForm(UiConfig uiConfig) {
		super(uiConfig);
		this.textInputSource = uiConfig.getTextInputSource();
		

	}

	abstract protected void handleUserInput(String input);
	
	public String getInputText() {
		return this.getTextInputSource().getText();
	}
	
	
	private TextInputSource getTextInputSource() {
		return this.textInputSource;
	}

}
