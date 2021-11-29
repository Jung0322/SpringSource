package com.company.service;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.domain.MemberDTO;

public interface MemberService {
	public boolean register(MemberDTO dto);
	public MemberDTO dupId(String userid);
	public LoginDTO login(LoginDTO dto);
	public boolean changePwd(ChangeDTO dto);
	public boolean leave(LoginDTO dto);
}
