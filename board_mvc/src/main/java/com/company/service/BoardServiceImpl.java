package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BoardDTO;
import com.company.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public boolean insert(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.insert(dto)>0?true:false;
	}

	@Override
	public List<BoardDTO> getList() {
		// TODO Auto-generated method stub
		return mapper.listAll();
	}

	@Override
	public BoardDTO getRow(String bno) {
		// TODO Auto-generated method stub
		return mapper.getRow(bno);
	}

	@Override
	public boolean update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto)>0?true:false;
	}

	@Override
	public boolean delete(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno)>0?true:false;
	}
	
	
}
