package a05_oop복습;

public class PersonServiceRun {
	public static void main(String[] args) {
		
		PersonService service = new PersonService();
		
		String title = service.getTitle();
		
		System.out.println(title);
		
		Person p1 = service.createPerson();
		
		String str = service.personFields(p1);
		System.out.println(str);
		
		Person p2 = service.createPerson();
		
		String str2 = service.personFields(p2);
		System.out.println(str2);
	}
}
