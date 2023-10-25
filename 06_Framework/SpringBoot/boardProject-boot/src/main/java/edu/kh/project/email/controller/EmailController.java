package edu.kh.project.email.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.email.model.service.EmailService;
import lombok.RequiredArgsConstructor;

// @RestController : 비동기 요청 및 응답 제어 용도의 컨트롤러
@RestController // @Controller + @ResponseBody
@RequestMapping("email")
@RequiredArgsConstructor // 초기화 되지 않은 final 필드에 bean을 DI
						// -> @Autowired 생성자 버전 자동완성
public class EmailController {
	
	// @Autowired를 이용한 DI 방법은 세 가지가 존재
	// - 필드 (쉬움, 권장 X)
	// - setter
	// - 생성자 (권장)
	
	/* @Autowired 생성자 버전 */
	
	// 1) 의존성 주입을 받을 필드를 선언(final 필수!)
	private final EmailService service;
	
	// 2) 매개변수 생성자
//	@Autowired
//	public EmailController(EmailService service) {
//		// 매개변수에 bean이 자동으로 주입(DI)
//		this.service = service;
//	}
	
	// 위 구문을 더 쉽게하는 방법!!!
	// -> Lombok의 @RequiredArgsConstructor 사용
	

	/** 회원 가입 인증번호 생성 + 이메일 발송 + insert 또는 update
	 * @return
	 */
	@PostMapping("signup")
	public int signup(@RequestBody String email) {
		return service.sendEmail("signup", email);
	}
	
	/** 인증 번호 확인
	 * @param paramMap
	 * @return
	 */
	@PostMapping("checkAuthKey")
	public int checkAuthKey(@RequestBody Map<String, Object> paramMap) {
		return service.checkAuthKey(paramMap);
	}
}
