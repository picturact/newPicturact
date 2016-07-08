package com.project.picturact.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.picturact.member.dao.MemberJoinDao;
import com.project.picturact.member.dto.MemberDto;

@Service
public class MemeberJoinServiceImpl implements MemberJoinService {
	@Inject
	MemberJoinDao memberJoinDao;
	MemberDto memberDto;
	ModelAndView mav;
	
	@Override
	public void joinMember(MemberDto memberDto) {
		System.out.println("memberJoinServiceImpl 시작");
		memberJoinDao.joinMember(memberDto);
		System.out.println("memberJoinServiceImpl 완료");
	}

	@Override
	public ModelAndView joinIdCheck(String joinId) {
//		Id find Database
		String result = memberJoinDao.joinIdCheck(joinId);
		System.out.println("result :"+result);
		mav = new ModelAndView();
		
		if(result == null){
			result="OK";
			mav.addObject("result", result);
		}
		mav.setViewName("JSON");
		return mav;
	}

}
