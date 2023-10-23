package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	// get방식의 insert 요청 받아서 처리
	@GetMapping("insert")
	public String insert() {
		// templates/board/insert.html로 forward
		return "board/insert";
	}
	
	// post방식의 insert 요청 받아서 처리
	@PostMapping("insert")
	public String insert(Board board, RedirectAttributes ra) {
		
		int result = service.insert(board);
		
		String path = null;
		String message = null;
		
		// insert 성공 시
		if(result > 0) {
			path = "redirect:/";
			message = "글 쓰기 성공";
		} else { // 실패 시
			path = "redirect:insert";
			message = "글 쓰기 실패";
		}
		// 리다이렉트 시 잠시동안 session scope에 담아둘 속성 설정
		ra.addFlashAttribute("message", message);
		// path에 담긴 주소로 forward
		return path;
	}

	// main.html에서 no=*{boardNo}라는 데이터를 보냈다
	@GetMapping("selectOne")
	public String selectOne(@RequestParam("no") int boardNo,
			Model model) {
		
		// sql 수행후 결과를 board에 담음
		Board board = service.selectOne(boardNo);
		
		// 조회한 정보를 model 객체에 담아 forward할 때 보냄
		model.addAttribute("board", board);
		
		// path에 담긴 주소로 forward
		return "board/selectOne";
	}
	
	@PostMapping("deleteBoard")
	public String deleteBoard(Board board, RedirectAttributes ra) {
		
		int result = service.deleteBoard(board);
		
		String path;
		String message;
		
		if(result > 0) {
			path = "redirect:/";
			message = "삭제 성공";
		} else {
			path = "redirect:selectOne?no=" + board.getBoardNo();
			message = "비밀번호가 일치하지 않습니다";
		}
		ra.addFlashAttribute("message", message);
		return path;
	}
	
	@PostMapping("moveUpdate")
	public String moveUpdate(String boardPw, int boardNo, 
			RedirectAttributes ra, Model model) {
		Board board = service.moveUpdate(boardNo, boardPw);
		String path;
		
		if(board != null) {
			model.addAttribute("board", board);
			path = "board/update";
		} else {
			// 원래 있던 곳으로 보내기 위한 리다이렉트 구문
			path = "redirect:selectOne?no=" + boardNo;
			ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다");
		}
		return path;
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board board, RedirectAttributes ra) {
		
		int result = service.updateBoard(board);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "수정 성공");
			return "redirect:/";
		}
		ra.addFlashAttribute("message", "비밀번호를 입력해주세요");
		return "redirect:selectOne?no=" + board.getBoardNo();
	}
}
