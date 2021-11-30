package com.company.mapper;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardMapper {
	public int insert(BoardDTO dto);
	public List<BoardDTO> listAll();
	public BoardDTO getRow(String bno);
	public int update(BoardDTO dto);
	public int delete(int bno);
}
