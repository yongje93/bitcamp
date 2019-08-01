package network.chat.hw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ChatHandlerObject extends Thread {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket; // 서버로부터 넘겨 받는 소켓
	private ArrayList<ChatHandlerObject> list; // 서버로부터 넘겨 받는 핸들러 리스트

	public ChatHandlerObject(Socket socket, ArrayList<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;

		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		String nickName = null;
		String line = null;
		InfoDTO dto = null;
		try {
			while (true) {
				dto = (InfoDTO) ois.readObject();
				if (dto.getCommand() == Info.JOIN) {
					nickName = dto.getNickName();
					dto.setMessage(nickName + "님이 입장하였습니다.");
					broadcast(dto);
				} else if (dto.getCommand() == Info.SEND) {
					line = dto.getMessage();
					dto.setMessage("[" + nickName + "]" + line);
					broadcast(dto);
				} else if (dto.getCommand() == Info.EXIT) {
					dto.setCommand(Info.EXIT);
					dto.setMessage(nickName + "님이 퇴장하였습니다.");
					broadcast(dto);
					list.remove(this);
					break;
				}
			} // while
			ois.close();
			oos.close();
			socket.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcast(InfoDTO dto) throws IOException { // 모든 클라이언트에게 보내야 될 내용
		for (ChatHandlerObject handler : list) {
			handler.oos.writeObject(dto);
			handler.oos.flush();
		}
	}
}
