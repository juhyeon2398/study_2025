package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.CDao;
import org.joonzis.dao.CDaoImpl;
import org.joonzis.vo.CVO;

public class CServiceImpl implements CService{
	
	private CDao cdao = CDaoImpl.getInstance();
	
	
	@Override
	public int insertComment(CVO cvo) {
		
		return cdao.insertComment(cvo);
	}
	
	
	@Override
	public List<CVO> getCommentList(int b_idx) {
		return cdao.getCommentList(b_idx);
	}
	@Override
	public int commentDelete(int c_idx) {
		return cdao.commentDelete(c_idx);
	}
	@Override
	public int commentAllDelete(int b_idx) {
		return cdao.commentAllDelete(b_idx);
	}
	
}
