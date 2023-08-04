package a00_testProject;

// 주석 : 코드에 대한 설명을 작성하는 부분 (컴파일러(번역기) 해석 X)

// 한 줄 주석

/*
범위 주석
여러 줄 주석
 */

// class : 자바 코드를 작성하는 영역
public class JavaTest {

	// main 메서드 ( method, 기능 )
	// - 자바 프로그램 ( 프로젝트, 애플리케이션 )을 
	// 실행시키기 위해 반드시 필요한 구문 ( 기능 )
	public static void main(String[] args) {
	
		// 실생 방법
		// 1) 위에 실행 버튼 ( Run 버튼 )
		// 2) ctrl + F11
		
		// System.out.println() : () 안의 문자열 출력 후 엔터 ( 한 줄 출력 )
		System.out.println("Hello World");
		System.out.println("안녕하세요");
		
		// 숫자만 작성하면 연산
		System.out.println(3500 + 6000);
		
		// 사칙연산 우선순위를 그대로 적용
		// 숫자 + "문자열" = 숫자문자열 ( 이어쓰기, 추가하기, 덧붙이기 )
		System.out.println(1000 + 2000 + "원"); //3000원
		
		System.out.println("김_민_석");
		System.out.println("만 " + 28 + " 세");
		
		// 김밥 : 2000원, 떡볶이 : 3000원
		System.out.println(2000 + 3000); //5000
		System.out.println("합계 : " + 2000 + 3000 + " 원");
		System.out.println("합계 : " + (2000 + 3000) + " 원");
		// +는 우선순위가 같기 때문에 왼쪽에서부터 연산이 시작되어서 
		// 합계와 2000이 붙어서 합계 : 2000이 된 후 3000이 더해져서 합계 : 20003000이라는 기괴한 단어가 나온다
		// 연산 우선순위 문제
		// "합계 : " +2000 = "합계 : 2000"
		// "합계 : 2000" + 3000 = "합계 : 20003000"
		// "합계 : 20003000" + " 원" = "합계 : 20003000 원"
	}
	
}
