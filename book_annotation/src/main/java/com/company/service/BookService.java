package com.company.service;

import java.util.List;

import com.company.domain.BookDTO;

public interface BookService {
	//��ü ���� ���
	public List<BookDTO> getList();
	
	//���ο� ���� �Է�
	public boolean insertBook(BookDTO dto);
	// ����
	public boolean detele(String code);
	//����
	public boolean update(String code, int price);
}
