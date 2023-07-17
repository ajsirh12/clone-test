package com.thereal.model.vo;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistVO {
	private String senderKey;
	private String channelName;
	private String phone;
	private String templateCode;
	private String msg;
	private String lmsTitle;
	private String comment;
	private List<Map<String, Object>> btnList;
}
