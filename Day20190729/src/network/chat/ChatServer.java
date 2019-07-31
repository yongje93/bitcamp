package network.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	private ServerSocket ss;
	private ArrayList<ChatHandler> list;
	
	public ChatServer() {
		try {
			ss = new ServerSocket(9500);
			System.out.println("서버준비완료");
			
			list = new ArrayList<ChatHandler>();
			
			while(true) {	//accept를 계속 하기위해서
				Socket socket = ss.accept();	// 낚아채서 소캣만들고
				ChatHandler handler = new ChatHandler(socket, list); // 스레드 생성	// handler에 소켓과 리스트를 보내야됨. 리스트를 알아야 몇개의 클라이언트와 연결 되어있는지 안다.
				handler.start(); // 스레드 시작
				
				list.add(handler);
			}//while
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
