package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.mapper.BoardAttachMapper;
import org.joonzis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImple implements BoardService{
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Override
	public List<BoardVO> getAllList() {
		log.info("getList...");
		return mapper.getAllList();
	}
	
	@Override
	public BoardVO getBoard(int bno) {
		log.info("get..." + bno);
		return mapper.getBoard(bno);
	}
	
	@Override
	public int register(BoardVO vo) {
		log.info("register... " + vo);
		return mapper.register(vo);
	}
	
	@Override
	@Transactional
	public boolean delete(int bno) {
		log.info("getList... " + bno);
		return mapper.delete(bno) == 1;
	}
	
	@Override
	@Transactional
	public int update(BoardVO vo) {
		return mapper.update(vo);
	}
	
	@Override
	public int listAll() {
		int result = mapper.listAll();
		return result;
	}
	
	
	// 첨부 파일 리스트
	@Override
	public List<BoardAttachVO> getAttachList(int bno) {
		log.info("getAttachList... " + bno);
		return attachMapper.findByBno(bno);
	}
	
	@Override
	public int fileSearch(String uuid) {
		int result = attachMapper.fileSearch(uuid);
		return result;
	}
}
