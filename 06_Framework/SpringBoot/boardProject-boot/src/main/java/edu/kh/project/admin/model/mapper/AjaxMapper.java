package edu.kh.project.admin.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AjaxMapper {

	/** 회원 번호로 이메일 조회
	 * @param memberNo
	 * @return email
	 */
	String selectMemberNo(int memberNo);

	/** 이메일로 전화번호 조회
	 * @param inputEmail
	 * @return memberTel
	 */
	String selectEmail(String inputEmail);

}
