package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.BookDTO;
import com.company.service.BookService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/book/*")
public class BookController {
	
	@Autowired
	private BookService service;

	@GetMapping("/insert")
	public void insertGet() {
		log.info("insert 요청");
	
	}
	
	//새 도서 입력
	@PostMapping("/insert")
	//@ResponseBody// 일반 controller에서 return을 jsp가 아닌 값으로 return 
	public ResponseEntity<String> insertPost(@RequestBody BookDTO bookDTO) {
		log.info("insert 요청");
		try {
			if (service.insert(bookDTO)) {
				return new ResponseEntity<String>("success",HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list 요청");
		List<BookDTO> list = service.list();
		model.addAttribute("list", list);
	}
	
	
	@GetMapping({"/read","/modify"})
	public void read(String code, Model model) {
		log.info("read 요청" + code);
		BookDTO dto = service.getRow(code);
		model.addAttribute("dto", dto);
		
		
	}
	
	//book/remove
	@GetMapping("/remove")
	public String removePost(String code) {
		log.info("삭제 요청 " + code);
		service.delete(code);
		return "redirect:/book/list";
	
	}
	
	@PostMapping("/update")
	public String modify(BookDTO bookDto,RedirectAttributes rttr) {
		log.info("수정 요청");
		rttr.addAttribute("code", bookDto.getCode());
		try {
			service.update(bookDto); 
		} catch (Exception e) {
			return "redirect:/book/update";
		}
		return "redirect:/book/read";
		
	}
	
}
