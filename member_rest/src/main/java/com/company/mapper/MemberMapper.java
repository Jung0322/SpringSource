package com.company.mapper;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.domain.MemberDTO;

public interface MemberMapper {
	public int insert(MemberDTO dto);
	public MemberDTO selectById(String userid);
	public LoginDTO login(LoginDTO dto);
	public int changePwd(ChangeDTO dto);
	public int leave(LoginDTO dto);
}
