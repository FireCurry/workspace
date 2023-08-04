package edu.kh.oop.basic;

import java.util.Scanner;

public class External {

	public static void main(String[] args) {
		Internal in = new Internal();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입금 : ");
		int plus = sc.nextInt();
		System.out.print("출금 : ");
		int minus = sc.nextInt();
		
}
}
