package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
		
	/*
	// 게시글 댓글 조회
	@Test
	public void testGetList() {
		List<ReplyVO> list = mapper.getList(656);
		log.info("getList ****** : ");
	}
	
	// 댓글 정보 조회
	@Test
	public void testRead() {
		ReplyVO vo = mapper.read(7);
		log.info(vo);
	}
	// 데이터 insert	
	@Test
	public void testInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setReply("insertTest2");
		vo.setReplyer("insertTest2");
		vo.setBno(656);
		int result = mapper.insert(vo);
		log.info(result);
	}
	
	
	// 데이터 Delete	
	@Test
	public void testDelete() {
		int result = mapper.delete(1);
		log.info(result);
	}
	
	// 데이터 Update	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(2);
		vo.setReply("updateTest");
		int result = mapper.update(vo);
		log.info(result);
	}
	
	*/
	
}
