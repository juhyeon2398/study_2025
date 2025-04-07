package org.joonzis.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList...");
		return mapper.getList(cri);
	}
	
	@Override
	public BoardVO get(int bno) {
		log.info("get..." + bno);
		return mapper.read(bno);
	}
	
	@Override
	@Transactional
	public void register(BoardVO vo) {
		log.info("register... " + vo);
		
		// 1. tbl_board 테이블에 게시글 등록
		mapper.insert(vo);
		
		// 2. 위에서 등록된 게시글 번호 가져오기
		int currentBno = vo.getBno();
		
		// 3. 첨부파일이 존재하면, 파일 테이블에 데이터 등록
		if(vo.getAttachList() != null && vo.getAttachList().size() > 0) {
			vo.getAttachList().forEach(attach -> {
				attach.setBno(currentBno);
				attachMapper.insert(attach);
			});
		}
	}
	
	@Override
	public boolean remove(int bno) {
		log.info("getList... " + bno);
		return mapper.delete(bno) == 1;
	}
	
	@Override
	public boolean modify(BoardVO vo) {
		log.info("modify.." + vo);
		int result = mapper.update(vo);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int listAll() {
		int result = mapper.listAll();
		return result;
	}

}
