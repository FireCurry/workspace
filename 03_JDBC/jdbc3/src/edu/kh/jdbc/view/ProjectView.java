package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.model.service.ProjectService;

public class ProjectView {

	private Scanner sc = new Scanner(System.in);
	
	private ProjectService service = new ProjectService();
	
	// 로그인 한 회원의 정보가 담긴 Member 객체를 참조할 변수 선언
	private Member loginMember = null;
	
	public void displayMenu() {
		int input = -1;
		
		do {
			try {
				if(loginMember != null) { // login 상태인 경우
					System.out.println("----------------------------------------------------");
					System.out.printf("(%s) \n", loginMember.getMemberEmail());
					System.out.println("----------------------------------------------------");
				}
				
				System.out.println("\n***** MEMBER/BOARD 테이블 사용 JDBC *****\n");
				System.out.println("1. 회원 가입");
				System.out.println("2. 로그인");
				System.out.println("3. 회원 정보 수정"); // 닉네임, 전화번호 UPDATE
				System.out.println("4. 회원 탈퇴"); // MEMBER_DEL_FL = 'Y' UPDATE
				System.out.println("5. MEMBER 테이블 전체 조회");
				System.out.println("6. 게시글 작성하기"); // BOARD 테이블에 INSERT
				
				// 게시글 번호, 제목, 작성일, 조회수, 작성자번호, 작성자 닉네임
				// 게시글 번호 내림차순으로 조회
				// 단, 삭제되지 않은 글만 조회(BOARD_DEL_FL = 'N')
				System.out.println("7. 게시글 목록 조회"); // selectBoardList()
				
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴 선택 >>> ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : insertMember(); break;
				case 2 : login(); break;
				case 3 : updateMember(); break;
				case 4 : updateDelFl(); break;
				case 5 : selectAllMember(); break;
				case 6 : insertBoard(); break;
				case 7 : selectBoardList(); break;
				case 0 : System.out.println("\n--- 프로그램 종료 ---\n"); break;
				default : System.out.println("\n*** 메뉴 번호만 입력해주세요 ***\n");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("\n잘못된 입력\n");
				sc.nextLine();
			}
			
		} while (input != 0);
	}

  /**
    * 회원 가입 화면
    */
   private void insertMember() {
      System.out.println("\n***** 회원 가입 *****\n");
      
      System.out.print("이메일 : ");
      String email = sc.next();
      
      System.out.print("비밀번호 : ");
      String pw = sc.next();
      
      System.out.print("닉네임 : ");
      String nickname = sc.next();
      
      System.out.print("휴대폰 번호(- 제외) : ");
      String tel = sc.next();
      sc.nextLine(); // 입력 버퍼 개행문자 제거
      
      System.out.print("주소 : ");
      String address = sc.nextLine();
   
      // 입력 받은 값을 Member 객체에 저장하기
      Member member = new Member(email, pw, nickname, tel, address);
      
      // 서비스로 member를 전달한 후 수행 결과 반환 받기
      // -> DML(INSERT,UPDATE,DELETE) 결과는 성공한 행의 수(int)로 반환
      
      int result = service.insertMember(member); // 1 또는 0
      
      if(result > 0) {
         System.out.println("\n회원 가입 성공!!!");
      }else {
         System.out.println("\n회원 가입 실패......");
      }
   }
   
   /**
    * 로그인 화면
 	*/
   private void login() {
	   System.out.println("\n***** 로그인 *****\n");
	   
	   System.out.print("이메일 : ");
	   String email = sc.next();
	   
	   System.out.print("비밀번호 : ");
	   String pw = sc.next();
	   
	   // 로그인 서비스 호출 후 결과(Member) 반환 받기
	   Member member = service.login(email, pw);
	   
	   // 로그인 결과에 따라 출력하기
	   if (member != null) {
		   System.out.println("\n로그인 성공\n");
		   System.out.println(member);
		   
		   loginMember = member;
		   
	   } else {
		   System.out.println("\n----- 로그인 실패 -----\n");
	   }
   }
   
