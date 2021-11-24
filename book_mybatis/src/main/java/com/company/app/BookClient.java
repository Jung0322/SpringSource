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

		// 서비스 호출
		// BookService service = new BookService()
		service = (BookService) ctx.getBean("bookServiceImpl");
		menu();

	}

	public static void menu() {

		boolean flag = true;
		while (flag) {
			System.out.println("----------------------------------");
			System.out.println("1.도서 정보 조회");
			System.out.println("2.도서 정보 추가");
			System.out.println("3.도서 정보 삭제");
			System.out.println("4.도서 목록 전체조회;");
			System.out.println("5.도서 정보 수정");
			System.out.println("6.종료");
			System.out.println("----------------------------------");

			Scanner sc = new Scanner(System.in);
			System.out.print("메뉴선택 >>");
			int no = Integer.parseInt(sc.next());
			System.out.println();

			switch (no) {
			case 1:
				System.out.println("조회할 도서 코드 입력>>");
				String code = sc.next();
				BookDTO dto = service.getRow(code);
				
				System.out.print(dto.getCode() + "\t");
				System.out.print(dto.getTitle() + "\t");
				System.out.print(dto.getWriter() + "\t");
				System.out.print(dto.getPrice() + "\n");
				break;
			case 2:
				// 새로운 도서 입력
				BookDTO insertDto = new BookDTO();
				System.out.print("코드를 입력하세요");
				insertDto.setCode(sc.next());
				System.out.print("제목을 입력하세요");
				insertDto.setTitle(sc.next());
				System.out.print("작가를 입력하세요");
				insertDto.setWriter(sc.next());
				System.out.print("가격을 입력하세요");
				insertDto.setPrice(Integer.parseInt( sc.next()));
				System.out.println(service.insertBook(insertDto) ? "입력성공" : "입력실패");
				break;
			case 3:
				//delete
				System.out.println("삭제할 도서 코드 입력>>");
				String deletecode = sc.next();
				System.out.println(service.detele(deletecode)?"삭제성공":"삭제실패");
				break;
			case 4:
//				전체 리스트 결과 호출
				List<BookDTO> list = service.getList();
				System.out.println("코드     제목     작가     가격");
				for (BookDTO book : list) {
					System.out.print(book.getCode() + "\t");
					System.out.print(book.getTitle() + "\t");
					System.out.print(book.getWriter() + "\t");
					System.out.print(book.getPrice() + "\n");
				}
				break;
			
			case 5:
				 //update
			
				System.out.println("수정할 도서 코드 입력>>");
				String updatecode = sc.next();
		
				System.out.println("수정할 가격 입력>>");
				int updateprice = Integer.parseInt(sc.next());
				System.out.println(service.update(updatecode,updateprice)?"수정성공":"수정실패");
			case 6:
				flag = false;
				break;
			}
		}

	}

}
