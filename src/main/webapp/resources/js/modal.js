/**
 * modal javascript
 */

function nextBtn(value){
	if(value == 'phone'){
		const phone = document.getElementById("phone-num").value;
		let phone_confirm = document.getElementById("phone-confirm");
		
		const comment = document.getElementById("phone-comment").value;
		let comment_confirm = document.getElementById("comment-confirm");
		
		phone_confirm.innerHTML = phone;
		comment_confirm.innerHTML = comment;
	}
	else if(value == 'channel'){
		const name = document.getElementById("channel-name").value;
		let name_confirm = document.getElementById("name-confirm");
		
		const key = document.getElementById("channel-key").value;
		let key_confirm = document.getElementById("key-confirm");
		
		name_confirm.innerHTML = name;
		key_confirm.innerHTML = key;
	}
	else if(value == 'template'){
		const api = document.getElementById("sub-select").value;
		let api_confirm = document.getElementById("api-confirm");
		api_confirm.innerHTML = api;
		
		const template = document.getElementById("template-select").value;
		let template_confirm = document.getElementById("template-confirm");
		template_confirm.innerHTML = template;
		
		const channel = document.getElementById("channel-select").value;
		let channel_confirm = document.getElementById("channel-confirm");
		channel_confirm.innerHTML = channel;
		
		const phone = document.getElementById("phone-select").value;
		let phone_confirm = document.getElementById("num-confirm");
		phone_confirm.innerHTML = phone;
		
		const msg = document.getElementById("msg-select").value;
		let msg_confirm = document.getElementById("msg-confirm");
		msg_confirm.innerHTML = msg;
		
		const comment = document.getElementById("comment-select").value;
		let comm_confirm = document.getElementById("comm-confirm");
		comm_confirm.innerHTML = comment;
	}
}

function clearBtn(value){
	if(value == 'phone'){
		document.getElementById("phone-num").value = "";
		document.getElementById("phone-comment").value = "";
	}
	else if(value == 'channel'){
		document.getElementById("channel-name").value = "";
		document.getElementById("channel-key").value = "";
	}
	else if(value == 'template'){
		document.getElementById("sub-select").value = "";
		document.getElementById("template-select").value = "";
		document.getElementById("channel-select").value = "";
		document.getElementById("phone-select").value = "";
		document.getElementById("msg-select").value = "";
		document.getElementById("comment-select").value = "";
	}
}