package com.portfolio.mapper;

import java.util.List;

import com.portfolio.domain.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> getList2();
	
	public void insert(BoardVO board);	
	
	public void insertSelectKey(BoardVO board);	
	
	public BoardVO read(Long bno);	
	
	public int delete(Long bno);	
	
	public int update(BoardVO board);

}
