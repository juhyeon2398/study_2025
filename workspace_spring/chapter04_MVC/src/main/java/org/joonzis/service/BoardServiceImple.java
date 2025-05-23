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
	@Transactional
	public boolean remove(int bno) {
		log.info("getList... " + bno);
		
		if(attachMapper.findByBno(bno).size() > 0) {
			attachMapper.deleteAll(bno);
		}
		if(mapper.replyAll(bno) > 0) {
			mapper.replyAllDelete();
		}
		return mapper.delete(bno) == 1;
	}
	
	@Override
	@Transactional
	public boolean modify(BoardVO vo) {
		int currentBno = vo.getBno();
		if(vo.getUuidList() != null && vo.getUuidList().size() > 0) {
			attachMapper.findByBno(vo.getBno()).forEach(attach -> {
				if(vo.getUuidList().indexOf(attach.getUuid()) == -1) {
					attachMapper.delete(attach.getUuid());
				}
			});
		}else {
			attachMapper.deleteAll(vo.getBno());
		}
		
		if(vo.getNewAttachList() != null && vo.getNewAttachList().size() > 0) {
			vo.getNewAttachList().forEach(attach -> {
				attach.setBno(currentBno);
				attachMapper.insert(attach);
			});
		}
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
