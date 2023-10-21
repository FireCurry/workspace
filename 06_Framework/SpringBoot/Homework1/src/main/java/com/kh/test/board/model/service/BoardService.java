package com.kh.test.board.model.service;

import java.util.List;

import com.kh.test.board.model.dto.Board;

public interface BoardService {

	
	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	/** 게시글 등록
	 * @param board
	 * @return result
	 */
	int insert(Board board);

	/** 게시글 상세 조회
	 * @param boardNo
	 * @return board
	 */
	Board selectOne(int boardNo);

	/** 게시글 삭제
	 * @param board
	 * @return result
	 */
	int deleteBoard(Board board);

	/** 게시글 수정 페이지로 이동
	 * @param boardNo
	 * @param boardPw
	 * @return board
	 */
	Board moveUpdate(int boardNo, String boardPw);

	/** 게시글 수정
	 * @param board
	 * @return result
	 */
	int updateBoard(Board board);


}
