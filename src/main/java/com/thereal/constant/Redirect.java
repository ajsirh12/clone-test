package com.thereal.constant;

public enum Redirect {
	ADMIN_MAIN("redirect:/admin/main"),
	ADMIN_LOGIN("redirect:/admin/login");
	
	private final String value;
	
	private Redirect(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
