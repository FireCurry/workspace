package com.kh.test.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {
	
	@PostMapping("loginTest")
	public String loginTest(@RequestParam Map<String, Object> map, RedirectAttributes ra) {
	
		if(map.get("id").equals("user01") && map.get("pw").equals("pass01")) {
			ra.addAttribute("message", "성공");
		} else {
			ra.addAttribute("message", "실패");
		}
		return "redirect:/loginResult";
	}
	
	@GetMapping("loginResult")
	public String loginResult() {
		return "loginResult";
	}

}
