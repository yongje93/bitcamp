package kr.co.bit;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

//allocateDirect와 allocate를 통해 buffer선언
public class Example06 {
	public static void main(String[] args) {
		ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(100); //다이렉트버퍼
		System.out.println("저장용량: "+byteBuffer1.capacity());
		
		CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();
		System.out.println("저장용량: "+charBuffer.capacity());
		
		IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
		System.out.println("저장용량: "+intBuffer.capacity());
		
		ByteBuffer byteBuffer2 = ByteBuffer.allocate(100); //넌다이렉트버퍼
		System.out.println("저장용량: "+byteBuffer2.capacity());
		
		byte[] byteArr = new byte[100];
		ByteBuffer byteBuffer3 = ByteBuffer.wrap(byteArr); //넌다이렉트버퍼
		System.out.println("저장용량: "+byteBuffer3.capacity());
	}
}
