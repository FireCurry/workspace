package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int input = sc.nextInt();
		
		String result = input <= 13 ? "어린이"
				: input > 13 && input <=19 ? "청소년" : "성인";
		
				// age > 13 && age <= 19 : 청소년
				// age > 19 : 성인
				// age <= 19 : 청소년 (선행 조건에서 13이하는 사라졌기 때문에)
				
		System.out.println("\n" + result);
		
	}
}
