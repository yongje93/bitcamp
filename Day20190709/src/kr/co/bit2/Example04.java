package kr.co.bit2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example04 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("정상수", "최지수", "박병주", "손상현", "양재우");

		// 순차처리
		Stream<String> stream = list.stream();
		stream.forEach(Example04::print);
		System.out.println();
		
		// 병렬처리(순서가 뒤죽박죽)	기존의 iterator 보다 빠르고 좋다.
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(Example04 :: print);
	
	}

	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
}
