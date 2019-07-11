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
//			1.Serversocket ����
			ServerSocket server = new ServerSocket(10008);
			System.out.println("Waiting Connection...");
//			2.Serversocket�� accept() �޼ҵ带 ���� Ŭ���̾�Ʈ ������ ���
//			Ŭ���̾�Ʈ�� ������ ��� accept() �޼ҵ�� Socket�� ����
			Socket sock = server.accept();
			InetAddress inetAddress = sock.getInetAddress();
			System.out.println(inetAddress.getHostAddress()+" �κ��� �����߽��ϴ�.");
//			3.��ȯ���� Socket���κ��� inputStream outputStream�� ����
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
//			4. readline �޼ҵ带 �̿��ؼ� Ŭ���̾�Ʈ�� ������ ���ڿ��� ���� �о�鿩 ���
			while((line = br.readLine())!=null) {
				System.out.println("Ŭ���̾�Ʈ�κ��� ���޹��� ���ڿ�: "+line);
//				5.Ŭ���̾�Ʈ ������ ���ڿ� ����
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
