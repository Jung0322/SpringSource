package com.company.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.BookDTO;
import com.company.service.BookService;

public class BookClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		//���� ȣ��
		//BookService service = new BookService()
		BookService service = (BookService) ctx.getBean("bookServiceImpl");
		//���ο� ���� �Է�
//		BookDTO insertDto = new BookDTO("1006","������","���۰���",32000);
//		System.out.println(service.insertBook(insertDto)?"�Է¼���":"�Է½���");
		
		// update
		System.out.println(service.update("1002",35000)?"��������":"��������");
		//delete
		System.out.println(service.detele("1006")?"��������":"��������");
		//��ü ����Ʈ ��� ȣ��
		List<BookDTO> list = service.getList();
		
		System.out.println("�ڵ�     ����     �۰�     ����");
		for(BookDTO book:list) {
			System.out.print(book.getCode()+"\t");
			System.out.print(book.getTitle()+"\t");
			System.out.print(book.getWriter()+"\t");
			System.out.print(book.getPrice()+"\n");
		}
		
	}
	

}
