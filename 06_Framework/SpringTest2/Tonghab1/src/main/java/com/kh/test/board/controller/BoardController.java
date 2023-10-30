package com.kh.test.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

	private final BoardService service;
	
	@GetMapping("select")
	public String select(String inputTitle, Model model) {
		List<Board> boardList = service.select(inputTitle);
		String path = null;
		if(boardList.size() == 0) {
			path = "searchFail";
		} else {
			path = "searchSuccess";
			model.addAttribute("boardList", boardList);
		}
		return path;
	}
	
	@GetMapping("select2")
	@ResponseBody
	public List<Board> select2(String inputTitle){
		return service.select(inputTitle);
	}
}
