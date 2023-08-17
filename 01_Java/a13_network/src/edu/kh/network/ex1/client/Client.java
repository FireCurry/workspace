package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Client(고객) : 서버가 제공하는 서비스를 요청해서 제공 받는 컴퓨터

public class Client {

	public void start() {
		
		// 1. 서버의 IP 주소와
		// 	  서버가 정한 포트 번호를 이용해서
		// 	  서버와 연결하는 소켓 객체 생성
		
		String ip = "192.168.10.19"; // 127.0.0.1 -> loop back ip(현재 컴퓨터 나타내는 IP)
		int port = 8500; // 서버에서 지정한 포트 번호
		
		Socket socket = null; // 클라이언트 - 서버 연결
		InputStream is = null; // 클라이언트 <- 서버 스트림
		OutputStream os = null; // 클라이언트 -> 서버 스트림

		// 성능 향상용 보조 스트림
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			System.out.println("[Client 입니다]");
			
			// 127.0.0.1:8500 (서버 프로그램)과 연결되는 소켓 생성
			// -> 소켓이 생성됨과 동시에 서버로 연결 요청
			// -> ip, port 번호가 잘못 작성되거나, 연결 거부되면
			//	  UnknownHostException 발생
			socket = new Socket(ip, port);
			
			if (socket != null) { // 서버와 연결이 성공한 경우
				
				// 2. 서버와 입출력 스트림 생성(소켓에서 얻어옴)
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				// 3. 보조 스트림을 이용해 성능 개선
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				// 4. 스트림을 통해서 입출력
				
				// 4-1) 서버 -> 클라이언트로 전달된 메시지를 화면에 출력
				String serverMessage = br.readLine();
				System.out.println(serverMessage);
				
				// 4-2) 클라이언트 -> 서버로 입력 받은 메시지 출력
				Scanner sc = new Scanner(System.in);
				
				System.out.print("서버로 전달할 메시지 : ");
				String clientMessage = sc.nextLine();
				
				pw.println(clientMessage); // 서버로 메시지 출력
				pw.flush(); // 스트림에 있는 메시지 밀어내기
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 메모리 누수 관리
			try {
				
				if (pw != null) pw.close();
				if (br != null) br.close();
				
				if (socket != null) socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
