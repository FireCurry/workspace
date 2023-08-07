package edu.kh.array.prcatice;

import java.util.Arrays;
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
		boolean flag = true;
		
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*10 + 1);
			do {
				for (int i2 = 0 ; i2 < i ; i2++) {
					if (arr[i] == arr[i2]) {
						flag = false;
					}
				}
				if (flag == false) {
					arr[i] = (int)(Math.random()*10 + 1);
					flag = true;
					continue;
				}
				if (flag == true) {
					break;
				}
			} while (true);
		}
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() {
		int[] arr = new int[6];
		boolean flag = true;
		int blank = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*45 + 1);
			do {
				for (int i2 = 0 ; i2 < i ; i2++) {
					if (arr[i] == arr[i2]) {
						flag = false;
					}
				}
				if (flag == false) {
					arr[i] = (int)(Math.random()*10 + 1);
					flag = true;
					continue;
				}
				if (flag == true) {
					break;
				}
			} while (true);
		}
		do{
			flag = true;
			for(int i = 0 ; i < arr.length -1 ; i++) {
				if(arr[i]>arr[i+1])	{
					blank = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = blank;
					blank = 0;
					flag = false;
					continue;
				}
			}
			if (flag == true) {
				break;
			}
		} while(true);
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
			
		}
		
	}
	
	public void practice13() {
		System.out.print("문자열 : ");
		String input = sc.next();
		int length = input.length();
		char[] arr = new char[length];
		int count = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = input.charAt(i);
		}
		for (int i=0 ; i<arr.length ; i++) {
			for (int i2=0 ; i2<i ; i2++) {
				if (arr[i] == arr[i2]) {
					arr[i] = 0;
					count += 1;
					break;
				}
			}
		}
		System.out.print("문자열에 있는 문자 : " + arr[0]);
		for (int i=1 ; i<arr.length ; i++) {
			if (arr[i]!=0) {
				System.out.print(", " + arr[i]);
			}
		}
		System.out.println("\n문자 개수 : " + (length - count));
	}
	
	public void practice14() {
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[size];
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(1+ i +"번째 문자열 : ");
			arr[i] = sc.nextLine();
		}
		do {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char yn = sc.next().charAt(0);
			if (yn == 'y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				int num = sc.nextInt();
				sc.nextLine();
				size += num;
				String[] arr2 = new String[size];
				arr2 = Arrays.copyOf(arr, arr2.length);
				for(int i = size - num ; i < arr2.length ; i++) {
					System.out.print(i+1 +"번째 문자열 : ");
					arr2[i] = sc.nextLine();
				}
				arr = arr2;
			} else {
				break;
			}
		} while (true);
		System.out.print("[" + arr[0]);
		for (int i = 1 ; i < arr.length ; i++) {
			System.out.print(" ," + arr[i]);
		}
		System.out.println("]");
	}
	
	public void practice15() {
		String [][] arr = new String [3][3];
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr.length ; i2++) {
				arr[i][i2] = String.format("(%d, %d)",i,i2);
				System.out.print(arr[i][i2]);
			}
			System.out.println();
		}
	}
	
	public void practice16() {
		
		int[][] arr = new int[4][4];
		int sum = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			for(int i2 = 0 ; i2 < arr.length ; i2++) {
				sum += 1;
				arr[i][i2] = sum;
				System.out.printf("%2d ", arr[i][i2]);
			}
			System.out.println();
		}
	}
	
	public void practice17() {
		int[][] arr = new int[4][4];
		int sum = 16;
		for(int i = 0 ; i < arr.length ; i++) {
			for(int i2 = 0 ; i2 < arr.length ; i2++) {
				arr[i][i2] = sum;
				sum -= 1;
				System.out.printf("%2d ", arr[i][i2]);
			}
			System.out.println();
		}
	}
	
	public void practice18() {
		int[][] arr = new int[4][4];
		int[] sumrow = new int[3];
		int[] sumcol = new int[3];
		for (int i = 0 ; i < arr.length-1 ; i++) {
			for (int i2 = 0 ; i2 < arr.length-1 ; i2++) {
						arr[i][i2] = (int)(Math.random()*10 + 1);
			}
		}
		for (int i = 0 ; i < arr.length-1 ; i++) {
			for (int i2 = 0 ; i2 < arr.length-1 ; i2++) {
				sumrow[i] += arr[i][i2];
				sumcol[i] += arr[i2][i];
			}
		}
		for (int i = 0 ; i < arr.length-1 ; i++) {
				arr[i][arr.length-1] = sumrow[i];
				arr[arr.length-1][i] = sumcol[i];
		}
		int sum = 0;
		for (int i = 0 ; i < arr.length-1 ; i++) {
			sum += sumrow[i];
		}
		arr[3][3] = sum;
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr.length ; i2++) {
				System.out.printf("%2d ",arr[i][i2]);
			}
			System.out.println();
		}
	}
	
	public void practice19() {
		do{
			System.out.print("행 크기 : ");
			int row = sc.nextInt();
			System.out.print("열 크기 : ");
			int col = sc.nextInt();
			if (row < 1 || row >10 || col < 1 || col > 10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");;
				continue;
			}
			int[][] arr = new int[row][col];
			for (int i = 0 ; i < arr.length ; i++) {
				for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
					arr[i][i2] = (int)(Math.random()*26 + 65);
					System.out.print((char)arr[i][i2] + " ");
				}
				System.out.println();
			} break;
		} while (true);
	}
	
	public void practice20() {
		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		int[][] arr = new int[row][];
		for (int i=0 ; i < arr.length ; i++) {
			System.out.printf("%d열의 크기 : ", i);
			arr[i] = new int [sc.nextInt()];
		}
		int sum = 97;
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
				arr[i][i2] = sum;
				sum += 1;
				System.out.print((char)arr[i][i2] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice21() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		int sum = 0;
		
		System.out.println("== 1분단 ==");
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
				arr[i][i2] = students[sum];
				sum += 1;
				System.out.print(arr[i][i2] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
				arr2[i][i2] = students[sum];
				sum += 1;
				System.out.print(arr2[i][i2] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice22() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		int sum = 0;
		
		System.out.println("== 1분단 ==");
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
				arr[i][i2] = students[sum];
				sum += 1;
				System.out.print(arr[i][i2] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
				arr2[i][i2] = students[sum];
				sum += 1;
				System.out.print(arr2[i][i2] + " ");
			}
			System.out.println();
		}
		System.out.println("================================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.next();
		boolean flag = true; // 1분단이면 true
		String side = null;
		int row = 0;
		int col = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
				if(arr[i][i2].equals(name)) {
					row = i;
					col = i2;
					flag = true;
				}
				if(arr2[i][i2].equals(name)) {
					row = i;
					col = i2;
					flag = false;
				}
			}
		}
		if (col % 2 != 0) {
			side = "오른";
		}
		if (col % 2 == 0) {
			side = "왼";
		}
		if (flag == true) {
			System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 %s쪽에 있습니다.", name, row+1, side);
		}
		if (flag == false) {
			System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 %s쪽에 있습니다.", name, row+1, side);
		}
		
	}
	
	public void practice23() {
		String[][] arr = new String[6][6];
		System.out.print("행 인덱스 입력 : ");
		int row = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int col = sc.nextInt();
		for (int i = 0 ; i < arr.length ; i++) {
			for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
				
				if(i==0 && i2>0) {
						arr[i][i2] = String.format(" %d ", i2-1);
						System.out.print(arr[i][i2]);
				} else if(i2==0 && i>0){
						arr[i][i2] = String.format("%d", i-1);
						System.out.print(arr[i][i2]);
				} else {
						arr[i][i2] = "   ";
						arr[0][0] = " ";
						arr[row+1][col+1] = " X ";
						System.out.print(arr[i][i2]);
				}
			}
			System.out.println();
		}
	}
	
	public void practice24() {
		String[][] arr = new String[6][6];
		do{
			System.out.print("행 인덱스 입력 : ");
			int row = sc.nextInt();
			if (row==99) {
				break;
			}
			System.out.print("열 인덱스 입력 : ");
			int col = sc.nextInt();
			for (int i = 0 ; i < arr.length ; i++) {
				for (int i2 = 0 ; i2 < arr[i].length ; i2++) {
					arr[0][0] = " ";
					if(i==0 && i2>0) {
							arr[i][i2] = String.format(" %d ", i2-1);
							System.out.print(arr[i][i2]);
					} else if(i2==0 && i>0){
							arr[i][i2] = String.format("%d", i-1);
							System.out.print(arr[i][i2]);
					} else {
							arr[row+1][col+1] = " X ";
							if (arr[i][i2] == null) {
								System.out.print("   ");
							} else {
							System.out.print(arr[i][i2]);
							}
					}
				}
				System.out.println();
			}
			System.out.println();
		}while(true);
		System.out.println("프로그램 종료");
	}
	
	public void practice25() {
		
	}
	
}
