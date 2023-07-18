package com.thereal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LmsEntity {
	private int seq;
	private String template_code;
	private String failback_type;
	private String failback_title;
	private String failback_msg;
	private String failback_id;
}
