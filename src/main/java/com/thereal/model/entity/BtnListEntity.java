package com.thereal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BtnListEntity {
	private int seq;
	private String template_code;
	private int btn_seq;
	private int btn_order;
}
