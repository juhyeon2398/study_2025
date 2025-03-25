package org.joonzis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.model.Criteria;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.BVO;

public class BDaoImpl implements BDao{

	// DAO 객체 생성    
	private static BDaoImpl instance = null;
	private BDaoImpl() {}
	public static BDaoImpl getInstance() {
		if(instance == null) {
			instance = new BDaoImpl();
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
	
	@Override
	public List<BVO> getList() {
		return getSqlSession().selectList("select_all");
	}
	
	@Override
	public List<BVO> getListWithPaging(Criteria cri) {
		return getSqlSession().selectList("select_all_paging",cri);
	}

	// 전체 게시글 수
	@Override
	public int getTotalRecordCount() {
		return getSqlSession().selectOne("select_bbs_total");
	}
	
	@Override
	public int InsertBBS(BVO bvo) {
		int result = getSqlSession().insert("insert_bbs", bvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	
	@Override
	public BVO getViewInfo(int b_idx) {
		return getSqlSession().selectOne("select_view",b_idx);
	}
	
	@Override
	public int removeBBS(int b_idx) {
		int result = getSqlSession().delete("remove_bbs",b_idx);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	
	@Override
	public int updateBBS(BVO bvo) {
		int result = getSqlSession().update("update_bbs",bvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public int updateHit(BVO bvo) {
		int result = getSqlSession().update("update_hit",bvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
}
