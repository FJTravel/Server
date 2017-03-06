package edu.fjnu.fujiantravel.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1314);
			Socket socket = null;
			System.out.println("服务器开启！");
			while (true) {
				socket = server.accept();
				System.out.println(socket.getInetAddress().getHostAddress() + ":请求连接");
				Thread thread = new Thread(new ServerThread(socket));
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
