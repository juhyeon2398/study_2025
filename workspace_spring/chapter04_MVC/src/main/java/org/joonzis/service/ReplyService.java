package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.ReplyVO;

public interface ReplyService {
	// 댓글 삽입
	public int register(ReplyVO vo);
	// 댓글 목록
	public List<ReplyVO> getList(int bno);
	// 댓글 읽기
	public ReplyVO get(int rno);
	// 댓글 삭제
	public int remove(int rno);
	// 댓글 수정
	public int modify(ReplyVO vo);
}
