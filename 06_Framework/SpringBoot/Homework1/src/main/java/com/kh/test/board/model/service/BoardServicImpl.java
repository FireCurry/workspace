package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

@Transactional
@Service
public class BoardServicImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public List<Board> selectBoardList() {
		return mapper.selectBoardList();
	}
	
	@Override
	public int insert(Board board) {
		// 비밀번호를 암호화 해서 다시 넣기
		board.setBoardPw(bcrypt.encode(board.getBoardPw()));
		return mapper.insert(board);
	}
	
	@Override
	public Board selectOne(int boardNo) {
		return mapper.selectOne(boardNo);
	}
	
	@Override
	public int deleteBoard(Board board) {
		int boardNo = board.getBoardNo();
		String encPw = mapper.selectPw(boardNo);
		
		// 비밀번호가 일치하는지 확인
		if(!bcrypt.matches(board.getBoardPw(), encPw)) {
			return 0;
		}
		
		return mapper.deleteBoard(boardNo);
	}
	
	@Override
	public Board moveUpdate(int boardNo, String boardPw) {
		String encPw = mapper.selectPw(boardNo);
		
		// 비밀번호가 일치하는지 확인
		if(!bcrypt.matches(boardPw, encPw)) {
			return null;
		}
		return mapper.selectOne(boardNo);
	}
	
	@Override
	public int updateBoard(Board board) {
		if(board.getBoardPw() != "") {
			board.setBoardPw(bcrypt.encode(board.getBoardPw()));
			return mapper.updateBoard(board);
		}
		return 0;
	}
}
