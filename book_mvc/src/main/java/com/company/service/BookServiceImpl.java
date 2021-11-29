package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BookDTO;
import com.company.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;

	@Override
	public List<BookDTO> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public boolean insert(BookDTO dto) {
		// TODO Auto-generated method stub
		return mapper.insert(dto)>0?true:false;
	}

	@Override
	public BookDTO getRow(String code) {
		// TODO Auto-generated method stub
		return mapper.getRow(code);
	}

}
