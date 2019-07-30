package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest2 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.chanel.com/ko_KR/watches-jewelry/fine-jewelry/c/rings/J001000?show=All");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

		String line = null;
		int count = 0;
		int index = 0;
		String findStr = "18K";
		while ((line = br.readLine()) != null) { // 읽는 값이 null이 아닐때까지 읽어라
			while (true) {
				index = line.toLowerCase().indexOf(findStr.toLowerCase(), index); // 0부터 시작
				//System.out.println(index);
				if (index != -1) {
					count++;
					index += findStr.length();
				} else
					break;
			}
		} // while

//		while ((line = br.readLine()) != null) {
//			String[] str = line.split(" ");
//			for (String string : str) {
//				//System.out.println(string);
//				if(string.toLowerCase().contains("18K".toLowerCase())) {
//					count++;
//				}
//			}
//		}

//		while ((line = br.readLine()) != null) {
//			Pattern pattern = Pattern.compile("18K",Pattern.CASE_INSENSITIVE);
//			Matcher matcher = pattern.matcher(line);
//			while(matcher.find()){
//				count++;
//			}
//		}
		System.out.println("18K의 개수 : " + count);

		br.close();
	}
}
