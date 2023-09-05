package edu.kh.jdbc.model.service;

// static 필드/메서드 호출 시 클래스 명(JDBCTemplate) 생략
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.model.dao.ProjectDAO;
import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;

public class ProjectService {

	private ProjectDAO dao = new ProjectDAO();
	
	/** 회원 가입 서비스
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출(Connection, 매개 변수 전달
		int result = dao.insertMember(conn, member);
		
		// 3. 트랜잭션 제어
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 view로 반환		
		return result;
	}

	/** 로그인 서비스
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(String email, String pw) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
//		Member member = dao.login(conn, email, pw); // PreparedStatement
		Member member = dao.login2(conn, email, pw); // Statement
		
		
		// SELECT는 트랜잭션 제어 처리가 필요 없음 -> 건너 뜀
		
		// 3. 커넥션 반환
		close(conn);
		
		// 4. view로 결과 반환
		return member;
	}

	/** MEMBER 테이블 전체 조회 서비스
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(int sort) {
		
		Connection conn = getConnection(); // 커넥션 생성
		
		// DAO 메서드 호출 후 결과 반환 받기
		List<Member> memberList = dao.selectAllMember(conn, sort);
		
		close(conn); // 커넥션 반환
		
		return memberList; // 결과 반환
	}

	/** 회원 정보 수정 서비스
	 * @param nickname
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String nickname, String tel, int memberNo) {
		
		Connection conn = getConnection();
		
//		int result = dao.updateMember(conn, nickname, tel, memberNo);
		int result = dao.updateMember2(conn, nickname, tel, memberNo);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 회원 탈퇴 서비스
	 * @param memberNo
	 * @param pw
	 * @return
	 */
	public int updateDelFl(int memberNo, String pw) {
		
		Connection conn = getConnection();
		
		int result = dao.updateDelFl(conn, memberNo, pw);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 게시글 작성 서비스
	 * @param title
	 * @param content
	 * @param memberNo
	 * @return
	 */
	public int insertBoard(String title, String content, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn, title, content, memberNo);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 게시글 목록 조회
	 * @return
	 */
	public String selectBoardList() {
		Connection conn = getConnection();
		
		String result = dao.selectBoardList(conn);
		
		close(conn);
		
		return result;
	}
	
	/** 게시글 목록 조회(List 사용)
	 * @return
	 */
	public List<Board> selectBoardList2() {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectBoardList2(conn);
		
		return boardList;
	}
	
	/** 게시글 상세 조회
	 * @param boardNo
	 * @return
	 */
	public Board selectBoard(int boardNo) {
		
		Connection conn = getConnection();
		
		// 1) DAO - 게시글 상세 조회 메서드 호출
		Board board = dao.selectBoardList(conn, boardNo);
		
		// 2) 게시글 상세 조회 결과가 있을 경우
		// -> 조회수 증가(incrementReadCount(게시글번호)) 수행
		if (board != null) {
			int result = dao.incrementReadCount(conn, boardNo);
			
			// 트랜잭션 처리
			if (result > 0) {
				commit(conn);
				
				// DB와 데이터 동기화
				// (DB에서만 조회수가 1 증가하기 때문에
				// 조회해둔 board에도 조회수 1을 증가시킨다
				board.setReadCount(board.getReadCount() + 1);
			}
			else rollback(conn);
		}
		
		close(conn);
		
		return board;
	}

	/** 게시글 삭제1
	 * @param boardNo
	 * @param memberNo
	 * @return
	 */
	public int deleteBoard(int boardNo, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo, memberNo);
		close(conn);
		return result;
	}

	/** 게시글 삭제2
	 * @param boardNo
	 * @return
	 */
	public int deleteBoard2(int boardNo) {
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard2(conn, boardNo);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

	/** 게시글 수정1
	 * @param memberNo
	 * @param boardNo
	 * @return
	 */
	public int updateBoard(int memberNo, int boardNo) {
		
		Connection conn = getConnection();
		
		int result = dao.updateBoard(conn, memberNo, boardNo);
		close(conn);
		return result;
	}

	/** 게시글 수정2
	 * @param title
	 * @param content
	 * @param boardNo
	 * @return
	 */
	public int updateBoard2(String title, String content, int boardNo) {
		
		Connection conn = getConnection();
		
		int result = dao.updateBoard2(conn, title, content, boardNo);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

	
}
