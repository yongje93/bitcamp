package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Number_15552 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int limit = Integer.parseInt(br.readLine());
			for (int i = 0; i < limit; i++) {
				String[] array = br.readLine().split(" ");
				bw.write(Integer.parseInt(array[0]) + Integer.parseInt(array[1]) + "\n");
			}
			bw.flush();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
