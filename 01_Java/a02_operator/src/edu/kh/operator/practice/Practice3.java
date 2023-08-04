package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		String result = 
				input == 0 ? "0" : (input > 0 ? "양수" : "음수");
		System.out.println(result);
	}
}