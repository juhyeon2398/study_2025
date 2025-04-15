package org.joonzis.service;

import org.joonzis.domain.MemberVO;

public interface MemberService {
	public int insert(MemberVO vo);
	public MemberVO findId(String userid);
}
