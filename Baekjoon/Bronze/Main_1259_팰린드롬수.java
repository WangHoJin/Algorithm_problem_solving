package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			char[] word = in.readLine().toCharArray();
			if (word[0] == '0')
				break;
			int len = word.length;
			boolean flag = true;
			for (int i = 0; i < len; i++) {
				if (word[i] != word[len - (i + 1)]) {
					flag = false;
					break;
				}
			}
			System.out.println(flag ? "yes" : "no");
		}
	}
}
