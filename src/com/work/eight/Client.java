package com.work.eight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args){
		try {
			Socket socket = new Socket("127.0.0.1", 8080);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			//DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
			String str = kReader.readLine();
			while(!str.equals("stop")){
				printWriter.println(str);
				printWriter.flush();
				str = kReader.readLine();
			}
			kReader.close();
			printWriter.close();
			socket.close();
		} catch (Exception e) {
		}
	}
}
