package edu.kh.project.myPage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	/** 회원 정보 수정
	 * @param updateMember
	 * @return result
	 */
	int info(Member updateMember);

	/** 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	String selectMemberPw(int memberNo);

	/** 비밀번호 변경
	 * @param temp
	 * @return result
	 */
	int changePw(Map<String, Object> temp);

	/** 회원 탈퇴
	 * @param memberNo
	 * @return result
	 */
	int secession(int memberNo);

}
