package com.company.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Red;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;import com.company.domain.AttachFileDTO;
import com.company.domain.BoardDTO;
import com.company.domain.Criteria;
import com.company.domain.PageDTO;
import com.company.service.BoardService;

import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;

	//isAuthenticated() : 인증된 사용자의 경우 true
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public void registerGet() {
		log.info("register 요청");
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String registerPost(BoardDTO boardDto,RedirectAttributes rttr) {
		log.info("register 요청" +boardDto);
		
		//첨부파일 확인하기
//		if(boardDto.getAttachList()!=null) {
//			boardDto.getAttachList().forEach(attach->log.info(attach+" "));
//		}
		
		service.insert(boardDto);
		
		//log.info("bno" + boardDto.getBno());
		
		rttr.addFlashAttribute("result", boardDto.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Model model,Criteria cri) {
	log.info("전체 리스트 요청" + cri);
	
	List<BoardDTO> list  = service.getList(cri);
	
	
	//페이지 나누기를 위한 정보 얻기
	int totalCnt =  service.getTotalCount(cri);
	
	model.addAttribute("pageDto", new PageDTO(cri, totalCnt));
	model.addAttribute("list", list);
	}
	
	//get,post mapping명이 같으면 매개변수로 들어오는값을 동일하게 사용가능
	@GetMapping({"/read","/modify"})
	public void read(String bno,@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("read 요청 or modify 요청" + bno);
		BoardDTO row = service.getRow(bno);
		model.addAttribute("row", row);
		
		//void forward방식으로 이동하면 객체를 이용하면 다음페이지에서도 사용가능
	}
	
	@PostMapping("/modify")
	public String modifyPost(BoardDTO boardDto,Criteria cri,RedirectAttributes rttr) {
		log.info("수정 요청" +boardDto+" "+cri);
		
		//기존 첨부파일 삭제
		
		
		
		service.update(boardDto);
		
		//rttr은 객체를 보낼수 없음
		//페이지 나누기 값 보내기(주소줄에 보임)
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		//검색값
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		rttr.addFlashAttribute("result","success");
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(int bno,Criteria cri,RedirectAttributes rttr) {
		log.info("삭제 요청");
		
		//첨부파일 목록 얻어오기
	 	List<AttachFileDTO> attachList = service.findByBno(bno);
	 	
	 	//삭제
	 	if(service.delete(bno)) {
	 		//첨부 파일 삭제
	 		deleteFiles(attachList);
	 		
	 		//주소줄에 따라가지않음
	 		rttr.addFlashAttribute("result","success");
	 		//rttr은 객체를 보낼수 없음
	 		//페이지 나누기 값 보내기(주소줄에 보임)
	 		rttr.addAttribute("pageNum", cri.getPageNum());
	 		rttr.addAttribute("amount", cri.getAmount());
	 		
	 		//검색값
	 		rttr.addAttribute("type", cri.getType());
	 		rttr.addAttribute("keyword",cri.getKeyword());		
	 	}
	 	
		return "redirect:/board/list";
	}
	
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileDTO>> getAttachList(int bno){
		log.info("파일 첨부 가져오기"+bno);
		return new ResponseEntity<List<AttachFileDTO>>(service.findByBno(bno),HttpStatus.OK);
	}
	
	
	public void deleteFiles(List<AttachFileDTO> attachListDto) {
	      if(attachListDto == null || attachListDto.size()==0) {
	         return;
	      }
	      log.info("파일 삭제중....");
	      
	      attachListDto.forEach(attach -> {
	         Path file = Paths.get("e:\\upload\\"+attach.getUploadPath()+"\\"+attach.getUuid()+"_"+attach.getFileName());
	      
	         try {
	        	//일반파일, 이미지 원본 파일만 삭제
	            Files.deleteIfExists(file);
	            
	            if(Files.probeContentType(file).startsWith("image")) {
	               Path thumbnail = Paths.get("e:\\upload\\"+attach.getUploadPath()+"\\s_"+attach.getUuid()+"_"+attach.getFileName());
	               
	               //이미지 썸네일 삭제
	               Files.delete(thumbnail);
	            }
         
	         
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      });
	   }
}
