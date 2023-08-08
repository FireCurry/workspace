package edu.kh.collection.list.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

	// 컬렉션 특징
	// 1) 크기 제한이 없다
	// 2) 추가, 수정, 삭제 등의 코드가 구현되어 있다
	// 3) 객체만 저장 가능
	
	/* List : 자료를 순차적으로 나열한 자료구조 (배열과 비슷)
	 * 
	 * - 특징 1 : 인덱스를 이용해서 순서를 구분
	 * - 특징 2 : 순서가 구분되기 때문에 중복 데이터 저장 가능
	 * 
	 */
	
	public void ex1() {
		
		// 다형성 적용 (업 캐스팅)
//		List list = new ArrayList(); // 10칸 짜리 생성
		
		List list = new ArrayList(3); // 3칸 짜리 생성
		
		// 1. boolean add(E e) : 마지막 요소로 추가
		// E(Element) : 요소를 뜻하는 상징적인 글자 (자료형 X)
		// -> Object를 생각하면 편함
		list.add("아무거나"); // String은 객체
		
		// Auto Boxing
		list.add(123); // int -> Integer
		list.add(3.14); // double -> Double
		// 객체를 구분하는 법 뒤에 .을 붙였을 때 기능들이 나오면 객체이다
		
		// * 컬렉션의 저장되는 객체의 타입 제한이 없다
		
		// 왜? 기본 자료형이 저장될까?
		// --> Wrapper Class (감싸는 클래스)
		
		
		System.out.println(list);
		
		// list의 크기 3을 초과해서 추가해도
		// 자동으로 크기가 늘어나서 에러 발생 X
		list.add("크기 3 초과");
		System.out.println(list);
		
		// 2. E get(int index) : 지정한 index요소 얻어오기
		System.out.println( list.get(2) );
		System.out.println( list.get(1) );
		System.out.println( list.get(0) );
		
		System.out.println("------------------------------------------");
		
		// 진짜 자동 포장 (Auto Boxing) 되었는가 확인
		System.out.println( list.get(1) instanceof Integer); // true 
		System.out.println( list.get(2) instanceof Double); // true
		
		
		// List + for문 + if문 + instanceof + 다운 캐스팅
		// int list.size() : 저장된 객체의 개수를 반환
		for (int i = 0 ; i < list.size(); i++) {
			
			if (list.get(i) instanceof String) { // i번째 요소가 String
				String s = (String)list.get(i); // 다운 캐스팅
				
				System.out.println("첫 글자 " + s.charAt(0));
			}
			if (list.get(i) instanceof Integer) {
				
				// Auto Unboxing 자동으로 실행
				int number = (Integer)list.get(i);
				
				System.out.println(100 + number);
			}
		}
		
		
}
	
	
	
	
	
			
			
			
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
			
			
			
			
			
}
