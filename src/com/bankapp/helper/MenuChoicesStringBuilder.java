package com.bankapp.helper;

import java.util.HashMap;
import java.util.Map;

public class MenuChoicesStringBuilder {
	private final Map<String, String> menuChoicesMap;

	public MenuChoicesStringBuilder() {
		menuChoicesMap = new HashMap<>();
	}

	public void addChoice(String inputChoice, String choiceName) {
		menuChoicesMap.put(inputChoice, choiceName);
	}

	public String generateMenuString() {
		String menuString = "";

		for (String key : this.menuChoicesMap.keySet()) {
			menuString = String.format("%s%s --> %s\n", menuString, key, menuChoicesMap.get(key));
		}

		return menuString;
	}

	public void clearChoices() {
		this.menuChoicesMap.clear();
	}
}
