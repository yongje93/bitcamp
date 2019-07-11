package kr.co.bit;

import java.nio.Buffer;
import java.nio.ByteBuffer;

//BufferMethod
public class Example07 {
	public static void main(String[] args) {
		System.out.println("[7����Ʈ ũ���� ���� ����]");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		printState(buffer);

		buffer.put((byte)10);
		buffer.put((byte)11);
		System.out.println("[2����Ʈ ���� ��]");
		printState(buffer);
		
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		System.out.println("[3����Ʈ ���� ��]");
		printState(buffer);
		
		buffer.flip(); //position�� 0���� limit�� ���� position�� �ִ� �ڸ���
		System.out.println("[flip() ���� ��]");
		printState(buffer);
		
		buffer.get(new byte[3]);
		System.out.println("[3����Ʈ ���� ��]");
		printState(buffer);
		
		buffer.mark();
		System.out.println("--���� ��ġ ��ŷ--");
		
		buffer.get(new byte[2]);
		System.out.println("[2����Ʈ ���� ��]");
		printState(buffer);
		
		buffer.reset(); //��ŷ�� �ڸ��� �����Ŵ�
		System.out.println("--[position�� ��ũ ��ġ�� �ű�]--");
		printState(buffer);
		
		buffer.rewind(); //position�� ó�� ���·� 
		System.out.println("[rewind() ���� ��]");
		printState(buffer);
		
		buffer.clear(); //ó�� ���·�
		System.out.println("[clear() ���� ��]");
		printState(buffer);
	}
	
	public static void printState(ByteBuffer buffer) {
		System.out.print("\tposition: "+buffer.position()+", ");
		System.out.print("\tlimit: "+buffer.limit()+", ");
		System.out.println("\tcapacity: "+buffer.capacity());
	}
}
