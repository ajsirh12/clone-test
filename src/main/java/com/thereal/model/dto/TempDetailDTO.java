package com.thereal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempDetailDTO {
	private String template_code;
	private String comment;
	private String msg;
	private String phone;
	private String channel_name;
	private String sender_key;
}
