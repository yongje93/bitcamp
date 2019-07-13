package kr.co.bit;

import java.nio.ByteBuffer;

//BufferMethod
public class Example07 {
	public static void main(String[] args) {
		System.out.println("[7바이트 크기의 버퍼 생성]");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		printState(buffer);

		buffer.put((byte)10);
		buffer.put((byte)11);
		System.out.println("[2바이트 저장 후]");
		printState(buffer);
		
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		System.out.println("[3바이트 저장 후]");
		printState(buffer);
		
		buffer.flip(); //position은 0으로 limit은 원래 position이 있던 자리로
		System.out.println("[flip() 실행 후]");
		printState(buffer);
		
		buffer.get(new byte[3]);
		System.out.println("[3바이트 읽은 후]");
		printState(buffer);
		
		buffer.mark();
		System.out.println("--현재 위치 마킹--");
		
		buffer.get(new byte[2]);
		System.out.println("[2바이트 읽은 후]");
		printState(buffer);
		
		buffer.reset(); //마킹한 자리로 포지셔닝
		System.out.println("--[position을 마크 위치로 옮김]--");
		printState(buffer);
		
		buffer.rewind(); //position을 처음 상태로 
		System.out.println("[rewind() 실행 후]");
		printState(buffer);
		
		buffer.clear(); //처음 상태로
		System.out.println("[clear() 실행 후]");
		printState(buffer);
	}
	
	public static void printState(ByteBuffer buffer) {
		System.out.print("\tposition: "+buffer.position()+", ");
		System.out.print("\tlimit: "+buffer.limit()+", ");
		System.out.println("\tcapacity: "+buffer.capacity());
	}
}
