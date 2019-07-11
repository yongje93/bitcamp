package kr.co.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Example01 {
	public static void main(String[] args) {
		try {
//			1.������ IP�� ������ ��Ʈ ���� ���ڷ� �־� Socket ����
			Socket sock = new Socket("192.168.0.10",10002);
//			Socket sock = new Socket("127.0.0.1",10008);
			Scanner scan = new Scanner(System.in);
//			2.������ Socket���κ��� inputStream�� outputStream�� ����
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
//			3.InputStream�� OutputStream ��� ��ȯ
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			System.out.println("�Է½���");
//			5.Ű����κ��� ���� �Է� ���� ���� ������ ����
			line = scan.nextLine();
			pw.println(line);
			pw.flush();
//			6.�����κ��� ���ڿ��� �޾� ���
			String echo = br.readLine();
			System.out.println("�����κ��� ���� ���ڿ�: "+echo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
