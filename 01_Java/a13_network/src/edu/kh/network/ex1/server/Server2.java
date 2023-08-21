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
		int port = 9999;
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
			
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			pw.println("Hi");
			pw.flush();
			
			System.out.println(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) pw.close();
				if (br != null) br.close();
				if (clientSocket != null) clientSocket.close();
				if (serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}