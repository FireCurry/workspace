package edu.kh.project.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.mapper.AjaxMapper;

@Service
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private AjaxMapper mapper;
	
	@Override
	public String selectMemberNo(int memberNo) {
		return mapper.selectMemberNo(memberNo);
	}
}
