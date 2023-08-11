package edu.kh.io.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.io.model.dto.Member;
import edu.kh.io.model.service.MemberService;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	// MemberService 객체 생성
	private MemberService service = new MemberService();

	/**
	 * 메뉴 출력 view
	 */
	public void displayMenu() {
		
		int input = 0;
		
		do {
			try {
				System.out.println();
				System.out.println("\n----- 회원 관리 프로그램 -----\n");
				
				System.out.println("1. 회원 목록 조회");
				System.out.println("2. 회원 가입");
				System.out.println("3. 아이디/비밀번호 일치하는 회원 조회");
				System.out.println("4. 아이디/비밀번호 일치하는 회원의 비밀번호 변경");
				System.out.println("5. 아이디/비밀번호 일치하는 회원 탈퇴");
				
				System.out.println("0. 종료");
				
				System.out.print("메뉴 선택 >>>> ");
				input = sc.nextInt();
				
				switch (input) {
				case 1 : selectAll(); break;
				case 2 : signUp(); break;
				case 3 : selectOne(); break;
				case 0 : System.out.println("<프로그램이 종료됩니다>"); break;
				default : System.out.println("<메뉴의 번호만 입력해주세요>");
				}
			} catch (InputMismatchException e) {
				System.out.println("<잘못된 입력입니다>");
				input = -1; // 첫 번째 반복에서 예외 발생 시 while문 종료 방지
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 문자열 제거
			}
		} while (input != 0);
	}

	/**
	 * 회원 목록 조회 view
	 */
	private void selectAll() {
		System.out.println("\n----- 회원 목록 조회 -----\n");
		
		// Service로 부터 회원 목록을 반환 받아서 모두 출력
		List<Member> memberList = service.selectAll();
		
		// 회원 목록이 비어있을 경우 == 회원이 없는 경우
		// == memberList.txt. 파일이 없어서 읽어온 회원 목록이 없는 경우
		if(memberList.isEmpty()) {
			System.out.println("=== 회원이 존재하지 않습니다 ===");
			return;
		}
		
		// 회원이 있을 경우 향상된 for문으로 모두 출력
		for (Member mem : memberList) System.out.println(mem);
	}
	
	/**
	 * 회원 가입 view
	 */
	private void signUp() {
		System.out.println("\n----- 회원 가입 -----\n");
		
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("포인트 : ");
		int point = sc.nextInt();
		
		// 입력 받은 값을 서비스로 전달 후
		// 회원 가입(memberList에 추가) 성공 시 true,
		// 아이디가 중복이면 false 반환
		
		boolean result = service.signUp(id, pw, name, point);
		
		if (result) {
			System.out.println(id + "회원이 가입 되었습니다");
		} else {
			System.out.println("<< 이미 사용 중인 아이디 입니다 >>");
		}
	}
	
	/**
	 * 아이디/비밀번호 일치하는 회원 조회 view
	 */
	private void selectOne() {
		System.out.println("\n----- 아이디/비밀번호 일치하는 회원 조회 -----\n");
		
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();		
		
		// 입력 받은 값을 서비스로 전달하여
		// 일치하는 회원 (Member) 반환, 없으면 null 반환
		Member mem = service.selectOne(id, pw);
		System.out.println();
		if (mem == null) {
			System.out.println("<< 일치하는 회원이 없습니다 >>");
		} else {
			System.out.println("ID : " + mem.getId());
			System.out.println("PW : " + mem.getPw());
			System.out.println("이름 : " + mem.getName());
			System.out.println("포인트 : " + mem.getPoint());
		}
	}
}
