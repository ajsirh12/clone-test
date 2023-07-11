package com.thereal.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDTO {
	private String token;
	private String user; 
}
