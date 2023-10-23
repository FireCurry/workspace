package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/* Spring Boot Controller에서 요청 주소 작성 시
 * 제일 앞에 "/" 제외하고 작성
 * */

@Slf4j // 로그
@Controller // Controller 역할(요청/응답 제어) + Bean 등록
@RequestMapping("member")
@SessionAttributes({"loginMember"}) // 세션 scope로 올리기
public class MemberController {

	// MemberService 의존성 주입
	@Autowired
	private MemberService service; // = new MemberServiceImpl();
	
	/** 로그인
	 * @param inputMember : 아이디, 비밀번호 파라미터
	 * @param model : 데이터 전달 객체
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @param saveId : 아이디 저장 체크 시 "on", 미체크 시 null
	 * @param resp : 응답 방법을 제공하는 객체
	 * @return 메인 페이지(/) 리다이렉트
	 */
	@PostMapping("login")
	public String login(Member inputMember, Model model, RedirectAttributes ra,
			String saveId, HttpServletResponse resp) {
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		// 로그인 성공 시
		if(loginMember != null) {
			
			// 쿠키 객체 생성
			// - jakarta.servlet.http.Cookie
			// - Map 형식 (K:V) 형식으로 데이터를 저장
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			// 아이디 저장이 체크된 경우
			if(saveId != null) {
				
				// 쿠키의 수명(유지기간) 지정 (초 단위)
				cookie.setMaxAge(60*60*24*30); // 30일
			}
			
			// 체크되지 않은 경우
			else {
				
				// 만들자 마자 없어짐 == 삭제
				cookie.setMaxAge(0);
			}
			
			// 쿠키가 어떤 요청에 첨부되서 전달될지 주소(경로) 지정
			cookie.setPath("/"); // 최상위 주소 이하 모든 요청
			
			// 응답 객체(HttpServletResponse)를 이용해
			// 서버 응답 시 클라이언트에게 생성한 쿠키 전달
			
			// -> 전달 받은 클라이언트(브라우저)가
			// Cookie 객체를 브라우저 자체 쿠키 파일에 저장
			
			resp.addCookie(cookie);
			
		}
		// 로그인 실패 시
		if(loginMember == null) {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
		}
		
		model.addAttribute("loginMember", loginMember);
		
		//메인 페이지 리다이렉트
		return "redirect:/";
	}
	
	/** 로그인 전용 페이지 forward
	 * @return "member/login"
	 */
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete(); // @SessionAttributes 세션 만료
		return "redirect:/";
	}
	
	/** 회원 가입 페이지 forward
	 * @return 
	 */
	@GetMapping("signup")
	public String signup() {
		// templates/member/signup.html로 forward
		return "member/signup";
	}
	
	/** 회원 가입
	 * @param inputMember : parameter가 저장된 커맨드 객체
	 * @param memberAddress : 주소 입력 값이 저장된 배열(가공 예정)
	 * @param ra : 리다이렉트 시 request scope로 값 전달
	 * @return
	 */
	@PostMapping("signup")
	public String signup(Member inputMember, String[] memberAddress, RedirectAttributes ra) {
		
		
		// 회원 가입 서비스 호출
		int result = service.signup(inputMember, memberAddress);
		
		// 회원 가입 성공 시
		if(result > 0) {
			ra.addFlashAttribute("message", "회원 가입 성공");
			return "redirect:/"; // 메인 페이지
		}
		
		// 회원 가입 실패
		ra.addFlashAttribute("message", "가입 실패....");
		return "redirect:signup"; // 회원 가입 페이지 (상대경로 작성)
	}
	
	// @PathVariable("key")
	// - 경로(주소)를 변수에 값으로 사용하는 어노테이션
	
	
	/** 빠른 로그인 (프로젝트 완성 후 삭제!)
	 * @param memberEmail : 주소 마지막 레벨 문자열(PathVariable)
	 * @param model : 데이터 전달용 객체
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return 
	 */
	@GetMapping("login/{memberEmail}")
	public String quickLogin(@PathVariable("memberEmail") String memberEmail,
			Model model, RedirectAttributes ra) {
		
//		log.debug("memberEamil : " + memberEmail);
		Member loginMember = service.quickLogin(memberEmail);
		
		if(loginMember == null) {
			ra.addFlashAttribute("message", "빠른 로그인 실패");
		}
		
		// (기본값) request scope
		// @SessionAttributes({"loginMember"}) -> session scope 이동
		model.addAttribute("loginMember", loginMember);
		
		return "redirect:/";
	}
}
