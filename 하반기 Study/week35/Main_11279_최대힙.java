package second.study.week35;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11279_최대힙 {

	static int N;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/35/최대힙.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(in.readLine());
		pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if (num == 0) {
				if (pq.size() == 0) {
					sb.append("0").append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}

			} else {
				pq.add(new Integer(num));
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
