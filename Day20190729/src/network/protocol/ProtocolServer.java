package network.protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//서버 실행
//ServerSocket  1. 클라이언트가 접근해오길 기다린다.
//				2. 클라이언트와 연결할 소켓을 생성한다. - accept()
public class ProtocolServer {
	private ServerSocket ss;
	private BufferedReader br;
	private BufferedWriter bw;
	private Socket socket;

	public ProtocolServer() {
		try {
			ss = new ServerSocket(9500); // 서버소켓 생성(포트 9500번)
			System.out.println("서버준비완료");

			socket = ss.accept(); // 클라이언트가 접근을 했을 때. accept를 통해 낚아채고 socket 생성.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 소켓을 통해 들어오는.
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}

		String line;

		while (true) {
			try {
				// 클라이언트에게 받는 쪽 "100:angel"
				line = br.readLine();

				// 클라이언트로 보내는 쪽 "angel님 입장"
				String[] ar = line.split(":");

				if (Protocol.ENTER.equals(ar[0])) {
					bw.write(ar[1] + "님 입장...\n");
					bw.flush(); // 버퍼 비우기.
				} else if (Protocol.EXIT.equals(ar[0])) {
					bw.write(ar[1] + "님 퇴장...\n");
					bw.flush(); // 버퍼비우기.
					// 모든것을 close하고 종료.
					br.close();
					bw.close();
					socket.close();

					System.exit(0);
				} else if (Protocol.SEND_MESSAGE.equals(ar[0])) {
					bw.write("[" + ar[1] + "]" + ar[2] + "\n");
					bw.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		} // while
	}

	public static void main(String[] args) {
		new ProtocolServer();
	}
}
