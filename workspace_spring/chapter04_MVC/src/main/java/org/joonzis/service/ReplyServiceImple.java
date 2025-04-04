package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.mapper.BoardMapper;
import org.joonzis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImple implements ReplyService {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	// 전체 댓글
	@Override
	public List<ReplyVO> getList(int bno) {
		log.info("getList... " + bno);
		return mapper.getList(bno);
	}
	
	// 댓글 조회
	@Override
	public ReplyVO get(int rno) {
		log.info("get... " + rno);
		return mapper.read(rno);
	}
	
	// 댓글 추가
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		log.info("register... " + vo);
		int result = boardMapper.updateReplyCnt(
				vo.getBno(), 
				mapper.insert(vo));
		return result;
	}
	
	// 댓글 삭제
	@Transactional
	@Override
	public int remove(int rno) {
		log.info("remove... " + rno);
		int result = 
				boardMapper.updateReplyCnt(
						mapper.read(rno).getBno(), 
						(0 - mapper.delete(rno)));
		return result;
	}
	
	// 댓글 수정
	@Override
	public int modify(ReplyVO vo) {
		log.info("modify... " + vo);
		return mapper.update(vo);
	}
}
