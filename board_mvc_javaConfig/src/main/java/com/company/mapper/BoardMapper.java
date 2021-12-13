package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.BoardDTO;
import com.company.domain.Criteria;
import com.company.domain.ReplyDTO;

public interface BoardMapper {
	public int insert(BoardDTO dto);
	public List<BoardDTO> listAll(Criteria cri);
	public BoardDTO getRow(String bno);
	public int update(BoardDTO dto);
	public int delete(int bno);
	public int totalCnt(Criteria cri);
	public int insert(ReplyDTO dto);
	public int updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
