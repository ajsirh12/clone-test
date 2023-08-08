package com.thereal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempListDTO {
	private String template_code;
	private String channel_name;
	private String comment;
	private int seq;
}
