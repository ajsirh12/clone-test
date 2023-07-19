package com.thereal.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thereal.dao.RegistDAO;
import com.thereal.model.dto.ButtonDTO;
import com.thereal.model.dto.ChannelKeyDTO;
import com.thereal.model.dto.PhoneDTO;
import com.thereal.model.dto.TemplateDTO;
import com.thereal.model.entity.BtnEntity;
import com.thereal.model.entity.BtnListEntity;
import com.thereal.model.entity.LmsEntity;
import com.thereal.model.entity.TemplateEntity;
import com.thereal.model.vo.ChannelVO;
import com.thereal.model.vo.RegistVO;
import com.thereal.service.RegistService;
import com.thereal.util.ResponseHttp;

@Service("registService")
public class RegistServiceImpl implements RegistService {

	private static final Logger logger = LogManager.getLogger(RegistServiceImpl.class);
	
	@Autowired
	private RegistDAO registDAO;
	@Autowired
	private LoginServiceImpl loginService;
	
	@Override
	public ResponseEntity ajaxRegist(RegistVO vo, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		ChannelVO channelVO = null;
		try {
			channelVO = ChannelVO.builder()
					.channel_name(vo.getChannelName())
					.sender_key(vo.getSenderKey())
					.build();
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return ResponseHttp.failed(resMessage);
		}
		
		int channelSeq;
		try {
			channelSeq = registDAO.selectChannel(channelVO);
			logger.info("Select Channel");
		}
		catch (NullPointerException e) {
			registDAO.insertChannel(channelVO);
			channelSeq = registDAO.selectChannel(channelVO);
			
			logger.info("Insert Channel");
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return ResponseHttp.failed(resMessage);
		}
		
		logger.debug(channelSeq);
		
		try {
			TemplateEntity templateEntity = TemplateEntity.builder()
					.template_code(vo.getTemplateCode())
					.channel_seq(channelSeq)
					.msg(vo.getMsg())
					.phone(vo.getPhone())
					.comment(vo.getComment())
					.build();

			registDAO.insertTemplate(templateEntity);
			logger.info("Insert Template");
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return ResponseHttp.failed(resMessage);
		}
		
		try {
			LmsEntity lmsEntity = LmsEntity.builder()
					.template_code(vo.getTemplateCode())
					.failback_title(vo.getLmsTitle())
					.failback_msg(vo.getMsg())
					.failback_id("realmktAPIfb01")
					.build();
			
			registDAO.insertLMS(lmsEntity);
			logger.info("Insert LMS");
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return ResponseHttp.failed(resMessage);
		}
		
		for(int i=0;i<vo.getBtnList().size();i++) {
			int btnSeq;
			
			BtnEntity btnEntity = null;
			try {
				btnEntity = BtnEntity.builder()
						.name(vo.getBtnList().get(i).get("name").toString())
						.mobile(vo.getBtnList().get(i).get("url").toString())
						.pc(vo.getBtnList().get(i).get("url").toString())
						.lms(vo.getBtnList().get(i).get("url").toString())
						.build();
			}
			catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				return ResponseHttp.failed(resMessage);
			}
			
			try {
				btnSeq = registDAO.selectBtnSeq(btnEntity);
				logger.info("Select Button");
			}
			catch (NullPointerException e) {
				registDAO.insertBtn(btnEntity);
				btnSeq = registDAO.selectBtnSeq(btnEntity);
				logger.info("Insert Button");
			}
			catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				return ResponseHttp.failed(resMessage);
			}
			
			BtnListEntity btnListEntity = null;			
			try {
				btnListEntity = BtnListEntity.builder()
						.template_code(vo.getTemplateCode())
						.btn_seq(btnSeq)
						.btn_order(i+1)
						.build();
			}
			catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				return ResponseHttp.failed(resMessage);
			}
			
			try {
				registDAO.insertBtnList(btnListEntity);
				logger.info("Insert Button-List");
			}
			catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				return ResponseHttp.failed(resMessage);
			}
		}
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity ajaxChannels(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		List<ChannelKeyDTO> channelList = registDAO.ajaxChannels();
		resMessage.put("channelList", channelList);
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity ajaxPhones(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}

		List<PhoneDTO> phoneList = registDAO.ajaxPhones();
		resMessage.put("phoneList", phoneList);
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity ajaxButtons(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}

		List<ButtonDTO> btnList = registDAO.ajaxButtons();
		resMessage.put("btnList", btnList);
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity ajaxTemplates(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}

		List<TemplateDTO> templateList = registDAO.ajaxTemplates();
		resMessage.put("templateList", templateList);
		
		return ResponseHttp.ok(resMessage);
	}
}
