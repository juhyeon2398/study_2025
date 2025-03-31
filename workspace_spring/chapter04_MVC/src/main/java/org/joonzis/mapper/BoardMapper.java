package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardVO;

public interface BoardMapper {
	// 전체 리스트
	public List<BoardVO> getList();
	// 데이터 삽입
	public int insert(BoardVO vo);
	// 게시글 상세페이지
	public BoardVO read(int bno);
	// 게시글 삭제
	public int delete(int bno);
	// 게시글 수정
	public int update(BoardVO vo);
}
