package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service	// 어노테이션을 통해 서비스 계층임을 명시한다.
@AllArgsConstructor	// 생성자 자동 주입		new BoardServiceImpl(BoardMapper mapper) {this.mapper = mapper}	-> 필드마다 @Autowired 어노테이션을 붙이는 것과 같은 효과
@Log4j2				// 로그
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;		// db 쿼리 실행 객체
	
	@Override
	public void register(BoardVO board) {
		// 객체를 받아 mapper를 통해 데이터베이스에 등록한다.
		log.info("BoardServiceImpl.register() 실행...");
		mapper.insertSelectKey(board);
		log.info("정상 등록 후 리스트 출력 테스트...");
		mapper.getList2();
	}

	@Override
	public BoardVO get(Long bno) {
		// 게시물의 번호가 들어가면 메퍼의 select문이 동작해야 한다.
		log.info("BoardServiceImpl.get 메서드 실행...");
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 프론트에서 넘어온 객체를 받아 메퍼를 통해 update 쿼리 실행
		log.info("BoardServiceImpl.modify 메서드 실행...");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("BoardServiceImpl.remove 메서드 실행...");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// getList() 메서드가 호출되면 메퍼에 getList2()를 호출한다,
		
		log.info("BoardServiceImpl.getList 메서드 실행...");
		
		return mapper.getList2();
	}

}
