package com.company.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.ChangeDTO;
import com.company.domain.MemberDTO;
import com.company.service.MemberService;

public class MemberClient {
	public static void main(String[] args) {

		// 스프링 컨테이너 로드
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		// 서비스 메소드 호출
		MemberService service = (MemberService) ctx.getBean("service");

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("==========================================");
			System.out.println("1.전체 멤버 조회");
			System.out.println("2.특정 멤버 조회");
			System.out.println("3.특정 멤버 수정");
			System.out.println("4.특정 멤버 삭제");
			System.out.println("5.특정 멤버 추가");
			System.out.println("6.프로그램 종료");
			System.out.println("==========================================");

			System.out.println("메뉴 >> ");
			int no = Integer.parseInt(sc.next());

			switch (no) {
			case 1:
				System.out.println();
				List<MemberDTO> list = service.getList();
				System.out.println("아이디\t성명\t성별\t이메일");
				System.out.println("==========================================");
				
				for(MemberDTO dto:list) {
					System.out.print(dto.getUserid()+"\t");
					System.out.print(dto.getName()+"\t");
					System.out.print(dto.getGender()+"\t");
					System.out.print(dto.getEmail()+"\n");
				}
				System.out.println();
				
				break;
			case 2:
				System.out.println();
				
				System.out.print("아이디를 입력하세요.");
				String userid = sc.next();
				System.out.print("비밀번호를 입력하세요.");
				String password = sc.next();
				MemberDTO dto = service.getRow(userid, password);
				System.out.println("아이디\t성명\t성별\t이메일");
				System.out.println("==========================================");
				System.out.print(dto.getUserid()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getGender()+"\t");
				System.out.print(dto.getEmail()+"\n");
				break;
			case 3:
				System.out.println();
				ChangeDTO changeDTO = new ChangeDTO();
				System.out.print("아이디를 입력하세요.");
				changeDTO.setUserid(sc.next());
				System.out.print("비밀번호를 입력하세요.");
				changeDTO.setPassword(sc.next());
				System.out.print("새로운 비밀번호를 입력하세요.");
				changeDTO.setConfirm_password(sc.next());
				System.out.println(service.updateMember(changeDTO)?"수정성공":"수정실패");
				break;
			case 4:
				System.out.println();
				System.out.print("아이디를 입력하세요.");
				String deleteUserid = sc.next();
				System.out.print("비밀번호를 입력하세요.");
				String deletePassword = sc.next();
				System.out.println(service.deleteMember(deleteUserid, deletePassword)?"삭제성공":"삭제실패");
				break;
			case 5:
				System.out.println();
				MemberDTO insertDto = new MemberDTO();
				System.out.print("아이디를 입력하세요.");
				insertDto.setUserid(sc.next());
				System.out.print("비밀번호를 입력하세요.");
				insertDto.setPassword(sc.next());
				System.out.print("이름을 입력하세요.");
				insertDto.setName(sc.next());
				System.out.print("성별을 입력하세요.");
				insertDto.setGender(sc.next());
				System.out.print("e-mail을 입력하세요.");
				insertDto.setEmail(sc.next());
				System.out.println(service.insertMember(insertDto)?"삽입성공":"삽입실패");
				break;
			case 6:
				flag = false;
				System.out.println("프로그램을 종료합니다.");
				break;

		
			}
		}
	}

}
