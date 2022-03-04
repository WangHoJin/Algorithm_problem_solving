package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			hs.add(num);
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (hs.contains(num)) {
				sb.append("1").append("\n");
			} else
				sb.append("0").append("\n");
		}
		System.out.println(sb.toString());
	}
}
