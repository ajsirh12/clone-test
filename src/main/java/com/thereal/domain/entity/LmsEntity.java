package com.thereal.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
