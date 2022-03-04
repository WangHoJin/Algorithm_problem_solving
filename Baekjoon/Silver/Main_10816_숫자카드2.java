package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (hm.containsKey(num)) {
				sb.append(hm.get(num)).append(" ");
			} else
				sb.append("0 ");
		}
		System.out.println(sb.toString());
	}
}
