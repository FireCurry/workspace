package edu.kh.project.email.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {

	int updateAuthKey(Map<String, String> map);

	int insertAuthKey(Map<String, String> map);

	/** 인증 번호 확인
	 * @param paramMap
	 * @return
	 */
	int checkAuthKey(Map<String, Object> paramMap);

}
