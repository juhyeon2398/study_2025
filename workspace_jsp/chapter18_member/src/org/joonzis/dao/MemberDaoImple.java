package org.joonzis.dao;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.MemberVO;

public class MemberDaoImple implements MemberDao {
	// DAO 객체 생성    
	private static MemberDaoImple instance = null;
	private MemberDaoImple() {}
	public static MemberDaoImple getInstance() {
		if(instance == null) {
			instance = new MemberDaoImple();
		}
		return instance;
	}

	// 필드
	private static SqlSession sqlsession = null;
	private synchronized static SqlSession getSqlSession() {
		if(sqlsession == null) {
			sqlsession = DBService.getFactory()
					.openSession(false);
		}
		return sqlsession;
	}
	
	// ID 중복 검사
	@Override
	public int validateId(String mId) {
		return getSqlSession().selectOne("select_validateId", mId );
	}

	// 로그인 ID/PW 비교
	@Override
	public MemberVO selectMember(MemberVO mvo) {
		return getSqlSession().selectOne("select_member", mvo );
	}
	
	// 회원 추가
	@Override
	public int insertMember(MemberVO mvo) {
		int result = getSqlSession().insert("insert_member", mvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
}
