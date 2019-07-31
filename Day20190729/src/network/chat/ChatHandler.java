package network.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ChatHandler extends Thread {
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket; // 서버로부터 넘겨 받는 소켓
	private ArrayList<ChatHandler> list; // 서버로부터 넘겨 받는 핸들러 리스트

	public ChatHandler(Socket socket, ArrayList<ChatHandler> list) throws IOException {
		this.socket = socket;
		this.list = list;

		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));		
	}

	@Override
	public void run() {
		try {
			String nickName = null;
			nickName = br.readLine();
			broadcast(nickName + "님이 입장하였습니다.");
			
			String line = null;
			while(true) {
				line = br.readLine();
				if (line == null || line.toLowerCase().equals("exit")) {
					break;
				}
				broadcast("[" + nickName + "]" + line);
			}//while
			
			pw.println("exit");	//클라이언트에게 exit 보내줌.
			pw.flush();
			
			list.remove(this);	//핸들러 리스트에서 내 정보를 제거.
			broadcast(nickName + "님이 퇴장하였습니다.");
			
			br.close();
			pw.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcast(String msg) { // 모든 클라이언트에게 보내야 될 내용
		for (ChatHandler handler : list) {
			handler.pw.println(msg); // 각각의 클라이언트들에게 써줄려고
			handler.pw.flush();
		}
	}
}
