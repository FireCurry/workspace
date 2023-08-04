package edu.kh.oop.basic;

/* 객체란?
 * 
 * - 현실 : 속성(data)과 기능(method)을 가지고 있는 식별 가능한 것
 * 
 * - Java : 클래스에 작성된 내용을 토대로
 * 			new 연산자에 의해 Heap 메모리에 생성되는 것
 * 
 * 클래스(class)란?
 * - 객체의 특성(속성, 기능)을 정의한 것
 * 		-> 일종의 설계도로 class에 정의된 내용대로
 * 		   Heap 메모리에 생성하면 객체가 된다.
 * 
 * 		+ 하나의 설계도(class)를 이용해 여러 객체를 만들 수 있다.
 */

public class BasicRun {
	public static void main(String[] args) {
		
		// Nation 클래스를 이용해서 객체 생성하기
		Nation n1 = new Nation();
		
		// 클래스 == 설계도 == 사용자 정의 자료형
		// Nation n1 : Nation 객체 참조 변수 n1을 선언(주소 저장)
		
		// new : Heap 영역에 새롭게 할당(생성)
		
		// new Nation() : Nation 클래스를 이용해서
		//				  Heap 영역에 Nation 객체를 생성(메모리 할당)
		//				->할당된 메모리의 시작 주소가 반환됨
		
		// Nation n1 = new Nation();
		// Nation 참조 변수 n1에
		// Heap에 새로 생성된 Nation 객체의 주소를 대입
		
		// n1 == Nation 객체를 참조하는 변수
		// == Nation 객체를 의미
		
		//  .  (점, 하위접근)연산자 :
		// 객체의 속성 또는 기능에 접근, 실행하는 연산자
		
		n1.speakKorean();
		n1.납세의의무();
		
		// 객체의 속성에 값 대입
		n1.pNo = "991212-1234567";
		n1.name = "홍길동";
		n1.gender = '남';
		n1.address = "서울시 중구 남대문로 120 청계그레이츠 2층";
		n1.phone = "010-1234-1234";
		n1.age = 23;
		
		// 객체에 저장된 속성 출력
		System.out.println(n1.pNo);
		System.out.println(n1.name);
		System.out.println(n1.gender);
		System.out.println(n1.address);
		System.out.println(n1.phone);
		System.out.println(n1.age);
		
		/* 캡슐화 적용 확인 */
		// private String job; 에 값 대입하기
		
		// n1.job = "국정원 비밀요원";
		// The field Nation.job is not visible
		
		/* 간접 접근 기능 */
		n1.setJob("(돈 많이 버는)웹 개발자");
		
		System.out.println(n1.getJob());
		
		n1.introduce();
		
		// 새로운 국민 객체 생성
		Nation n2 = new Nation();
		n2.name = "김영희";
		n2.age = 20;
		
		Nation n3 = new Nation();
		n3.name = "박영민";
		n3.age = 30;
		
		System.out.printf("%s의 나이는 %d세 입니다.\n", n1.name, n1.age);
		System.out.printf("%s의 나이는 %d세 입니다.\n", n2.name, n2.age);
		System.out.printf("%s의 나이는 %d세 입니다.\n", n3.name, n3.age);
		
		n1.납세의의무();
		n2.납세의의무();
		n3.납세의의무();
		
		n1.setJob("가나다");
		System.out.println(n1.getJob());
	}
}