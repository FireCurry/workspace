package edu.kh.jsp.dto;

/**
 * 
 */
public class Book {

	private String title;
	private String writer;
	private int price;
	
	public Book() {} // 기본 생성자
	
	public Book(String title, String writer, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	// toString 오버라이딩
	@Override // 오버라이딩 메서드 잘 작성되었나 확인
	public String toString() {
		return String.format("%s , %s , %s", title, writer, price);
	}
	
}
