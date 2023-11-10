package javaproject.test.example7;

public class Shop {

	private Product product;
	private Employee emp;
	
	public Shop(Product p) {
		this.product = p;
		this.emp = new Employee();
	}
}
