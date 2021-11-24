package com.company.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.BookDTO;

public interface BookService {
	//Ư�� ���� ��������
	public BookDTO getRow(String code);
	
	//��ü ���� ���
	public List<BookDTO> getList();
	
	//���ο� ���� �Է�
	public boolean insertBook(BookDTO dto);
	// ����
	public boolean detele(String code);
	//����
	public boolean update(String code,int price);
}
