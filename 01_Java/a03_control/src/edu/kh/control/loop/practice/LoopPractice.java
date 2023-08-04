package edu.kh.control.loop.practice;

import java.util.Scanner;

public class LoopPractice {

	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if (input >= 1) {
			for ( int i = 1 ; i <= input ; i++) {
				System.out.printf("%d ", i);
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if (input >= 1) {
			for (int i = input ; i >= 1 ; i--) {
				System.out.printf("%d ", i);
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 1;
		
		System.out.print(1);
		for (int i = 2 ; i <= input ; i++) {
			System.out.printf(" + %d", i);
			sum += i;
		}
		System.out.println(" = " + sum);
	}
	
//	for (int i = 1 ; i <= input ; i++) {
//		sum += i;
//		
//		System.out.print(i);
//		
//		if (i < input) {
//			System.out.print(" + ");
//		}
//	} System.out.println(" = " + sum);
//	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
// 쉬운 방법		
		if (num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
//		} else if (num1 > num2) {
//			for (int i = num2 ; i <= num1 ; i++) {
//				System.out.print(i + " ");
//			} 
//		} else {
//				for (int i = num1 ; i <= num2 ; i++) {
//					System.out.print(i + " ");
//				}
//		}
// 생각을 좀 해봐야 되는 방법 + 변수를 아는가?
		} else {
			if (num1 > num2) {
			// 두 변수의 값 교환(임시 변수 필요)
			int temp = num1;
			num1 = num2;
			num2 = temp;
			}
			for (int i = num1 ; i <= num2 ; i++) {
			System.out.print(i + " ");
			}
		}
	}
	
	
	public void practice5() {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		System.out.printf("===== %d단 =====\n", input);
		for (int i = 1 ; i <= 9 ; i++) {
			System.out.printf("%d * %d = %d\n", input, i, input * i);
			
		}
	}
	
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		if (input >= 2 && input <= 9) {
			for (int i = input ; i <= 9 ; i++) {
				System.out.printf("===== %d단 =====\n", i);
				for (int i2 = 1 ; i2 <= 9 ; i2++) {
					System.out.printf("%d * %d = %d\n", i, i2, i2 * i);
				}
			}	
		} else {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		}
	}
	
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1 ; i <= input ; i++) {
			for (int i2 = 1 ; i2 <= i ; i2++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1 ; i <= input ; i++) {
			for (int i2 = input ; i2 >= i ; i2--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1 ; i <= input ; i++) {
			for (int i2 = input ; i2 >= 1 ; i2--) {
				if (i < i2) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1 ; i < 2 * input ; i++) {
			if(i <= input) {
				for (int i2 = 1 ; i2 <= i ; i2++) {
				System.out.print("*");
				}
			} else {
				for (int i3 = 2 * input ; i3 > i ; i3-- ) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = input ; i >= 1 ; i--) {
				for (int i2 = 1 ; i2 <= 2 * input - i ; i2++) {
					if (i > i2) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}  
				}
				
			System.out.println();
		}
	}
	
	
	public void practice12() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1 ; i <= input ; i++) {
			for (int i2 = 1 ; i2 <= input ; i2++) {
				if (i == 1 || i == input) {
					System.out.print("*");
				} else if (i2 == 1 || i2 == input) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
					 
			}
			System.out.println();
		}
	}
	
	
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int count = 0;
		
		for (int i = 1 ; i <= input ; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.printf("%d ", i);
				if (i % 2 == 0 && i % 3 == 0) {
					count++;
				}
			}
		}
		System.out.println("\ncount : " + count);
	}
}
