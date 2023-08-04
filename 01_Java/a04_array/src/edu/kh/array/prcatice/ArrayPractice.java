package edu.kh.array.prcatice;

import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
			if(i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}
	
	public void practice2() {
		
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = 9-i;
			System.out.print(arr[i] + " ");
			
			if(i % 2 != 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
		
	}
	
	public void practice3() {
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice4() {
		System.out.print("입력 0 : ");
		int input0 = sc.nextInt();
		System.out.print("입력 1 : ");
		int input1 = sc.nextInt();
		System.out.print("입력 2 : ");
		int input2 = sc.nextInt();
		System.out.print("입력 3 : ");
		int input3 = sc.nextInt();
		System.out.print("입력 4 : ");
		int input4 = sc.nextInt();
		int[] arr = {input0, input1, input2, input3, input4};
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		boolean flag = true;
		
		for (int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == search) {
				System.out.println("인덱스 : " + i);
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		if (flag == false) {
			System.out.println("일치하는 값이 존재하지 않습니다");
		}
	}
	
	public void practice5() {
		System.out.print("문자열 : ");
		String word = sc.next();
		System.out.print("문자 : ");
		char spell = sc.next().charAt(0);
		int length = word.length();
		int sum = 0;
		System.out.print("application에 i가 존재하는 위치(인덱스) : ");
		for (int i = 0 ; i < length ; i++) {
			if ( spell == word.charAt(i)) {
				System.out.print(i + " ");
				sum += 1;
			}
		}
		System.out.println();
		System.out.println("i 개수 : " + sum);
		
		
	}
	
	public void practice6() {
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		
		for(int i=0; i<input; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			int num = sc.nextInt();
			arr[i]=num;
		}
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println();
		System.out.println("총 합 : " + sum);
	}
	
	public void practice7() {
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.next();
		
		char[] arr = new char[input.length()];
		for (int i = 0; i < arr.length; i++) {
			if (i<8) {
				arr[i] = input.charAt(i);
			} else {
				arr[i] = '*';
			}
		}
		for (char a : arr) {
			System.out.print(a);
		}
		
	}
	
	public void practice8() {
		do {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if (input % 2 == 0 || input < 3) {
				System.out.println("다시 입력하세요.");
			} else {
				int[] arr = new int[input];
				int sum = 0;
				for (int i = 0 ; i < input ; i++) {
					if(i <= input/2) {
						sum += 1;
						arr[i] = sum;
					} else {
						sum -= 1;
						arr[i] = sum;
					}
				}
				for (int i=0; i<arr.length ;i++) {
					System.out.print(arr[i] + " ");
				}
				break;
			}
		} while (true);
	}
	
	public void practice9() {
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		for (int i=0; i<arr.length; i++) {
			arr[i] = ((int)(Math.random()*10 + 1));
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice10() {
		int[] arr = new int[10];
		
		System.out.print("발생한 난수 : ");
		for (int i=0; i<arr.length; i++) {
			arr[i] = ((int)(Math.random()*10 + 1));
			System.out.print(arr[i] + " ");
		}
		int max = arr[0];
		int min = arr[0];
		for (int i=0; i<arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
			}
			if (arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.println();
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}
	
	public void practice11() {
		int[] arr = new int[10];
		
	}
	
	public void practice12() {
		
	}
	
	public void practice13() {
		
	}
	
	public void practice14() {
		
	}
	
	public void practice15() {
		
	}
	
	public void practice16() {
		
	}
	
	public void practice17() {
		
	}
	
	public void practice18() {
		
	}
	
	public void practice19() {
		
	}
	
	public void practice20() {
		
	}
	
	public void practice21() {
		
	}
	
	public void practice22() {
		
	}
	
	public void practice23() {
		
	}
	
	public void practice24() {
		
	}
	
	public void practice25() {
		
	}
	
}
