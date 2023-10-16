package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그
@Controller // Controller 역할(요청/응답 제어) + Bean 등록
@RequestMapping("/member")
@SessionAttributes({"loginMember"}) // 세션 scope로 올리기
public class MemberController {

	// MemberService 의존성 주입
	@Autowired
	private MemberService service; // = new MemberServiceImpl();
	
	/** 로그인
	 * @param inputMember : 아이디, 비밀번호 파라미터
	 * @param model : 데이터 전달 객체
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return 메인 페이지(/) 리다이렉트
	 */
	@PostMapping("/login")
	public String login(Member inputMember, Model model, RedirectAttributes ra) {
		
		String message = null;
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		// 로그인 성공 시
		if(loginMember != null) {
			// 쿠키 생성 코드 작성 예정
		}
		// 로그인 실패 시
		if(loginMember == null) {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
		}
		
		model.addAttribute("loginMember", loginMember);
		
		//메인 페이지 리다이렉트
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
			
		status.setComplete();
		return "redirect:/";
	}
	
	@PostMapping("/signup")
	public String signup(Member inputMember, RedirectAttributes ra) {
		
		String message = null;
		int result = service.signup(inputMember);
		
		if(result > 0) {
			message = "회원가입 성공~";
		}
		if(result == 0) {
			message = "회원가입 실패 ㅠ";
		}
		ra.addFlashAttribute("message", message);
		return "redirect:/";
	}
}
