package a05_oop복습;

import java.util.Scanner;

public class PersonService {

	private Scanner sc = new Scanner(System.in);
	
	private String title;
	
	public PersonService() {
		title = "===== Person을 이용한 프로그램 =====";
	}
	public String getTitle() {
			return title;
	}
		
	public Person createPerson() {
			
		System.out.println("=== Person 객체 생성하기 ===");
			
		System.out.print("이름 : ");
		String name = sc.next();
			
		System.out.print("나이 : ");
		int age = sc.nextInt();
			
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
			
		Person p = new Person(name, age, gender);
			
		return p;
			
	}
	
	public String personFields(Person p) {
		String str = p.getName() + " / " + p.getAge() + "세 / " + p.getGender();
		
		return str;
	}
}
