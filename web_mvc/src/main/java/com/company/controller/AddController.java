package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.domain.AddDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/calc/*")
public class AddController {

	@GetMapping("/add")
	public void addGet() {
		log.info("/calc/add 요청");
	}
	
	/*@PostMapping("/add")
	public void addPost(String num1,String num2, Model model) {
		log.info("/calc/add Post 요청");
		log.info("num1: "+num1);
		log.info("num2: "+num2);
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		
	}*/
	
	@PostMapping("/add")
	public void addPost(AddDTO addDTO,Model model) {
		log.info("/calc/add Post 요청"+addDTO.getNum1()+", "+addDTO.getNum2());
		
		//덧셈한 후 결과를 add.jsp 보여주기
		int result = +addDTO.getNum1()+addDTO.getNum2();
		
		model.addAttribute("result", result);
		
		
		
		//   calc/add
		
	}
}
