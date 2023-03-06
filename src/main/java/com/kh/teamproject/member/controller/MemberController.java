package com.kh.teamproject.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.teamproject.member.service.MemberService;



@Controller
@RequestMapping("/member")
public class MemberController {	
	@Autowired 
	private MemberService service;
	
	@GetMapping("/signUp")
	public ModelAndView viewInsert(ModelAndView mv) {
		
		mv.setViewName("member/signUp");
		return mv;
		
	}
}
