package com.kh.test.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 제목으로 검색
	 * @param inputTitle
	 * @return
	 */
	List<Board> select(String inputTitle);

}
