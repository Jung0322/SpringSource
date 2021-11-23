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

		//����
//		BoardDTO insertdto = new BoardDTO();
//		insertdto.setTitle("��Ʈ�� �����ӿ�ũ");
//		insertdto.setContent("������ �����ӿ�ũ �Խ���");
//		insertdto.setWriter("ȫ�浿");
//		System.out.println(service.insertBoard(insertdto)?"�Է¼���":"�Է½���");
		
		//�����˻�
//		System.out.println("------------------------");
//		System.out.println("�����˻�");
//		BoardDTO dto1 = new BoardDTO();
//		dto1 = service.getRow(1);
//		System.out.println("bno\t title\t content\t writer\t regdate\t updatedate");
//		System.out.print(dto1.getBno() + "\t");
//		System.out.print(dto1.getTitle() + "\t");
//		System.out.print(dto1.getContent() + "\t");
//		System.out.print(dto1.getWriter() + "\t");
//		System.out.print(dto1.getRegdate() + "\t");
//		System.out.print(dto1.getUpdatedate() + "\t");
		
		//����
//	BoardDTO updateDto = new BoardDTO();
//	updateDto.setContent("DI�� �����ΰ�");
//		System.out.println(service.updateBoard(updateDto)?"��������":"��������");
		
		//����
//		System.out.println(service.deleteBoard(3)?"��������":"��������");
		
		//��ü��ȸ
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
