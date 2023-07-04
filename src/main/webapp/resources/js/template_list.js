/**
 * template 페이지 list 생성
 */


function setPhoneList(datas){
	const phoneList = document.getElementById("phoneList");
	removeAllChild(phoneList);
	
	for(var idx=0; idx<datas.length; idx++){
		const row = document.createElement("div");
		const phone = document.createElement("div");
		const comment = document.createElement("div");
		
		row.setAttribute("class", "row");
		phone.setAttribute("class", "col-3");
		phone.innerHTML = datas[idx].phone;
		row.appendChild(phone);
		
		comment.setAttribute("class", "col");
		comment.innerHTML = datas[idx].comment;
		row.appendChild(comment);
		
		phoneList.appendChild(row);
	}
};
	
function setChannelList(datas){
	const channelList = document.getElementById("channelList");
	removeAllChild(channelList);
	
	for(var idx=0; idx<datas.length; idx++){
		const row = document.createElement("div");
		const name = document.createElement("div");
		const key = document.createElement("div");
		
		row.setAttribute("class", "row");
		name.setAttribute("class", "col-3");
		name.innerHTML = datas[idx].channel_name;
		row.appendChild(name);
		
		key.setAttribute("class", "col");
		key.innerHTML = datas[idx].sender_key;
		row.appendChild(key);
		
		channelList.appendChild(row);
	}
};

function setTemplateList(datas){
	const templateList = document.getElementById("templateList");
	removeAllChild(templateList);
	
	for(var idx=0; idx<datas.length; idx++){
		const row = document.createElement("div");
		row.setAttribute("class", "row");
		
		const sub_id = document.createElement("div");
		const template_code = document.createElement("div");
		const channel = document.createElement("div");
		const phone = document.createElement("div");
		const msg = document.createElement("div");
		
		sub_id.setAttribute("class", "col-1");
		sub_id.innerHTML = datas[idx].sub_id;
		row.appendChild(sub_id);
		
		template_code.setAttribute("class", "col-2");
		template_code.innerHTML = datas[idx].template_code;
		row.appendChild(template_code);
		
		channel.setAttribute("class", "col-2");
		channel.innerHTML = datas[idx].channel;
		row.appendChild(channel);
		
		phone.setAttribute("class", "col-2");
		phone.innerHTML = datas[idx].phone;
		row.appendChild(phone);
		
		msg.setAttribute("class", "col");
		const pre = document.createElement("pre");
		pre.innerHTML = datas[idx].msg;
		msg.appendChild(pre);
		//msg.innerHTML = datas[idx].msg;
		row.appendChild(msg);
		
		templateList.appendChild(row);
	}
};
	
function selectPhone(datas){
	const selectBox = document.getElementById("phone-select");
	removeAllChild(selectBox);
	
	const init = document.createElement("option");
	init.setAttribute("selected", "selected");
	init.setAttribute("hidden", "hidden");
	init.innerHTML = "발송자 선택";
	selectBox.appendChild(init);
		
	for(var idx=0; idx<datas.length; idx++){
		const option = document.createElement("option");
		option.setAttribute("value", datas[idx].phone);
		option.innerHTML = datas[idx].phone;
		
		selectBox.appendChild(option);
	}
};

function selectChannel(datas){
	const selectBox = document.getElementById("channel-select");
	removeAllChild(selectBox);
	
	const init = document.createElement("option");
	init.setAttribute("selected", "selected");
	init.setAttribute("hidden", "hidden");
	init.innerHTML = "채널 선택";
	selectBox.appendChild(init);
	
	for(var idx=0; idx<datas.length; idx++){
		const option = document.createElement("option");
		option.setAttribute("value", datas[idx].seq);
		option.innerHTML = datas[idx].channel_name;
		
		selectBox.appendChild(option);
	}
};

function removeAllChild(parents){
	while(parents.hasChildNodes()){
		parents.removeChild(parents.firstChild);
	}
};