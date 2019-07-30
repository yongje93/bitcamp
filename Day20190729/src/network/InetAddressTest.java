package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress naver = InetAddress.getByName("www.naver.com"); // InetAddress는 new 해서 생성 못함.
		System.out.println("NAVER IP : " + naver.getHostAddress());
		System.out.println();

		InetAddress local = InetAddress.getLocalHost();
		System.out.println("loaclhost IP : " + local.getHostAddress());
		System.out.println();

		InetAddress[] ar = InetAddress.getAllByName("www.daum.net");
		for (InetAddress data : ar) {
			System.out.println("Daum IP : " + data.getHostAddress());
		}
	}

}
