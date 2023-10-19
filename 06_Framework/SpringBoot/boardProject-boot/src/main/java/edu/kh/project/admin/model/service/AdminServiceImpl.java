package edu.kh.project.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AdminMapper;
import edu.kh.project.member.model.dto.Member;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public Member selectMember(String inputEmail) {
		return mapper.selectMember(inputEmail);
	}
	
	@Override
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
	
	@Override
	public List<Member> selectSort(int sort) {
		
		// sort 값에 따라 가공 처리
		String query = null;
		
		switch(sort) {
		case 1 : query = "MEMBER_NO DESC"; break; // 회원번호 내림차순
		case 2 : query = "MEMBER_NO"; break; // 회원번호 오름차순
		case 3 : query = "MEMBER_EMAIL DESC"; break; // 이메일 내림차순
		case 4 : query = "MEMBER_EMAIL"; break; // 이메일 오름차순
		}
		
		return mapper.selectSort(query);
	}
	
	@Override
	public int restoration(int memberNo) {
		return mapper.restoration(memberNo);
	}

	@Override
	public int changeAuthority(int memberNo) {
		return mapper.changeAuthority(memberNo);
	}
	
	@Override
	public int initPw(int memberNo) {
		
		// 암호화 된 비밀번호 만들기
		String memberPw = bcrypt.encode("123123");
		
		// 마이바티스 코드에서 파라미터는 1개만 가능!!
		Map<String, Object> map = new HashMap<>();
		map.put("memberPw", memberPw);
		map.put("memberNo", memberNo);
		
		return mapper.initPw(map);
	}
}
