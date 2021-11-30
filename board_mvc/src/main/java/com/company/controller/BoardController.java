package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.BoardDTO;
import com.company.service.BoardService;

import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;

	@GetMapping("/register")
	public void registerGet() {
		log.info("register 요청");
	}
	
	@PostMapping("/register")
	public String registerPost(BoardDTO boardDto,RedirectAttributes rttr) {
		log.info("register 요청" +boardDto);
		service.insert(boardDto);
		
		//log.info("bno" + boardDto.getBno());
		
		rttr.addFlashAttribute("result", boardDto.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
	log.info("전체 리스트 요청");
	
	List<BoardDTO> list  = service.getList();
	model.addAttribute("list", list);
	}
	
	@GetMapping({"/read","/modify"})
	public void read(String bno, Model model) {
		log.info("read 요청 or modify 요청" + bno);
		BoardDTO row = service.getRow(bno);
		model.addAttribute("row", row);
	}
	
	@PostMapping("/modify")
	public String modifyPost(BoardDTO boardDto) {
		log.info("수정 요청");
		service.update(boardDto);
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(int bno) {
		log.info("삭제 요청");
		service.delete(bno);
		return "redirect:/board/list";
	}
}
