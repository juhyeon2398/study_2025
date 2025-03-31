package org.joonzis.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}
	
//	@Test
//	public void testGetList() {
//		System.out.println("===================================================================================");
//		System.out.println("===================================================================================");
//		log.info(service.getList());
//	}
//	@Test
//	public void testGet() {
//		System.out.println("===================================================================================");
//		System.out.println("===================================================================================");
//		log.info("get..." + service.get(7));
//	}
//	
//	@Test 
//	public void testRegister() {
//		System.out.println("===================================================================================");
//		System.out.println("===================================================================================");
//		BoardVO vo = new BoardVO(); 
//		vo.setTitle("insertTest3");
//		vo.setContent("insertTest3"); 
//		vo.setWriter("insertTest3");
//		service.register(vo);
//		log.info("register...");
//	}
//	
//	@Test 
//	public void testRemove() {
//		System.out.println("===================================================================================");
//		System.out.println("===================================================================================");
//		log.info("remove... " + service.remove(8));
//	}
//	
	@Test 
	public void testModify() {
		System.out.println("===================================================================================");
		System.out.println("===================================================================================");
		BoardVO vo = new BoardVO(); 
		vo.setTitle("updateTest3");
		vo.setContent("updateTest3"); 
		vo.setWriter("updateTest3");
		vo.setBno(9);
		log.info("modify... " + service.modify(vo));
	}
	 
}
