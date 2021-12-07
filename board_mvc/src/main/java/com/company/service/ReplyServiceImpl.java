package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.Criteria;
import com.company.domain.ReplyDTO;
import com.company.domain.ReplyPageDTO;
import com.company.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public boolean insertReply(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return replyMapper.insert(dto)>0?true:false;
	}

	@Override
	public ReplyDTO get(int rno) {
		// TODO Auto-generated method stub
		return replyMapper.get(rno);
	}

	@Override
	public boolean delete(int rno) {
		// TODO Auto-generated method stub
		return replyMapper.delete(rno)>0?true:false;
	}

	@Override
	public boolean update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return replyMapper.update(dto)>0?true:false;
	}

	@Override
	public ReplyPageDTO getList(Criteria cri,int bno) {
		// TODO Auto-generated method stub
		return new ReplyPageDTO(replyMapper.getCountByBno(bno),  replyMapper.list(cri, bno));
	}

}
