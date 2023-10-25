package edu.kh.project.admin.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.member.model.dto.Member;

public interface AjaxService {

	/** 회원 번호로 이메일 조회
	 * @param memberNo
	 * @return
	 */
	String selectMemberNo(int memberNo);

	/** 이메일로 전화번호 조회
	 * @param inputEmail
	 * @return
	 */
	String selectEmail(String inputEmail);

	/** 회원 번호로 회원 정보 조회
	 * @param no
	 * @return
	 */
	Member selectMember(int no);

	/** 일부 일치하는 이메일 모두 조회
	 * @param keyword
	 * @return
	 */
	List<String> selectEmailList(String keyword);

	/** 모든 회원 정보 조회
	 * @return
	 */
	List<Member> selectAll();

	/** 샘플 계정 삽입
	 * @param member
	 * @return result
	 */
	int insertMember(Member member);

	/** 회원 탈퇴여부 변경
	 * @param paramMap
	 * @return
	 */
	int updateFlag(Map<String, Object> paramMap);

}
