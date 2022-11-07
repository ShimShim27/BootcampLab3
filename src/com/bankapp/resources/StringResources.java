package com.bankapp.resources;

import java.util.ResourceBundle;

public class StringResources {
	private static String BUNDLE_NAME =  StringResources.class.getPackage().getName() + ".strings";
	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static String getValue(String key) {
		
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
