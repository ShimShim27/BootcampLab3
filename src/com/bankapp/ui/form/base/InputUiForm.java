package com.bankapp.ui.form.base;

import com.bankapp.ui.config.UiConfig;
import com.bankapp.ui.input.base.TextInputSource;

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
