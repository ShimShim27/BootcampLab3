package com.bankapp.base.ui.form;

import java.util.HashMap;
import java.util.Map;

import com.bankapp.base.ui.renderer.TextRenderer;
import com.bankapp.config.UiConfig;
import com.bankapp.repository.DefaultStatementRepository;
import com.bankapp.resources.StringResources;
import com.bankapp.service.DepositService;
import com.bankapp.service.StatementFetchService;
import com.bankapp.service.WithdrawService;
import com.bankapp.ui.form.BalanceForm;
import com.bankapp.ui.form.DepositForm;
import com.bankapp.ui.form.StatementForm;
import com.bankapp.ui.form.WithdrawForm;
import com.bankapp.ui.input.ConsoleTextInputSource;
import com.bankapp.ui.renderer.ConsoleTextRenderer;

public abstract class UiForm {
	private TextRenderer textRenderer;
	

	public UiForm(UiConfig uiConfig) {
		this.textRenderer = uiConfig.getTextRenderer();
	}

	abstract public void display();

	public void displayFormViaId(String formId) {
		Map<String, UiForm> uiFormsNavigationMap = this.generateUiFormsNavigationMap();
		UiForm nextForm = uiFormsNavigationMap.get(formId);

		if (nextForm != null) {
			this.renderText("");
			nextForm.display();

		}
	}

	public void renderText(Object data) {
		this.getTextRenderer().render(data);
	}

	
	

	private TextRenderer getTextRenderer() {
		return this.textRenderer;
	}

	private Map<String, UiForm> generateUiFormsNavigationMap() {
		UiConfig uiConfig = new UiConfig();
		uiConfig.setTextInputSource(new ConsoleTextInputSource());
		uiConfig.setTextRenderer(new ConsoleTextRenderer());
		
		
		String projectRoothPath = System.getProperty("user.dir");
		String statementDatabaseFileSourcePath = StringResources.getValue("statement_file_path");
		String fileSourcePath = String.format("%s%s", projectRoothPath, statementDatabaseFileSourcePath);

		DefaultStatementRepository statementRepository = new DefaultStatementRepository(fileSourcePath);

		StatementFetchService statementFetchService = new StatementFetchService(statementRepository);
		DepositService depositService = new DepositService(statementRepository);
		WithdrawService withdrawService = new WithdrawService(statementRepository, statementFetchService);

		Map<String, UiForm> formsMap = new HashMap<>();
		formsMap.put(DepositForm.ID, new DepositForm(uiConfig, depositService, statementFetchService));
		formsMap.put(WithdrawForm.ID, new WithdrawForm(uiConfig, withdrawService, statementFetchService));
		formsMap.put(StatementForm.ID, new StatementForm(uiConfig, statementFetchService));
		formsMap.put(BalanceForm.ID, new BalanceForm(uiConfig, statementFetchService));

		return formsMap;
	}

}
