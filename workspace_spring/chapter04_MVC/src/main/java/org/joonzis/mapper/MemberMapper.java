package org.joonzis.mapper;


import org.joonzis.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userId);
	
	public int insert(MemberVO vo);
	
	public MemberVO findId(String userid);
}
