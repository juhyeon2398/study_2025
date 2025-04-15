package org.joonzis.service;

import org.joonzis.domain.MemberVO;
import org.joonzis.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImple implements MemberService {
	
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int insert(MemberVO vo) {
		log.info("service join insert");
		return mapper.insert(vo);
	}
	
	@Override
	public MemberVO findId(String userid) {
		return mapper.findId(userid);
	}
}
