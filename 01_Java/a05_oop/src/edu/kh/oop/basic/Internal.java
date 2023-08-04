package edu.kh.oop.basic;

import java.util.Scanner;

public class Internal {
	
	private String name;
	private String accountNumber;
	private String password;
	private int code;
	private int balance;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		accountNumber = sc.next();
		password = sc.next();
		code = sc.nextInt();
		balance = sc.nextInt();
		
	}
	
	public void plus(int plus) {
		this.balance += plus;
	}
	
	public void minus(int minus) {
		this.balance -= minus;
	}
}
