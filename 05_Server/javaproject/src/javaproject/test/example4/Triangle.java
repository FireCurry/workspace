package javaproject.test.example4;

public class Triangle extends Shape implements Resizable {

	public boolean isEquilateral() {
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
