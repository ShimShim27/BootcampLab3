package com.bankapp.ui.config;

import com.bankapp.ui.input.base.TextInputSource;
import com.bankapp.ui.renderer.base.TextRenderer;

public class UiConfig {
	private TextRenderer textRenderer;
	
	private TextInputSource textInputSource;
	
	
	public TextInputSource getTextInputSource() {
		return textInputSource;
	}
	public void setTextInputSource(TextInputSource textInputSource) {
		this.textInputSource = textInputSource;
	}
	public TextRenderer getTextRenderer() {
		return textRenderer;
	}
	public void setTextRenderer(TextRenderer textRenderer) {
		this.textRenderer = textRenderer;
	}
}
