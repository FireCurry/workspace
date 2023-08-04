package edu.kh.poly.model.dto;

public class Spark extends Car{

	private double discountRate; // 할인율
	
	// 기본 생성자
	public Spark() {
	}

	// 매개변수 생성자
	
	public Spark(int wheel, int seat, String fuel, double discountRate) {
		super(wheel, seat, fuel);
		this.discountRate = discountRate;
	}

	// getter / setter
	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return super.toString() + " / Spark [discountRate=" + discountRate + "]";
	}
	
}
