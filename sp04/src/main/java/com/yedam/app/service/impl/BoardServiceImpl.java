package com.yedam.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.service.BoardService;
import com.yedam.app.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;

	@Override
	public List<BoardVO> findAll() {
		return boardMapper.selectAll();
	}

}
