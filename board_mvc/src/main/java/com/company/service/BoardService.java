package com.company.service;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardService {
	public boolean insert(BoardDTO dto);
	public List<BoardDTO> getList();
	public BoardDTO getRow(String bno);
	public boolean update(BoardDTO dto);
	public boolean delete(int bno);
}
