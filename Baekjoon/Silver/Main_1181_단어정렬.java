package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = in.readLine();
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		});

		System.out.println(str[0]);
		for (int i = 1; i < N; i++) {
			if (!str[i].equals(str[i - 1]))
				System.out.println(str[i]);
		}
	}
}
