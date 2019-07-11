package kr.co.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketThread extends Thread {
	Socket sock;

	public SocketThread(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run() {
		try {
			InetAddress inetAddress = sock.getInetAddress();
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while(true) {
				line = br.readLine();
				if(line!=null) {
					System.out.println(inetAddress.getHostAddress()+" : "+line);					
				}
				
			}
//			pw.close();
//			br.close();
//			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
