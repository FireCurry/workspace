package edu.kh.project.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.admin.model.service.AdminService;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	/** 관리자 메인 페이지
	 * @return "admin/admin-main"
	 */
	@GetMapping("main")
	public String adminMain() {
		// forward : 요청 위임
		// Thymeleaf
		// - prefix : classpath:/templates/
		// - suffix : .html
		return "admin/admin-main";
	}
	
	@GetMapping("selectMember")
	public String selectMember(String inputEmail, Model model) {
		
		Member searchMember = service.selectMember(inputEmail);
		
		if(searchMember == null) {
			// 이메일이 일치하는 회원이 존재하지 않는 경우
			// return "admin/fail"; // forward
			return "admin/fail";
		}
		if(searchMember.getMemberAddress() != null) {
			searchMember.setMemberAddress(searchMember.getMemberAddress().replace("^^^", "<br>"));
		}
		// 이메일이 일치하는 회원이 존재하는 경우
		// return "admin/sucess"; // forward
		model.addAttribute("searchMember", searchMember);
		return "admin/success";
	}
	
	/** 회원 전체 조회
	 * @param model : 데이터 전달
	 * @return
	 */
	@GetMapping("selectAll")
	public String selectAll(Model model) {
		
		// Collection : Java 자료구조 모음
		List<Member> memberList = service.selectAll();
		
		// 조회 결과를 request scope로 전달
		model.addAttribute("memberList", memberList);
		
		return "admin/selectAll";
	}
	
	/** 전체 회원 조회(+정렬)
	 * @param model : 데이터 전달 객체
	 * @return
	 */
	@GetMapping("selectSort")
	public String selectSort(Model model,
			@RequestParam(value="sort", required=false, defaultValue="1") int sort) {
		
		List<Member> memberList = service.selectSort(sort);
		
		model.addAttribute("memberList", memberList);
		
		return "admin/selectSort";
	}
	
	/** 회원 복구
	 * @param memberNo : 회원 번호
	 * @param memberEmail : 회원 이메일
	 * @return
	 */
	@PostMapping("restoration")
	public String restoration(int memberNo, String memberEmail, RedirectAttributes ra) {
		
		int result = service.restoration(memberNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "복구 성공");
		} else {
			ra.addFlashAttribute("message", "복구 실패");
		}
		
		return "redirect:selectMember?inputEmail=" + memberEmail;
	}
	
	/** 권한 변경
	 * @param memberNo
	 * @param memberEmail
	 * @param ra
	 * @return
	 */
	@PostMapping("changeAuthority")
	public String changeAuthority(int memberNo, String memberEmail, RedirectAttributes ra) {
		
		int result = service.changeAuthority(memberNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "권한 변경 성공");
		} else {
			ra.addFlashAttribute("message", "권한 변경 실패");
		}
		return "redirect:selectMember?inputEmail=" + memberEmail;
	}
	
	/** 비밀번호 초기화
	 * @param memberNo
	 * @param memberEmail
	 * @param ra
	 * @return
	 */
	@PostMapping("initPw")
	public String initPw(int memberNo, String memberEmail, RedirectAttributes ra) {
		
		int result = service.initPw(memberNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "비밀번호 초기화 성공");
		} else {
			ra.addFlashAttribute("message", "비밀번호 초기화 실패");
		}
		
		return "redirect:selectMember?inputEmail=" + memberEmail;
	}
	
	@GetMapping("selectMemberNo")
	public String selectMemberNo() {
		return "admin/ajaxTest";
	}
}
