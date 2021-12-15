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
import com.company.mapper.ReplyMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper boardAttachMapper;
	
	@Autowired
	private ReplyMapper replymapper;

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

	@Transactional
	@Override
	public boolean update(BoardDTO dto) {
		
		//기존 첨부파일 삭제
		boardAttachMapper.deleteAll(dto.getBno());
		
		//글 수정
		boolean modifyResult = mapper.update(dto)==1;
		
		//첨부물이 없다면 돌아가기
		if(dto.getAttachList() == null || dto.getAttachList().size()<=0) {
			return modifyResult;
		}
		
		//첨부파일 추가
		if(modifyResult && dto.getAttachList().size() > 0) {
			dto.getAttachList().forEach(attach ->{
				attach.setBno(dto.getBno());
				boardAttachMapper.insert(attach);
			});
		}
		
		
		return modifyResult;
	}

	@Transactional
	@Override
	public boolean delete(int bno) {
		
		//댓글 삭제
		replymapper.deleteAll(bno);
		
		//첨부물 삭제
		boardAttachMapper.deleteAll(bno);
				
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

	@Override
	public boolean attachRemove(int bno) {
		// TODO Auto-generated method stub
		return boardAttachMapper.deleteAll(bno)>0?true:false;
	}
	
	
}
