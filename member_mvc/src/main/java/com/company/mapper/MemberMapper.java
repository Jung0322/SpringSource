package com.company.mapper;

import com.company.domain.MemberDTO;

public interface MemberMapper {
	public int insert(MemberDTO dto);
	public MemberDTO selectById(String userid);
}
