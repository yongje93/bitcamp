package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Number_11022 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int limit = Integer.parseInt(br.readLine());
			for (int i = 0; i < limit; i++) {
				String[] array = br.readLine().split(" ");
				int result = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
				bw.write("Case #" + (i + 1) + ": " + array[0] + " + " + array[1] + " = " + result + "\n");
			}
			bw.flush();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
