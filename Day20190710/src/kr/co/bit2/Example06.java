package kr.co.bit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example06 {
	public static void main(String[] args) {
		try {
			InetAddress iaddr = InetAddress.getLocalHost();
			System.out.println("호스트 이름: "+iaddr.getHostName());
			System.out.println("호스트 주소: "+iaddr.getHostAddress());
			System.out.println();
			iaddr = InetAddress.getByName("www.daum.net");
			System.out.println("호스트 이름: "+iaddr.getHostName());
			System.out.println("호스트 주소: "+iaddr.getHostAddress());
			System.out.println();
			InetAddress[] sw = InetAddress.getAllByName("www.daum.net");
			for (InetAddress sw_temp : sw) {
				System.out.println("호스트 이름: "+sw_temp.getHostName());
				System.out.println("호스트 주소: "+sw_temp.getHostAddress());				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
