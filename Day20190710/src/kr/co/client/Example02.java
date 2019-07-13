package kr.co.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Example02 {
	public static void main(String[] args) {
		try {
//			1.서버의 IP와 서버의 포트 값을 인자로 넣어 Socket 생성
			Socket sock = new Socket("192.168.0.10",10002);
//			Socket sock = new Socket("127.0.0.1",10008);
			Scanner scan = new Scanner(System.in);
//			2.생성된 Socket으로부터 inputStream과 outputStream을 구현
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
//			3.InputStream과 OutputStream 방식 전환
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			System.out.println("입력시작");
//			5.키보드로부터 한줄 입력 받음 이후 서버로 전송
			while(true) {
				line = scan.nextLine();
				if(line.equals("quit")) break;
				pw.println(line);
				pw.flush();
			}
//			6.서버로부터 문자열을 받아 출력
			String echo = br.readLine();
			System.out.println("서버로부터 받은 문자열: "+echo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
