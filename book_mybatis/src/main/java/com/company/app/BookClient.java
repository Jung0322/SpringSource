package com.company.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.BookDTO;
import com.company.service.BookService;

public class BookClient {

	private static BookService service;

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		// ���� ȣ��
		// BookService service = new BookService()
		service = (BookService) ctx.getBean("bookServiceImpl");
		menu();

	}

	public static void menu() {

		boolean flag = true;
		while (flag) {
			System.out.println("----------------------------------");
			System.out.println("1.���� ���� ��ȸ");
			System.out.println("2.���� ���� �߰�");
			System.out.println("3.���� ���� ����");
			System.out.println("4.���� ��� ��ü��ȸ;");
			System.out.println("5.���� ���� ����");
			System.out.println("6.����");
			System.out.println("----------------------------------");

			Scanner sc = new Scanner(System.in);
			System.out.print("�޴����� >>");
			int no = Integer.parseInt(sc.next());
			System.out.println();

			switch (no) {
			case 1:
				System.out.println("��ȸ�� ���� �ڵ� �Է�>>");
				String code = sc.next();
				BookDTO dto = service.getRow(code);
				
				System.out.print(dto.getCode() + "\t");
				System.out.print(dto.getTitle() + "\t");
				System.out.print(dto.getWriter() + "\t");
				System.out.print(dto.getPrice() + "\n");
				break;
			case 2:
				// ���ο� ���� �Է�
				BookDTO insertDto = new BookDTO();
				System.out.print("�ڵ带 �Է��ϼ���");
				insertDto.setCode(sc.next());
				System.out.print("������ �Է��ϼ���");
				insertDto.setTitle(sc.next());
				System.out.print("�۰��� �Է��ϼ���");
				insertDto.setWriter(sc.next());
				System.out.print("������ �Է��ϼ���");
				insertDto.setPrice(Integer.parseInt( sc.next()));
				System.out.println(service.insertBook(insertDto) ? "�Է¼���" : "�Է½���");
				break;
			case 3:
				//delete
				System.out.println("������ ���� �ڵ� �Է�>>");
				String deletecode = sc.next();
				System.out.println(service.detele(deletecode)?"��������":"��������");
				break;
			case 4:
//				��ü ����Ʈ ��� ȣ��
				List<BookDTO> list = service.getList();
				System.out.println("�ڵ�     ����     �۰�     ����");
				for (BookDTO book : list) {
					System.out.print(book.getCode() + "\t");
					System.out.print(book.getTitle() + "\t");
					System.out.print(book.getWriter() + "\t");
					System.out.print(book.getPrice() + "\n");
				}
				break;
			
			case 5:
				 //update
			
				System.out.println("������ ���� �ڵ� �Է�>>");
				String updatecode = sc.next();
		
				System.out.println("������ ���� �Է�>>");
				int updateprice = Integer.parseInt(sc.next());
				System.out.println(service.update(updatecode,updateprice)?"��������":"��������");
			case 6:
				flag = false;
				break;
			}
		}

	}

}
