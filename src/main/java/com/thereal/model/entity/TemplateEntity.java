package com.thereal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateEntity {
	private String template_code;
	private int channel_seq;
	private String msg;
	private String type;
	private String phone;
	private String comment;
}
