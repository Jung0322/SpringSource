package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.ChangeDTO;
import com.company.domain.MemberDTO;
import com.company.mapper.MemberMapper;

@Service("service") //이름을 안 붙이는 경우 MemberServiceImpl
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public List<MemberDTO> getList() {
		
		return mapper.list();
	}


	@Override
	public MemberDTO getRow(String userid, String password) {
		// TODO Auto-generated method stub
		return mapper.read(userid, password);
	}


	@Override
	public boolean updateMember(ChangeDTO chanDto) {
		
		return mapper.update(chanDto)>0?true:false;
	}


	@Override
	public boolean deleteMember(String userid, String password) {
		// TODO Auto-generated method stub
		return mapper.delete(userid, password)>0?true:false;
	}


	@Override
	public boolean insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return mapper.insert(dto)>0?true:false;
	}

}
