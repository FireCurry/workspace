package edu.kh.project.admin.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	/** 회원 정보 조회
	 * @param inputEmail
	 * @return
	 */
	Member selectMember(String inputEmail);

	/** 전체 회원 조회
	 * @return memberList
	 */
	List<Member> selectAll();

	/** 전체 회원 조회(+정렬)
	 * @param sort
	 * @return memberList
	 */
	List<Member> selectSort(int sort);

	/** 회원 복구
	 * @param memberNo
	 * @return result
	 */
	int restoration(int memberNo);

	/** 권한 변경
	 * @param memberNo
	 * @return result
	 */
	int changeAuthority(int memberNo);

	/** 비밀번호 초기화
	 * @param memberNo
	 * @return result
	 */
	int initPw(int memberNo);


}
