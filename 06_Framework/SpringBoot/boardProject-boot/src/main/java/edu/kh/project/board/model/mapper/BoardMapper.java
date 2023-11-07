package edu.kh.project.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param rowBounds
	 * @return boardList
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);

	/** 전체 게시글 수 조회
	 * @param boardCode
	 * @return listCount
	 */
	int getListCount(int boardCode);

	/** 게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board boardDetail(Map<String, Object> map);

	/** 게시글 좋아요 여부 확인
	 * @param map
	 * @return likeCheck
	 */
	int likeCheck(Map<String, Object> map);

	/** 좋아요 삭제
	 * @param paramMap
	 * @return
	 */
	int deleteBoardLike(Map<String, Object> paramMap);

	/** 좋아요 삽입
	 * @param paramMap
	 * @return
	 */
	int insertBoardLike(Map<String, Object> paramMap);
	
	/** 좋아요 수 조회
	 * @param boardNo
	 * @return count
	 */
	int countBoardLike(Integer boardNo);

	/** 조회수 증가
	 * @param boardNo
	 * @return result
	 */
	int updateReadCount(int boardNo);

	/** 검색어 일치 게시글 수 조회
	 * @param paramMap
	 * @return listCount
	 */
	int searchListCount(Map<String, Object> paramMap);

	/** 검색어 일치 게시글 목록 조회
	 * @param paramMap
	 * @param rowBounds
	 * @return boardList
	 */
	List<Board> searchBoardList(Map<String, Object> paramMap, RowBounds rowBounds);

}
