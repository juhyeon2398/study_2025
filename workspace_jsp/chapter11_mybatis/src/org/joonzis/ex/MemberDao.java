package org.joonzis.ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.joonzis.mybatis.DBService;

public class MemberDao {
	// 필드
	private SqlSessionFactory factory = null;

	// 싱글톤
	// 기본 생성자(외부에서 접근할 수 없게 private 처리)
	private MemberDao() {
		factory = DBService.getFactory();
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	// 테이블 전체 목록을 가져오는 메소드 - getAllList
	public List<MemberVO> getAllList() {
		SqlSession session = factory.openSession();
		List<MemberVO> list = session.selectList("sellect_all");
		session.close();
		
		return list;
	}

	// 데이터 삽입 메소드 - insert
	public int insert(MemberVO vo) {
		SqlSession session = factory.openSession(false);
		int result = session.insert("insert",vo);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	// 데이터 삭제 메소드 - remove
	public int remove(MemberVO vo) {
		SqlSession session = factory.openSession(false);
		int result = session.delete("delete",vo);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}

	// 	
	public MemberVO getUserInfoById(MemberVO vo) {
		SqlSession session = factory.openSession();
		MemberVO selectOne = session.selectOne("sellect_one",vo);
		session.close();
		
		return selectOne;
	}
	
	// 수정 데이터 가져오기 - getUpdateView
	public MemberVO getUpdateView(MemberVO vo) {
		SqlSession session = factory.openSession();
		MemberVO selectOne = session.selectOne("update_data",vo);
		session.close();
		
		return selectOne;
	}
	
	
	public int update(MemberVO vo) {
		SqlSession session = factory.openSession(false);
		int result = session.update("update",vo);
		if(result > 0) {
			session.commit();
		}
		session.close();
		
		return result;
	}
}
