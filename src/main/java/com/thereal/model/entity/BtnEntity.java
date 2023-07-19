package com.thereal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BtnEntity {
	private int seq;
	private String name;
	private String type;
	private String mobile;
	private String pc;
	private String lms;
}
