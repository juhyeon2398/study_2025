package org.joonzis.service;

import java.util.List;

import org.joonzis.model.Criteria;
import org.joonzis.vo.BVO;

public interface BService {
	 public List<BVO> getList();
	 public List<BVO> getListWithPaging(Criteria cri);
	 public int getTotalRecordCount();
	 public int InsertBBS(BVO bvo);
	 public BVO getViewInfo(int b_idx);
	 public int removeBBS(int b_idx);
	 public int updateBBS(BVO bvo);
	 public int updateHit(BVO bvo);
}
