package com.project.picturact.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface MemberLoginService {
	//	�α��� �� ���̵� üũ
	public ModelAndView loginCheck(String userId, String userPassword, HttpSession session);
	
}
