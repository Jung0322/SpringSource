package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member/*")
@Log4j2
public class MemberController {
	
	@Autowired
	private MemberService service;

	//로그인
	@GetMapping("/signin")
	public void signin() {
		log.info("/로그인 페이지 요청");
		//member/signin
	}
	
	// loginPost()
	@PostMapping("/signin")
	public String loginPost(LoginDTO loginDTO,HttpSession session) {
		log.info("/로그인 확인 : " + loginDTO.getUserid() +", "+loginDTO.getUserid());
		LoginDTO dto =	service.login(loginDTO);
		session.setAttribute("loginDto", dto);
		return "redirect:/";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("/로그아웃 요청");
		session.invalidate();
		return "redirect:/";
	}
	
	//비밀번호 변경
	@GetMapping("/changePwd")
	public void changePwd() {
		log.info("비밀번호 변경 요청");
	}
	
	// changePwd + 폼에서 넘어오는 값 가져오기 
	@PostMapping("/changePwd")
	public String changePwdPost(ChangeDTO changeDto,HttpSession session) {
		log.info("비밀번호 변경 요청" + changeDto);
		LoginDTO loginDTO = (LoginDTO) session.getAttribute("loginDto");
		changeDto.setUserid(loginDTO.getUserid());
		
		if(service.changePwd(changeDto)) {
			session.invalidate();
			return	"redirect:/member/signin";
		}else {
			return "redirect:/member/changePwd";
		}
	}
	//회원탈퇴 폼 보여주기
	@GetMapping("/leave")
	public void leaveGet() {
		log.info("/회원탈퇴GET 요청");
	}
	
	// userid,password
	@PostMapping("/leave")
	public String leavePost(LoginDTO dto,HttpSession session) {
		log.info("/회원탈퇴Post 요청");
		
		if(service.leave(dto)) {
			//세션해제
			session.invalidate();
			return "redirect:/";
		}else{
			return "redirect:/member/leave"; // 탈퇴 실패시
		}
	}
}
