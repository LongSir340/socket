package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveTread extends Thread {
	BufferedReader in;
	ServerSocket server;
	PrintWriter out;
	BufferedReader userin;
	Socket client;

	public ReceiveTread(BufferedReader in, ServerSocket server, PrintWriter out, BufferedReader userin, Socket client) {
		super();
		this.in = in;
		this.server = server;
		this.out = out;
		this.userin = userin;
		this.client = client;
	}

	public ReceiveTread(BufferedReader in, PrintWriter out, BufferedReader userin, Socket client) {
		super();
		this.in = in;
		this.out = out;
		this.userin = userin;
		this.client = client;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String info = in.readLine();
				while (info != null) {
					System.out.println(info);
					info = in.readLine();
				}
				if (in.readLine().equals("end")) {
					break;
				}
			}
			in.close();
			out.close();
			userin.close();
			if (client != null) {
				client.close();
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
