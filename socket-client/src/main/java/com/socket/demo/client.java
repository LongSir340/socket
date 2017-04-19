package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class client {

	public static void main(String[] args) throws IOException {
		try {
			Socket server = new Socket(InetAddress.getLocalHost(), 8888);
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter out = new PrintWriter(server.getOutputStream());
			BufferedReader userin = new BufferedReader(new InputStreamReader(System.in));

			new SendThread(out, userin, false).start();
			new ReceiveTread(in, out, userin, server).start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
