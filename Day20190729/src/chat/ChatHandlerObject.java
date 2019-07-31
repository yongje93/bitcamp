package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ChatHandlerObject extends Thread {
	private ArrayList<ChatHandlerObject> list;
	private Socket socket; // 서버로부터 넘겨 받는 소켓
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ChatHandlerObject(Socket socket, ArrayList<ChatHandlerObject> list) {
		this.socket = socket;
		this.list = list;
		// ois, oos 생성
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// 클라이언트에게 받음
		String nickName = null;
		String message = null;
		
		try {
			while(true) {
				InfoDTO dto = (InfoDTO) ois.readObject();
				if( dto.getCommand() == Info.JOIN ) {
					nickName = dto.getNickName();
					dto.setMessage(nickName + "님이 입장하였습니다");
					broadcast(dto);
				} else if( dto.getCommand() == Info.SEND ) {
					message = dto.getMessage();
					dto.setMessage("[" + nickName + "]" + message);
					broadcast(dto);
				} else if( dto.getCommand() == Info.EXIT ) {
					dto.setCommand(Info.EXIT);
					dto.setMessage(nickName + "님이 퇴장하였습니다");
					broadcast(dto);
					list.remove(this);
					
					ois.close();
					oos.close();
					socket.close();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void broadcast(InfoDTO dto) { // 모든 클라이언트들에게 전송
		for (ChatHandlerObject handler : list) {
			try {
				handler.oos.writeObject(dto);
				handler.oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
