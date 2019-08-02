package network.chat.hw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ChatHandlerObject extends Thread {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	private ArrayList<ChatHandlerObject> list;

	public ChatHandlerObject(Socket socket, ArrayList<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public void run(){
		try{
			InfoDTO dto = null; //받는쪽
			String nickName = null;
			
			while(true){
				dto = (InfoDTO)ois.readObject();

				if(dto.getCommand()==Info.JOIN){
					nickName = dto.getNickName();

					//모든 클라이언트 입장 메세지 보내기
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"님이 입장하였습니다");
					broadcast(sendDTO);

				}else if(dto.getCommand()==Info.EXIT){
					//나를 제외한 나머지 클라이언트에게 퇴장메세지 보내기
					list.remove(this);

					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"님이 퇴장하였습니다");
					broadcast(sendDTO);

					//나한테는 exit를 보내기
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();

					ois.close();
					oos.close();
					socket.close();

					break;

				}else if(dto.getCommand()==Info.SEND){
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("["+nickName+"] "+dto.getMessage());
					broadcast(sendDTO);
				}			
			}//while

		}catch(IOException io){
			io.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void broadcast(InfoDTO sendDTO){
		for(ChatHandlerObject handler : list){
			try{
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			}catch(IOException io){
				io.printStackTrace();
			}
		}//for
	}
}
