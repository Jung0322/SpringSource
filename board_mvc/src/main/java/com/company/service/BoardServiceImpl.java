package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.domain.AttachFileDTO;
import com.company.domain.BoardDTO;
import com.company.domain.Criteria;
import com.company.domain.ReplyDTO;
import com.company.mapper.BoardAttachMapper;
import com.company.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper boardAttachMapper;

	@Transactional
	@Override
	public boolean insert(BoardDTO dto) {
		
		//게시물 등록
		boolean result = mapper.insert(dto)>0?true:false;
		
		//첨부파일 등록
		if(dto.getAttachList() == null || dto.getAttachList().size()<=0) {
			return false;
		}
		dto.getAttachList().forEach(attach->{
			attach.setBno(dto.getBno());
			boardAttachMapper.insert(attach);
		});
		
		return true;
	}

	@Override
	public List<BoardDTO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.listAll(cri);
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

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.totalCnt(cri);
	}

	@Override
	public boolean insert(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.insert(dto)>0?true:false;
	}

	@Override
	public List<AttachFileDTO> findByBno(int bno) {
		// TODO Auto-generated method stub
		return boardAttachMapper.read(bno);
	}
	
	
}
