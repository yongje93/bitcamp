package kr.co.bit;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

//buffer변환 
public class Example09 {
	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8"); //문자열 <-> 바이너리 변환
		
		//문자열 인코딩
		String data = "안녕하세요";
		ByteBuffer bb = charset.encode(data);
		
		//문자열 디코딩
		data = charset.decode(bb).toString();
		System.out.println("문자열 복원: "+data);
	}
}
