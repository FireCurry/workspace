package edu.kh.project.member.model.dao;

import edu.kh.project.member.model.dto.Member;

// 인터페이스 사용 이유 : 결합도 약화, 프로젝트 규칙성 부여


public interface MemberDAO {

	Member login(Member inputMember);

}
