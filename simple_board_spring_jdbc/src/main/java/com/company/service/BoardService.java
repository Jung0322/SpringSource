package com.company.service;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardService {
	//���
	public boolean insertBoard(BoardDTO dto);
	//����
	public boolean deleteBoard(int bno);
	//������ȸ
	public BoardDTO getRow(int bno);
	//������ȸ
	public List<BoardDTO> getRows();
	//����
	public boolean updateBoard(BoardDTO dto);
}
