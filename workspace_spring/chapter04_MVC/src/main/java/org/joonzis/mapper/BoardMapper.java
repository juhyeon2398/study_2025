package org.joonzis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;

public interface BoardMapper {
	// 전체 리스트
	public List<BoardVO> getAllList();
	// 데이터 삽입
	public int register(BoardVO vo);
	// 게시글 상세페이지
	public BoardVO getBoard(int bno);
	// 게시글 삭제
	public int delete(int bno);
	// 게시글 수정
	public int update(BoardVO vo);
	// 게시글 전체 수
	public int listAll();
	
	// 댓글 데이터 변경
	public int updateReplyCnt(
			@Param("bno") int bno,
			@Param("amount") int amount);
	
	public int getBno();
	
	public int replyAll(int bno);
	public int replyAllDelete();
	
}
