package kr.co.bit;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

//allocateDirect�� allocate�� ���� buffer����
public class Example06 {
	public static void main(String[] args) {
		ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(100); //���̷�Ʈ����
		System.out.println("����뷮: "+byteBuffer1.capacity());
		
		CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();
		System.out.println("����뷮: "+charBuffer.capacity());
		
		IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
		System.out.println("����뷮: "+intBuffer.capacity());
		
		ByteBuffer byteBuffer2 = ByteBuffer.allocate(100); //�ʹ��̷�Ʈ����
		System.out.println("����뷮: "+byteBuffer2.capacity());
		
		byte[] byteArr = new byte[100];
		ByteBuffer byteBuffer3 = ByteBuffer.wrap(byteArr); //�ʹ��̷�Ʈ����
		System.out.println("����뷮: "+byteBuffer3.capacity());
	}
}
