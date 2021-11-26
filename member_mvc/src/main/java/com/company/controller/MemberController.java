package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.MemberDTO;
import com.company.service.MemberService;
import com.company.service.MemberServiceImpl;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/register/*")
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/step1")
	public void registGet() {
		log.info("/step1 요청");
	}

	@PostMapping("/step2")
	public String step2(boolean agree, RedirectAttributes rttr) {
		log.info("/step2 요청");
		log.info(agree);
		if (!agree) {	//step1 보여주기
			rttr.addFlashAttribute("check", "false");
			return "redirect:/register/step1"; 	
		}
		return "/register/step2";

	}
	
	//중복 아이디 검사
	@ResponseBody // 리턴하는 값이 데이터임(jsp 페이지 안찾음)
	@PostMapping("/checkId")
	public String IdCheck(String userid) {
		log.info("중복아이디 검사" + userid);
		
		if(service.dupId(userid)!=null) {
			return "false";
		}
		return "true";
	}
	
	
	
	@GetMapping("/signin")
	public void signin() {
		log.info("/signin 요청");
	}
	
	@PostMapping("/step3")
	public String step3(MemberDTO memberDTO) {
		log.info("/step3 요청 " +memberDTO);
		
		try {
			if(!service.register(memberDTO)) {
				//회원가입 페이지로 이동
				return "/register/step2";
			}
		} catch (Exception e) {
			return "/register/step2";
		}
		// http://localhost:8080/register/step3
		// return "/register/signin" => jsp
		return "redirect:/register/signin";
	}
	
	// http://localhost:8080/register/step3 + GET
	// http://localhost:8080/register/step2 + GET
	// 405 - 허용되지 않는 메소드
	
	@GetMapping(value= {"/step2","/step3"})
	public String handleGet() {
		log.info("/step2,/step3 직접요청");
		return "redirect:/";
	}
	
	
	
	
}
