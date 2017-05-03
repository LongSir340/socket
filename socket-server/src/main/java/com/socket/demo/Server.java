package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.socket.demo.ReceiveTread;
import com.socket.demo.SendThread;
public class Server {

	public static void main(String[] args) throws IOException {
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			BufferedReader userin = new BufferedReader(new InputStreamReader(System.in));

			new ReceiveTread(in, server, out, userin, client).start();
			new SendThread(out, userin, true).start();  
		} catch (IOException e) {  
			e.printStackTrace();
		}
	}
}
