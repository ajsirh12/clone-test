package com.thereal.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistSubVO {
	private String templateCode;
	private String subId;
	private String comment;
}
