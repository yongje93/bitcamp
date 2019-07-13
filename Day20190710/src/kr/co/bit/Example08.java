package kr.co.bit;

import java.nio.ByteBuffer;

public class Example08 {
	public static void main(String[] args) {
		System.out.println("[7바이트 크기 버퍼 생성]");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		buffer.put((byte)10);
		buffer.put((byte)11);
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		buffer.flip();
		printState(buffer);
		
		buffer.get(new byte[3]);
		System.out.println("[3바이트 읽음]");
		printState(buffer);
		
		buffer.compact(); // 현재 포지션을 중심으로 리미트까지 있는 글자를 읽고 처음 위치에서부터 붙여넣는다
		System.out.println("[compact() 실행 후]");
		printState(buffer);
	}
	
	
	public static void printState(ByteBuffer buffer) {
		System.out.print(buffer.get(0)+", ");
		System.out.print(buffer.get(1)+", ");
		System.out.print(buffer.get(2)+", ");
		System.out.print(buffer.get(3)+", ");
		System.out.println(buffer.get(4)+", ");
		System.out.print("\tposition: "+buffer.position()+", ");
		System.out.print("\tlimit: "+buffer.limit()+", ");
		System.out.println("\tcapacity: "+buffer.capacity());
	}
}
