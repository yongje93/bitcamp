package kr.co.bit;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

//buffer��ȯ 
public class Example09 {
	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8"); //���ڿ� <-> ���̳ʸ� ��ȯ
		
		//���ڿ� ���ڵ�
		String data = "�ȳ��ϼ���";
		ByteBuffer bb = charset.encode(data);
		
		//���ڿ� ���ڵ�
		data = charset.decode(bb).toString();
		System.out.println("���ڿ� ����: "+data);
	}
}
