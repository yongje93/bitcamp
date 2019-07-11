package kr.co.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		try {
//			1.Serversocket 생성
			ServerSocket server = new ServerSocket(10008);
			System.out.println("Waiting Connection...");
//			2.Serversocket의 accept() 메소드를 통해 클라이언트 접속을 대기
//			클라이언트가 접속할 경우 accept() 메소드는 Socket을 리턴
			Socket sock = server.accept();
			InetAddress inetAddress = sock.getInetAddress();
			System.out.println(inetAddress.getHostAddress()+" 로부터 접속했습니다.");
//			3.반환받은 Socket으로부터 inputStream outputStream을 구현
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
//			4. readline 메소드를 이용해서 클라이언트가 보내는 문자열을 한줄 읽어들여 출력
			while((line = br.readLine())!=null) {
				System.out.println("클라이언트로부터 전달받은 문자열: "+line);
//				5.클라이언트 쪽으로 문자열 전송
				pw.println(":D");
				pw.flush();
			}
			pw.close();
			br.close();
			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
