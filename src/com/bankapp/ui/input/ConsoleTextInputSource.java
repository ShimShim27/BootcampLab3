package com.bankapp.ui.input;

import java.util.Scanner;

import com.bankapp.ui.input.base.TextInputSource;

public class ConsoleTextInputSource implements TextInputSource {
	private final Scanner sc;

	public ConsoleTextInputSource() {
		sc = new Scanner(System.in);
	}

	@Override
	public String getText() {
		return sc.nextLine();
	}

}
