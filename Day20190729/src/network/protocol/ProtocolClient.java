package network.protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//프로토콜 클라이언트.
public class ProtocolClient {
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private BufferedReader keyboard; // 키보드 입력

	public ProtocolClient() {
		try {
			socket = new Socket("192.168.0.46", 9500); // 서버IP, 9500(포트번호)

			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 소켓을 통해 들어오는.
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드를 통해 들어오는
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}

		String msg = null;	//보내는거
		String line = null;	//읽는거
		
		while (true) { // 대화
			try {
				// 서버에게 보내는 쪽
				msg = keyboard.readLine(); // 키보드로부터 한줄 읽어들임.

				bw.write(msg + "\n"); // 서버로 보내기.(enter값이 없음. + "\n" 해줘야됨.)
				bw.flush(); // 버퍼 비우기. 그래야 다음 버퍼가 들어옴.

				// 서버에게 받는 쪽
				line = br.readLine();
				System.out.println(line);
				
				String[] ar = msg.split(":");
				if(Protocol.EXIT.equals(ar[0])) {
					br.close();
					bw.close();
					socket.close();
					keyboard.close();
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	}

	public static void main(String[] args) {
		new ProtocolClient();
	}
}
