package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {
	// 인터페이스는 단독으로 생성할 수 없는 객체이므로 구현체가 필요하다.
	// 인터페이스 : 추상 메서드로만 구성된 추상 클래스의 변형체
	// 인터페이스를 구현할 구현 클래스가 반드시 필요하다.
	
	public void register(BoardVO boadr);	// 게시판 등록용 메서드
	
	public BoardVO get(Long bno);		// 게시글 번호를 통한 게시물을 조회한다.
	
	public boolean modify(BoardVO board);	// 게시글 수정 후 true/false 반환
	
	public boolean remove(Long bno);	// 게시글 번호를 통한 게시물 삭제 후 true/false 반환
	
	public List<BoardVO> getList();		// BoardVO 객체들을 List에 담아 불러온다.
}
