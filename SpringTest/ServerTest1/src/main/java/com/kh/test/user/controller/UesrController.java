package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

@Controller
public class UesrController {

	@Autowired
	private UserService service;
	
	@GetMapping("search")
	public String search(String userId, Model model) {
		String path = null;
		
		User user = service.search(userId);
		
		if(user == null) {
			path = "searchFail";
		} else {
			path = "searchSuccess";
			model.addAttribute("user", user);
		}
		
		
		return path;
	}
	
}
