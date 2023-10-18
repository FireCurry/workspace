package edu.kh.project.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AdminMapper;
import edu.kh.project.member.model.dto.Member;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper mapper;
	
	@Override
	public Member selectMember(String inputEmail) {
		return mapper.selectMember(inputEmail);
	}
	@Override
	public Member[] selectAllMember() {
		return mapper.selectAllMember();
	}
}
