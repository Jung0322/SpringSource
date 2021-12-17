package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BookDTO;

public interface BookService {
	public List<BookDTO> list();
	public boolean insert(BookDTO dto);
	public BookDTO getRow(String code);
	public boolean delete(String code);
	public boolean update(BookDTO dto);
}
