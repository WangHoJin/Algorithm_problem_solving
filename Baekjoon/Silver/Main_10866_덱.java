package Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10866_덱 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Silver/덱.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Deque<Integer> de = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			String s = st.nextToken();
			switch (s) {
			case "push_front":
				de.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				de.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (de.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(de.pollFirst()).append("\n");
				break;
			case "pop_back":
				if (de.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(de.pollLast()).append("\n");
				break;
			case "size":
				sb.append(de.size()).append("\n");
				break;
			case "empty":
				if (de.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "front":
				if (de.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(de.getFirst()).append("\n");
				break;
			case "back":
				if (de.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(de.getLast()).append("\n");
				break;
			default:
				break;
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
