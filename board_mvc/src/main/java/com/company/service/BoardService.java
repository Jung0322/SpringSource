package com.company.service;

import java.util.List;

import com.company.domain.BoardDTO;
import com.company.domain.Criteria;

public interface BoardService {
	public boolean insert(BoardDTO dto);
	public List<BoardDTO> getList(Criteria cri);
	public BoardDTO getRow(String bno);
	public boolean update(BoardDTO dto);
	public boolean delete(int bno);
	public int getTotalCount();
}
