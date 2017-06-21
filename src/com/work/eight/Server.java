package com.work.eight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			Socket socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String str = reader.readLine();
			while(str!=null){
				System.out.println("Client:"+str);
				str = reader.readLine();
			}
			reader.close();
			socket.close();
		} catch (Exception e) {
		}
	}
}
