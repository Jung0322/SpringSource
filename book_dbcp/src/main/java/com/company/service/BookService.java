package com.company.service;

import java.util.List;

import com.company.domain.BookDTO;

public interface BookService {
	//전체 도서 목록
	public List<BookDTO> getList();
	
	//새로운 도서 입력
	public boolean insertBook(BookDTO dto);
	// 삭제
	public boolean detele(String code);
	//수정
	public boolean update(String code, int price);
}
