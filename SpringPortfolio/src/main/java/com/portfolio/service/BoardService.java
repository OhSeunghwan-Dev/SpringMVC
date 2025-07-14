package com.portfolio.service;

import java.util.List;

import com.portfolio.domain.BoardVO;

public interface BoardService {

public void register(BoardVO board);	// 게시판 등록용 메서드
	
	public BoardVO get(Long bno);		// 게시글 번호를 통한 게시물을 조회한다.
	
	public boolean modify(BoardVO board);	// 게시글 수정 후 true/false 반환
	
	public boolean remove(Long bno);	// 게시글 번호를 통한 게시물 삭제 후 true/false 반환
	
	public List<BoardVO> getList();		// BoardVO 객체들을 List에 담아 불러온다.
}
