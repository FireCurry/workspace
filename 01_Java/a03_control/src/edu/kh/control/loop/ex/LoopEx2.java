package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx2 {

	// 구구단 2단 출력하기
	// 2 X 1 = 2
	// 2 X 2 = 4
	// 2 X 3 = 6
	// ... 등등
	public void ex1() {
		
		for (int i = 1 ; i <= 9 ; i++) {
			System.out.printf("2 X %d = %d \n", i, 2 * i);
		}
	}
	
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int input = sc.nextInt();
		
		System.out.printf("\n[구구단 %d단]\n", input);
		
		for (int i = 1 ; i<=9 ; i++) {
			System.out.printf("%d X %d = %d \n", input, i, input * i);
		}
	}

	// 입력 받은 단 출력하기
	// 조건 : 입력 받은 값이 2 ~ 9 사이 일때만 구구단 출력
	//		  2 ~ 9 사이가 아닐 경우 "잘못 입력 하셨습니다" 출력
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int input = sc.nextInt();
		
		if (input >= 2 && input <= 9) {
			System.out.printf("\n[구구단 %d단]\n", input);
		
			for (int i = 1 ; i<=9 ; i++) {
				System.out.printf("%d X %d = %d \n", input, i, input * i);
			}
		} else {
			System.out.println("\n잘못 입력 하셨습니다");
		}
	}

	// 5 4 3 2 1 출력 하기 (반복문 사용해서!)
	public void ex4() {
		
		for (int i =1 ; i <= 5 ; i++) {
			System.out.printf("%d ", i);
		}
		System.out.println();
		
		for (int i = 5 ; i > 0 ; i--) {
			System.out.print(i + " ");
		}
	}

	// 9 8 7 6 5 4
	public void ex5() {
		
		// i >= 4, i > 3 두 개는 같다 (정수의 범위에서)
		for (int i = 9 ; i >= 4 ; i--) {
			System.out.printf("%d ",i);
		}
	}
	
	/* 중첩 반복문 */
	
	// 12345
	// 12345
	// 12345
	// 12345
	// 12345
	public void ex6() {

		for (int x = 1 ; x <= 5 ; x++) {
			for (int i = 1 ; i <=5 ; i++) {
				System.out.print(i);
			}
			System.out.println();
		}	
	}
	
	// 54321 아래로 4회 반복
	public void ex7() {
		
		for (int x = 1 ; x <= 4 ; x++) {
			for (int i = 5 ; i > 0 ; i--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	// (0, 0) (0, 1) (0, 2)
	// (1, 0) (1, 1) (1, 2)
	
	public void ex8() {
		
		// () 내부 첫 번째 칸의 값 0 1
		for (int x = 0 ; x <= 1 ; x++) {
			
			// () 내부 두 번재 칸의 값 0 1 2
			for (int i = 0 ; i <= 2 ; i++) {
				System.out.printf("(%d, %d) ", x, i);
			}
			System.out.println(); // 개행
		}
		
	}
	
	// 2단부터 9단까지 모두 출력하기
	public void ex9() {
	
		for (int x = 2 ; x <= 9 ; x++) {
			for (int i = 1 ; i <= 9 ; i++) {
				System.out.printf("%d X %d = %d\n", x, i, x * i);
			}
			System.out.println("---------------------");
		}
	}
	
	// 구구단 거꾸로 출력하기
	// [9단]
	// 9 x 1 = 9
	// 9 x 2 = 18
	// 9 x 3 = 27
	// ...
	// ---------------
	// [8단]
	// 8 x 1 = 8
	// 8 x 2 = 16
	// ...
	public void ex10() {
	
		for (int x = 9 ; x >= 2 ; x--) {
			System.out.printf("[%d단]\n", x);
			
			for (int i = 1 ; i <= 9 ; i++) {
				System.out.printf("%d X %d = %d\n", x, i, x * i);
			}
			System.out.println("---------------------");
		}
	}
	
	// 구구단 출력하기
	// 조건
	// -1 입력 시 2 ~ 9 순서로 출력
	// -2 입력 시 9 ~ 2 순서로 출력
	// -1, -2가 아니면 "잘못 입력 하셨습니다" 출력
	public void ex11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1) 2~9 순서대로 / 2) 9~2 역순으로 : ");
		int input = sc.nextInt();
		System.out.println("----------------");
//		if (input == 1) { // 2~9 출력
//			for (int x = 2 ; x <= 9 ; x++) {
//				System.out.printf("[%d단]\n", x);
//				for (int i = 1 ; i <= 9 ; i++) {
//					System.out.printf("%d x %d = %d\n", x, i, x * i);
//				}
//				System.out.println("----------------");
//			}
//		} else if (input == 2) { // 9~2 출력
//			for (int x = 9 ; x >= 2 ; x--) {
//				System.out.printf("[%d단]\n", x);
//				for (int i = 1 ; i <= 9 ; i++) {
//					System.out.printf("%d x %d = %d\n", x, i, x * i);
//				}
//				System.out.println("----------------");
//			}
//		} else {
//			System.out.println("잘못 입력 하셨습니다");
//		}
	
		switch (input) {
		case 1 : for (int x = 2 ; x <= 9 ; x++) {
			System.out.printf("[%d단]\n", x);
			for (int i = 1 ; i <= 9 ; i++) {
				System.out.printf("%d x %d = %d\n", x, i, x * i);
			}
			System.out.println("----------------");} break;
		case 2 : for (int x = 9 ; x >= 2 ; x--) {
			System.out.printf("[%d단]\n", x);
			for (int i = 1 ; i <= 9 ; i++) {
				System.out.printf("%d x %d = %d\n", x, i, x * i);
			}
			System.out.println("----------------");} break;
		default : System.out.println("잘못 입력 하셨습니다");
		}
	}
	
	/* count 변수 이용하기 */
	
	// 1 2 3
	// 4 5 6
	// 7 8 9
	public void ex12() {
		
		int count = 0; // 안 쪽 for문이 반복할 때 마다 1씩 카운트
		
		// 1행, 2행, 3행
		for (int row = 1 ; row <= 3 ; row++) {
			
			// 1열, 2열, 3열
			for(int column = 1 ; column <= 3 ; column++) {
				count++;
				System.out.print(count + " ");
			}
			System.out.println();
		}
	}
	
	// 1 2 3 4
	// 5 6 7 8
	// 9 10 11 12
	public void ex13() { // 이중 for문 사용
		
		int count = 0;
		
		for (int row = 1 ; row <= 3 ; row++) {
			for (int col = 1 ; col <= 4 ; col++) {
				 count += 1;
				System.out.printf("%d ", count);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		
		// 단일 for문
		for (int i = 1 ; i <= 12 ; i++) {
			System.out.print(i + " ");
			
			if (i % 4 == 0) {
				System.out.println(); // 개행
			}
		}
	}
	
	// 행/열의 크기를 입력 받아 출력하기
	public void ex14() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행 : ");
		int row = sc.nextInt();
		System.out.print("열 : ");
		int col = sc.nextInt();
		
		int count = 0;
		
		// 초기식, 조건식, 증감식은 상황에 따라서
		// 늘어나거나 작성하지 않을 수 있다
		
		// for(  ;  ;  ) --> 무한루프 (조건문이 없어서 false가 발생하지 않음)
		
		// 초기식 작성 대신 row, col(입력 받은 값) 사용
		for (int x = row ; x >= 1 ; x--) {
			for (int y = col ; y >= 1 ; y--) {
				
				// ++count : 전위연산 -> 먼저 count 1 증가
				System.out.print(++count + " ");
			}
			System.out.println();
		}
	}
	
	// 1
	// 12
	// 123
	// 1234
	
	// -> 행이 증가할 때마다
	//    열이 같은 수로 증가
	public void ex15() {
		
		for (int i = 1 ; i <= 4 ; i++) {
			for (int i2 = 1 ; i2 <= i ; i2++) {
				System.out.print(i2 + " ");
			}
			System.out.println();
		}
	}
	
	public void ex16() {
		
		for (int i = 4 ; i >= 1 ; i--) {
			for (int i2 = 1 ; i2 <= i ; i2++) {
				System.out.print(i2 + " ");
			}
		System.out.println();
		}
	}
	
	// 4 3 2 1 
	// 3 2 1 
	// 2 1 
	// 1
	public void ex17() {
		
		for (int i = 1 ; i <= 4 ; i++) {
			for (int i2 = 4 ; i2 >= i ; i2--) {
				System.out.print(i2 + " ");
			}
		System.out.println();
		}
	}
	
	// 4
	// 4 3 
	// 4 3 2
	// 4 3 2 1
	public void ex18() {
		
		for (int i = 4 ; i >= 1 ; i--) {
			for (int i2 = 4 ; i2 >= i ; i2--) {
				System.out.print(i2 + " ");
			}
			System.out.println();
		}
	}
}