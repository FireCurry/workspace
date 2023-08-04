package edu.kh.oop.field.pack2;

public class StudentRun {

	public static void main(String[] args) {
		
		// Student 객체 생성
		Student s1 = new Student();
		
		s1.grade = 3;
		s1.ban = 5;
		s1.number = 12;		
		s1.name = "홍길동";

		Student s2 = new Student();
		s2.grade = 2;
		s2.ban = 1;
		s2.number = 16;		
		s2.name = "김길동";
		
		Student s3 = new Student();
		s3.grade = 1;
		s3.ban = 7;
		s3.number = 25;		
		s3.name = "고길동";
		
		// 프로그램 실행 중 학교명 변경 기능 추가
		
		System.out.println("---변경전 학교명---");
		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);
		System.out.println(s3.schoolName);
		
		// 학교명 변경
//		s1.schoolName = "중구 국제 중학교";
//		s2.schoolName = "중구 국제 중학교";
//		s3.schoolName = "중구 국제 중학교";
		// 학생이 천 명이면 변경 코드를 천 번 작성해야함..
		
		// * schoolName 필드를 static으로 변경하면
		// 한 학생의 학교명만 변경해도 모두 바뀜
//		s1.schoolName = "중구 과학 중학교";
		
		// * static 붙은 필드를 다룰때는 클래스명.필드명 으로 작성을 권장 *
		Student.schoolName = "중구 외국어 중학교";
		
		System.out.println("---변경전 학교명---");
		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);
		System.out.println(s3.schoolName);
		
	}
}
