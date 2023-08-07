package edu.kh.poly.model.dto;

public class JYJCalculator implements Calculator{

	@Override
	   public int plus(int a, int b) {
	      return a+b;
	   }

	   @Override
	   public int minus(int a, int b) {
	      return a-b;
	   }

	   @Override
	   public int multi(int a, int b) {
	      return a*b;
	   }

	   @Override
	   public int div(int a, int b) {
	      return a/b;
	   }

	   @Override
	   public int mod(int a, int b) {
	      return a%b;
	   }

	   @Override
	   public double areaOfCircle(double r) {
	      return PI*r*r;
	   }

	   @Override
	   public int pow(int a, int x) {
	      int answer =1;
	      for(int i = 0; i<x; i++) {
	         answer *=a;
	      }
	      return answer;
	   }

}
