package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BoardDTO;
import com.company.mapper.BoardMapper;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public boolean insertBoard(BoardDTO dto) {
		
		return mapper.insert(dto)>0?true:false;
	}

	@Override
	public boolean deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno)>0?true:false;
	}

	@Override
	public BoardDTO getRow(int bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public List<BoardDTO> getRows() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public boolean updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto)>0?true:false;
	}

}
