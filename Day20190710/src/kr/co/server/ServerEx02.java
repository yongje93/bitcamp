package kr.co.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerEx02 {
	
	List<SocketThread> list = new ArrayList<SocketThread>();
	
	public ServerEx02() {
		try {
			ServerSocket server = new ServerSocket(10008);
			while(true) {
				Socket sock = server.accept();
				InetAddress inetaddr = sock.getInetAddress();
				System.out.println(inetaddr.getHostAddress()+"로부터 접속했습니다.");	
				SocketThread st = new SocketThread(sock);
				list.add(st);
				st.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerEx02();
	}
}
