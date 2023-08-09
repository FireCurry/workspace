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

	public void ex2() {
		
		// 컬렉션 장점 중 "여러 타입 저장 가능"
		// 때문에 instanceof로 타입 검사를 해야하는 코드가 추가되어
		// 코드 길이가 늘어나는 문제점이 발생한다
		// -> 그래서 타입을 하나로 제한!
		// --> Generics(제네릭)을 이용
		
		// String으로 저장되는 타입이 제한된 List
		// -> 컴파일 단계에서 강력한 타입 체크
		List<String> list = new ArrayList<String>();
		
		list.add("오므라이스");
		list.add("닭갈비");
		list.add("국밥");
		list.add("삼계탕");
		list.add("죽");
		list.add("보쌈정식");
		
		// list.add(int index, E e) : 중간에 추가(삽입) 
		// 나머지 요소들은 뒤로 한 칸씩 밀림
		list.add(0, "곰탕");
		list.add(3, "뚝배기불고기");
		
		// E list.set(int index, E e)
		// 지정된 index의 요소를 바꿈(수정)
		// 반환되는 값은 바뀌기 이전 요소							
		String before = list.set(1,  "치즈 닭갈비");
		System.out.println("before : " + before);
		
		// E list.romove(int index)
		// index 번째 요소를 List에서 제거
		// 반환되는 값은 제거된 요소
		String target = list.remove(6);
		System.out.println(target + " 제거");
		
		// boolean list.contains(E e)
		// list에 요소가 포함되어 있는지 확인
		
		System.out.println(list.contains("삼계탕"));
		System.out.println(list.contains("누룽지 삼계탕"));
		
		// int list.indexOf(E e) : 다른 프로그래밍 언어에도 똑같은 이름과 기능으로 쓰인다
		// list에 요소가 존재하면 해당 index 반환
		// 없으면 -1 반환
		
		System.out.println(list.indexOf("삼계탕"));
		System.out.println(list.indexOf("누룽지 삼계탕"));
		
		
		// void list.clear() : 요소 모두 삭제
		list.clear();
		
		// boolean list.isEmpty()
		// 비어 있으면 true, 아니면 false
		System.out.println(list.isEmpty());
		
		for (int i = 0 ; i < list.size() ; i++) {
			// list.get(i)
			// ---> String으로 제한된 리스트 요소를 꺼내오기 때문에
			//		꺼낸 요소의 자료형은 무조건 String
			System.out.printf("[%d] : %s \n", i, list.get(i));
			
		}
		
		
		
		
	}
}
