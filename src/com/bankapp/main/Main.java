package com.bankapp.main;

import com.bankapp.config.UiConfig;
import com.bankapp.ui.form.MainForm;
import com.bankapp.ui.input.ConsoleTextInputSource;
import com.bankapp.ui.renderer.ConsoleTextRenderer;


public class Main {

	public static void main(String[] args) {
	
		UiConfig uiConfig = new UiConfig();
		uiConfig.setTextInputSource(new ConsoleTextInputSource());
		uiConfig.setTextRenderer(new ConsoleTextRenderer());

		MainForm mainForm = new MainForm(uiConfig);
		mainForm.display();
	}

}
