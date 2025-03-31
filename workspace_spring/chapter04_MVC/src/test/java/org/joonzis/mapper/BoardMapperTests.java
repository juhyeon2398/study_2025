package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	/*
	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		for(BoardVO vo : list) {
			log.info(vo);
		}
	}
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(7);
		log.info(vo);
	}
	
	// 데이터 insert	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("insertTest2");
		vo.setContent("insertTest2");
		vo.setWriter("insertTest2");
		int result = mapper.insert(vo);
		log.info(result);
	}
	
	// 데이터 Delete	
	@Test
	public void testDelete() {
		int bno = 6;
		int result = mapper.delete(bno);
		log.info(result);
	}
	
	// 데이터 Update	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setTitle("updateTest");
		vo.setContent("updateTest");
		vo.setWriter("updateTest");
		vo.setBno(7);
		int result = mapper.update(vo);
		log.info(result);
	}
	
	*/
	
}
