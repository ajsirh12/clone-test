package com.thereal.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateVO {
	private String sub_id;
	private String template_code;
	private String channel_name;
	private String phone;
	private String msg;
	private String comment;
}
