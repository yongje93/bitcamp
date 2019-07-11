package kr.co.bit;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Example08 {
	public static void main(String[] args) {
		System.out.println("[7����Ʈ ũ�� ���� ����]");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		buffer.put((byte)10);
		buffer.put((byte)11);
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		buffer.flip();
		printState(buffer);
		
		buffer.get(new byte[3]);
		System.out.println("[3����Ʈ ����]");
		printState(buffer);
		
		buffer.compact(); // ���� �������� �߽����� ����Ʈ���� �ִ� ���ڸ� �а� ó�� ��ġ�������� �ٿ��ִ´�
		System.out.println("[compact() ���� ��]");
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
