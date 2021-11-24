package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BookDTO;
import com.company.mapper.BookMapper;


// BookServiceImpl 객체 생성 단, id 명은 bookServiceImpl
@Service // == @Component
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;
	
	@Override
	public List<BookDTO> getList() {
		return mapper.list();
	}

	@Override
	public boolean insertBook(BookDTO dto) {
		
		return mapper.insert(dto)>0?true:false;
	}

	@Override
	public boolean detele(String code) {
		
		return mapper.delete(code)>0?true:false;
	}

	@Override
	public boolean update(String code, int price) {
		// TODO Auto-generated method stub
		return mapper.update(code, price)>0?true:false;
	}

	@Override
	public BookDTO getRow(String code) {
	
		return mapper.read(code);
	}

}
