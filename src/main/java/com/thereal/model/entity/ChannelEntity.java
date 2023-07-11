package com.thereal.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelEntity {
	private int seq;
	private String channel_name;
	private String sender_key;
}
