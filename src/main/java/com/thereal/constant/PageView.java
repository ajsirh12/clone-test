package com.thereal.constant;

public enum PageView {
	HOME_MAIN("home/main"),
	HOME_LOGIN("home/login"),
	HOME_TEMPLATE("home/template"),
	HOME_STATISTIC("home/statistic"),
	HOME_REGIST("home/regist/regist"),
	HOME_SUB_REGIST("home/regist/subRegist"),
	HOME_MANAGE_TEMP("home/manage/temp_list"),
	HOME_MANAGE_SUB("home/manage/sub_list");
	
	private final String value;
	
	private PageView(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
