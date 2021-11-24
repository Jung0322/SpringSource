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

		// ������ �����̳� �ε�
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		// ���� �޼ҵ� ȣ��
		MemberService service = (MemberService) ctx.getBean("service");

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("==========================================");
			System.out.println("1.��ü ��� ��ȸ");
			System.out.println("2.Ư�� ��� ��ȸ");
			System.out.println("3.Ư�� ��� ����");
			System.out.println("4.Ư�� ��� ����");
			System.out.println("5.Ư�� ��� �߰�");
			System.out.println("6.���α׷� ����");
			System.out.println("==========================================");

			System.out.println("�޴� >> ");
			int no = Integer.parseInt(sc.next());

			switch (no) {
			case 1:
				System.out.println();
				List<MemberDTO> list = service.getList();
				System.out.println("���̵�\t����\t����\t�̸���");
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
				
				System.out.print("���̵� �Է��ϼ���.");
				String userid = sc.next();
				System.out.print("��й�ȣ�� �Է��ϼ���.");
				String password = sc.next();
				MemberDTO dto = service.getRow(userid, password);
				System.out.println("���̵�\t����\t����\t�̸���");
				System.out.println("==========================================");
				System.out.print(dto.getUserid()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getGender()+"\t");
				System.out.print(dto.getEmail()+"\n");
				break;
			case 3:
				System.out.println();
				ChangeDTO changeDTO = new ChangeDTO();
				System.out.print("���̵� �Է��ϼ���.");
				changeDTO.setUserid(sc.next());
				System.out.print("��й�ȣ�� �Է��ϼ���.");
				changeDTO.setPassword(sc.next());
				System.out.print("���ο� ��й�ȣ�� �Է��ϼ���.");
				changeDTO.setConfirm_password(sc.next());
				System.out.println(service.updateMember(changeDTO)?"��������":"��������");
				break;
			case 4:
				System.out.println();
				System.out.print("���̵� �Է��ϼ���.");
				String deleteUserid = sc.next();
				System.out.print("��й�ȣ�� �Է��ϼ���.");
				String deletePassword = sc.next();
				System.out.println(service.deleteMember(deleteUserid, deletePassword)?"��������":"��������");
				break;
			case 5:
				System.out.println();
				MemberDTO insertDto = new MemberDTO();
				System.out.print("���̵� �Է��ϼ���.");
				insertDto.setUserid(sc.next());
				System.out.print("��й�ȣ�� �Է��ϼ���.");
				insertDto.setPassword(sc.next());
				System.out.print("�̸��� �Է��ϼ���.");
				insertDto.setName(sc.next());
				System.out.print("������ �Է��ϼ���.");
				insertDto.setGender(sc.next());
				System.out.print("e-mail�� �Է��ϼ���.");
				insertDto.setEmail(sc.next());
				System.out.println(service.insertMember(insertDto)?"���Լ���":"���Խ���");
				break;
			case 6:
				flag = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;

		
			}
		}
	}

}
