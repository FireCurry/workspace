package edu.kh.thread.ex4;

import java.util.Random;

public class RaceStar implements Runnable {

	@Override
	public void run() {
		
		Random ran = new Random();
		
		try {

			for (int i = 0 ; i <= 10 ; i++) {
				
				RaceRun.clear(); // 콘솔창 클리어
				
				if (i == 0) { // 첫 반복 시
					System.out.println("시작");
					System.out.println("♡");
					System.out.print("★");
					
					Thread.sleep(1000);
					continue; // 다음 반복으로 이동
				}
				
				// i가 1~10인 경우
				System.out.println(i + "회차");
				
				// temp, tmp == 임시 변수
				int temp = ran.nextInt(5) + 1; // 1, 2, 3, 4, 5 중 하나의 난수 발생
				
				// 생성된 난수를 starCount에 누적
				RaceRun.starCount += temp;
				
				// "★ (난수)칸 이동" 출력
				System.out.println("★ " + temp + "칸 이동");
				
				// heartCount 누적된 숫자 만큼 표시
				for (int h = 0 ; h < RaceRun.heartCount ; h++) {
					System.out.print("-");
				}
				System.out.println("♡");
				
				// starCount만큼 - 표시 후 ★ 출력
				for (int s = 0 ; s < RaceRun.starCount ; s++) {
					System.out.print("-");
				}
				System.out.print("★");
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
