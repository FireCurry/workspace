package javaproject.test.example4;

public class Rectangle extends Shape implements Resizable{

	public boolean isSquare() {
		return true;
	}
	
	@Override
	protected double getArea() {
		return 0;
	}
	
	@Override
	public void resize() {
	}
}
