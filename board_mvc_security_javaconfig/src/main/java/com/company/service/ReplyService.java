package com.company.service;

import java.util.List;

import com.company.domain.Criteria;
import com.company.domain.ReplyDTO;
import com.company.domain.ReplyPageDTO;

public interface ReplyService {
	public boolean insertReply(ReplyDTO dto);
	public ReplyDTO get(int rno);
	public boolean delete(int rno);
	public boolean update(ReplyDTO dto);
	public ReplyPageDTO getList(Criteria cri, int bno);
}
