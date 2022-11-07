package com.bankapp.config;

import com.bankapp.base.ui.input.TextInputSource;
import com.bankapp.base.ui.renderer.TextRenderer;

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
