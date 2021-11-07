package second.study.week19;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
	static int T, k;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/19/이중우선순위큐 .txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			k = Integer.parseInt(in.readLine());
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			while (k-- > 0) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				String type = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (type.equals("I")) {
					tm.put(num, tm.getOrDefault(num, 0) + 1);
				} else {
					if (tm.isEmpty())
						continue;
					if (num == 1) {
						int max = tm.lastKey();
						if (tm.get(max) == 1)
							tm.remove(max);
						// 같은 숫자가 있을경우
						else {
							tm.put(max, tm.get(max) - 1);
						}
					} else {
						int min = tm.firstKey();
						if (tm.get(min) == 1)
							tm.remove(min);
						// 같은 숫자가 있을경우
						else {
							tm.put(min, tm.get(min) - 1);
						}
					}
				}
			}
			if (tm.isEmpty())
				sb.append("EMPTY\n");
			else
				sb.append(tm.lastKey() + " " + tm.firstKey() + "\n");
		}
		System.out.println(sb.toString());

	}
}
