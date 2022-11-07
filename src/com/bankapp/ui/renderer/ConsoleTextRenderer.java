package com.bankapp.ui.renderer;

import com.bankapp.base.ui.renderer.TextRenderer;

public class ConsoleTextRenderer implements TextRenderer{

	@Override
	public void render(Object data) {
		System.out.print(String.format("%s\n", data));
	}
	
}
