package org.joonzis.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;

public interface BoardService {
	// 전체 리스트
	public List<BoardVO> getList(Criteria cri);
	// 데이터삽입
	public void register(BoardVO vo);
	// 단일 데이터
	public BoardVO get(int bno);
	// 게시글 삭제
	public boolean remove(int bno);
	// 게시글 수정
	public boolean modify(BoardVO vo);
	// 게시글 전체 수
	public int listAll();
	
	// 첨부 파일 리스트
	public List<BoardAttachVO> getAttachList(int bno);
	
	// 파일 찾기
	public int fileSearch(String uuid);
	
}
