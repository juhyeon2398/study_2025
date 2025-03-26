package org.joonzis.service;

import org.joonzis.dao.MemberDao;
import org.joonzis.dao.MemberDaoImple;
import org.joonzis.vo.MemberVO;

public class MemberServiceImple implements MemberService {
	private MemberDao mdao = MemberDaoImple.getInstance();
	
	@Override
	public int validateId(String mId) {
		return mdao.validateId(mId);
	}
	
	// 로그인 ID/PW 확인
	@Override
	public MemberVO selectMember(MemberVO mvo) {
		return mdao.selectMember(mvo);
	}
	
	@Override
	public int insertMember(MemberVO mvo) {
		return mdao.insertMember(mvo);
	}
}