   /**
    * MEMBER 테이블 전체 조회
    */
   private void selectAllMember() {
	   System.out.println("\n***** MEMBER 테이블 전체 조회 *****\n");
	   
	   System.out.print("내림차순(1), 오름차순(아무 숫자) : ");
	   int sort = sc.nextInt();
	   
	   // 서비스 메서드 호출 후 결과 반환 받기
	   List<Member> memberList = service.selectAllMember(sort);
	   
	   // 조회 결과가 없을 경우 (리스트가 비어있을 경우, null 아님!)
	   if(memberList.size() == 0) {
//	   if(memberList.isEmpty()) {
		   System.out.println("\n 조회 결과가 없습니다 \n");
	   } else {
		   
		   // 향상된 for 문으로 리스트에 모든 값 출력
		   for(Member mem : memberList) {
			   System.out.println(mem);
		   }
	   }
   }
   
   /**
	 * 로그인된 회원의 닉네임, 전화번호 수정
	 */
	private void updateMember() {
	   
		// 로그인 여부 확인
		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해주세요 *****\n");
			return;
		}
		
		// 로그인 된 경우
		System.out.print("\n수정할 닉네임 : ");
		String nickname = sc.next();
		
		System.out.print("수정할 전화번호(- 제외) : ");
		String tel = sc.next();
		
		// 회원 정보 수정 서비스 호출 후 결과 반환 받기
		// 수정할 닉네임, 전화번호, 회원번호(PK, 조건절에 사용)
		int result = service.updateMember(nickname, tel, loginMember.getMemberNo());
		
		if (result > 0) System.out.println("\n***** 회원 정보 수정 완료 *****\n");
		else 			System.out.println("\n***** 회원 정보 수정 실패 *****\n");
   }
	
	/**
	 * 회원 탈퇴 뷰
	 */
	private void updateDelFl() {
		System.out.println("\n***** 회원 탈퇴 *****\n");
		
		// 로그인 여부 확인
		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해주세요 *****\n");
			return;
		}
		// 로그인 상태인 경우
		// 1) 비밀번호 입력 받기
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		// 2) 서비스 메서드 호출 후 결과 반환 받기
		// - 매개변수 : 회원번호, 입력 받은 비밀번호
		// - 반환 값 : SQL 수행 후 결과 행의 개수
		int result = service.updateDelFl(loginMember.getMemberNo(), pw);
		
		// 3) 성공일 경우 : "탈퇴 되었습니다", loginMember = null;
		//	  실패일 경우 : "비밀번호가 일치하지 않습니다"
		if (result > 0) {
			System.out.println("\n***** 탈퇴 되었습니다 *****\n");
			loginMember = null;
		} else {
			System.out.println("\n***** 비밀번호가 일치하지 않습니다 *****\n");
		}
	}
	
	/**
	 * 게시글 작성
	 */
	private void insertBoard() {
		System.out.println("\n***** 게시글 작성 *****\n");
		
		// 로그인 여부 확인
		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해주세요 *****\n");
			return;
		}
		
		System.out.print("제목 입력 : ");
		String title = sc.nextLine();
		
		System.out.println("내용 입력 (입력 종료 : !wq)");
		
		String content = ""; // 빈 문자열
		
		while (true) {
			String temp = sc.nextLine(); // 한 줄 입력
			
			if (temp.equals("!wq")) { // 입력 종료 커맨드인 경우
				break;
			}
			
			content += temp + "\n"; // 입력 받은 한 줄을 content에 누적
		}
		
		// BOARD 테이블에 삽입하는 서비스 호출 후 결과 반환 받기
		int result = service.insertBoard(title, content, loginMember.getMemberNo());
								// 제목, 내용, 작성자 회원 번호
		
		if (result > 0) { // 삽입 성공 시
			System.out.println("\n***** 게시글이 등록 되었습니다 *****\n");
		} else {
			System.out.println("\n***** 게시글 등록 실패 *****\n");
		}
	}
	
	private void selectBoardList() {
		
		System.out.println("\n게시글 목록 조회\n");
		
		String result = service.selectBoardList();
		
		if (result != null) {
			System.out.println("\n목록 조회 완료\n");
		} else {
			System.out.println("\n목록 조회 실패\n");
		}
		
		
	}
}
