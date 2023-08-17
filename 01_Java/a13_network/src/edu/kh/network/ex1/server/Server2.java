package edu.kh.network.ex1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public void start() {
		int port = 7777;
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("<서버 생성 완료>");
			System.out.println("클라이언트를 기다리는 중입니다...");
			clientSocket = serverSocket.accept();
			
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			System.out.println("클라이언트가 접속했습니다");
			String message = "서버에 접속되었습니다";
			
			pw.println(message);
			pw.flush();
			
			System.out.println(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (br != null) br.close();
				if (pw != null) pw.close();
				if (clientSocket != null) clientSocket.close();
				if (serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
