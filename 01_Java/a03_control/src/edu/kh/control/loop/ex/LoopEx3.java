package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx3 {

	/* while문
	 * 
	 * - 반복 조건만을 설정하는 반복문
	 * 
	 * - 조건식이 true인 경우에 계속 반복
	 *	--> 조건식이 false가 되는 상황을 같이 구현해야 함
	 *		(안 하면 무한루프의 굴레에 영원히 갇히게 된다)									
	 * 
	 * [작성법]
	 * while (조건식) {
	 * 		조건식이 true일때 수행할 구문
	 * 		(+ 조건식이 특정 상황에 false가 되게 하는 구문도 같이 작성한다)
	 * }
	 * 
	 */
	
	// 숫자 0일 입력될 때까지 종료되지 않는 프로그램
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		int input = -1; // 입력 받은 값을 저장할 변수
						// + 종료 조건과 관련 없는 값으로 초기화
		
		while (input != 0) { // input이 0이 아닐 때 true
			System.out.print("숫자를 입력해주세요 : ");
			input = sc.nextInt();
		}
	}
	
	// 0이 입력되기 전까지 입력된 모든 숫자의 합 출력
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		int input = -1; // 입력 값 저장 + while문이 종료되지 않게하는 값 대입
		int sum = 0; // 합계 저장용 변수
		while (input != 0 ) {
			System.out.print("정수 입력 : ");
			input = sc.nextInt(); // 여기서 0 입력 시 반복 종료
			sum += input; // 입력된 값을 sum에 누적
		}
		System.out.printf("입력된 정수의 합 : %d", sum);
	}
	
	// 분식집 주문 프로그램
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		int sum =0; // 주문한 메뉴의 가격 합계를 저장
		
		String orderMenu = ""; // 빈 문자열(빈칸)
		// 합계를 구하는 sum을 초기화할 때 0을 사용하는 것처럼
		// 문자열을 이어쓰기 하더라도 아무런 영향이 없는 문자열
		
		int input = 0; // 입력한 메뉴 번호를 저장할 변수
		
		while (input != 9) { // 9 입력 시 조건식이 false가 되어서 while문이 종료된다
			System.out.println("----- 메뉴 -----");
			System.out.println("1. 김밥(3000원)");
			System.out.println("2. 라면(3500원)");
			System.out.println("3. 떡볶이(4000원)");
			System.out.println("9. 주문 완료");
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt(); // input에 메뉴 번호를 저장한다
			
			switch (input) {
			case 1 : 
				sum += 3000;
				orderMenu += "김밥 "; break;
			case 2 : 
				sum += 3500;
				orderMenu += "라면 "; break;
			case 3 : 
				sum += 4000;
				orderMenu += "떡볶이 "; break;
			case 9 : System.out.println("주문 완료!");break;
			default : System.out.println("<<메뉴에 작성된 번호만 눌러주세요>>");
			}
		} // while 종료
		System.out.println("주문한 메뉴 : " + orderMenu);
		System.out.println("총 가격 : " + sum);
	}
	
	// while문을 for문 처럼 사용하는 방법
	// 1 2 3 4 5 출력(while문 사용)
	public void ex4() {
		
		// for문 사용
		for (int i = 1 ; i <= 5 ; i++) {
			System.out.printf("%d ", i);
		}
		System.out.println("\n---------------");
		int i = 1; 
		// while문 사용
		while (i <= 5) {
			System.out.printf("%d ", i);
			i++;
		}
	}
	
	// do - while문 : while문의 조건식 확인 위치를 끝으로 보낸 while문
	public void ex5() {
	
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // 합계
		
		int input; // 입력 값을 저장할 변수 선언
		
		do {
			System.out.print("숫자 입력 : ");
			input = sc.nextInt(); // 변수 초기화
			
			sum += input; // 누적
			
		} while (input != 0);
		// do 구문에서 input이 무조건 초기화 되기 때문에
		// input 선언 시 초기화를 하지 않아도
		// while 조건식에서 오류가 발생하지 않는다.
		
		System.out.println("합계 : " + sum);
		
	}
	public void ex6() {
		
		
	}
	public void ex7() {
		
		
	}
	public void ex8() {
		
		
	}
	
}
