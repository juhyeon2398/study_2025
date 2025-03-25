package org.joonzis.service;

import java.util.List;

import org.joonzis.vo.CVO;

public interface CService {
	public int insertComment(CVO cvo);
	public List<CVO> getCommentList(int b_idx);
	public int commentDelete(int c_idx);
	public int commentAllDelete(int b_idx);
}
