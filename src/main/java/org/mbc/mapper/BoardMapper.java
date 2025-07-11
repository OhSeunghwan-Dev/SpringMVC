package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	
	// 어노테이션으로 간단한 쿼리문 처리는 가능하지만, 복잡한 쿼리문에서는 버그가 발생할 수 있다.
	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getList();
	
	// xml을 이용하여 sql문 처리를 진행한다.
	// xml을 이용하려면 resources 폴더 아래쪽에 org 폴더 아래 mvx 폴더 아래에 mapper 폴더를 만들고
	// 인터페이스와 이름이 같은 xml 파일을 생성한다.
	// 위 방법으로 mybatis를 사용한다.
	
	public List<BoardVO> getList2();
	// xml을 이용한 쿼리 처리용 메퍼 메서드.
	
	// C : insert 데이터를 삽입하는 쿼리문
	// 1. insert 처리 후에 결과를 int형으로 받는 방법
	// 2. pk를 먼저 생성 한 후에 insert가 되는 방법
	public void insert(BoardVO board);	// xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board);	// xml에서 쿼리 작성
	
	public BoardVO read(Long bno);	// xml에서 쿼리 작성
	// 번호가 들어가면 객체로 나온다.
	
	public int delete(Long bno);	// xml에서 쿼리 작성
	// 게시물 번호를 받아 해당 게시물 삭제 후 몇개가 삭제됐는지를 반환
	
	public int update(BoardVO board);	// xml에서 쿼리 작성
	// 번호가 들어가면 필드 수정 후 몇 개가 수정됐는지 반환한다.
}
