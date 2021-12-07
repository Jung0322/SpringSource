package com.company.service;

import java.util.List;

import com.company.domain.BoardDTO;
import com.company.domain.Criteria;
import com.company.domain.ReplyDTO;

public interface BoardService {
	public boolean insert(BoardDTO dto);
	public List<BoardDTO> getList(Criteria cri);
	public BoardDTO getRow(String bno);
	public boolean update(BoardDTO dto);
	public boolean delete(int bno);
	public int getTotalCount(Criteria cri);
	public boolean insert(ReplyDTO dto);
}
