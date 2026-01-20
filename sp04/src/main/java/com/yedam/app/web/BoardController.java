package com.yedam.app.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.service.BoardService;
import com.yedam.app.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@GetMapping("boardList")
	public String findAll(Model model) {
		List<BoardVO> findList = boardService.findAll();
		model.addAttribute("boards", findList);
		return "board/List";
	}
}
