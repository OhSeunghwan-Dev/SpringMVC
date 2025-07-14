package com.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.domain.BoardVO;
import com.portfolio.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor	
@Log4j2
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;	
	
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
