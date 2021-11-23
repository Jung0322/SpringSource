package com.company.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.BoardDTO;
import com.company.service.BoardService;

public class BoardClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BoardService service = (BoardService) ctx.getBean("boardService");

		//삽입
//		BoardDTO insertdto = new BoardDTO();
//		insertdto.setTitle("스트링 프레임워크");
//		insertdto.setContent("스프링 프레임워크 게시판");
//		insertdto.setWriter("홍길동");
//		System.out.println(service.insertBoard(insertdto)?"입력성공":"입력실패");
		
		//개별검색
//		System.out.println("------------------------");
//		System.out.println("개별검색");
//		BoardDTO dto1 = new BoardDTO();
//		dto1 = service.getRow(1);
//		System.out.println("bno\t title\t content\t writer\t regdate\t updatedate");
//		System.out.print(dto1.getBno() + "\t");
//		System.out.print(dto1.getTitle() + "\t");
//		System.out.print(dto1.getContent() + "\t");
//		System.out.print(dto1.getWriter() + "\t");
//		System.out.print(dto1.getRegdate() + "\t");
//		System.out.print(dto1.getUpdatedate() + "\t");
		
		//수정
//	BoardDTO updateDto = new BoardDTO();
//	updateDto.setContent("DI란 무엇인가");
//		System.out.println(service.updateBoard(updateDto)?"수정성공":"수정실패");
		
		//삭제
//		System.out.println(service.deleteBoard(3)?"삭제성공":"삭제실패");
		
		//전체조회
		List<BoardDTO> list = service.getRows();

		System.out.println("------------------------");
		System.out.println("bno\t title\t content\t writer\t regdate\t updatedate");
		for (BoardDTO dto : list) {
			System.out.print(dto.getBno() + "\t");
			System.out.print(dto.getTitle() + "\t");
			System.out.print(dto.getContent() + "\t");
			System.out.print(dto.getWriter() + "\t");
			System.out.print(dto.getRegdate() + "\t");
			System.out.print(dto.getUpdatedate() + "\t");
		}
		

	}

}
