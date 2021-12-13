package com.company.controller;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */

@Log4j2
@Controller
public class HomeController {
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/doA")
	public String doA(RedirectAttributes rttr) {
		log.info("doA요청");
		
		//RedirectAttributes : sendredirect 움직일 때 값을 전달하는 객체
		//addFlashAttribute: session 객체를 이용하나, 잠시만 사용
		//addAttribute: 주소줄에 파라메타로 보내짐
		
		// RedirectAttributes : sendRedirct 움직일 때 값을 전달하는 객체
		rttr.addFlashAttribute("name", "홍길동"); //움직이는 페이지 한번만 사용 가능
		rttr.addAttribute("age", 20);// http://localhost:8080/doB?age=20
		//rttr.addFlashAttribute("age", 20);
		
		return "redirect:/doB";
	}
	
	@GetMapping("/doB")
	public void doB() {
		log.info("/doB 요청");;

	}
	
	@GetMapping("/doC")
	public void doC() {
		log.info("/doC 요청");;

	}
}
