package com.thereal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CallbackEntity {
	private String msg_key;
	private String todate;
	private String sub_id;
	private String status;
	private String code;
	private String desc;
	private String failback_id;
	private Object failback_dest;
	private Object failback_code;
	private Object failback_desc;
	private String done_date;
}
