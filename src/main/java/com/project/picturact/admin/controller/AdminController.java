package com.project.picturact.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.picturact.admin.service.NoticeService;

@Controller
public class AdminController {
	//Notice, E-mail, Q&A ���� ��� CONTROLLER
	//�� ��� ���� �ʿ��� service, dto, dao ���� ���� ���� ���..(���夾����)
	
	@Autowired
	NoticeService noticeService;
	
}
