package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

	public void start() {
		Scanner sc = new Scanner(System.in);
		
		String ip = "127.0.0.1";
		int port = 7777;
		
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			socket = new Socket(ip, port);
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			String message = br.readLine();
			System.out.println(message);
			
			String reply = sc.nextLine();
			
			pw.println(reply);
			pw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
