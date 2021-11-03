package second.study.week19;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_19598_최소회의실개수 {
	static int N;

	static class Time implements Comparable<Time> {
		int t, v;

		public Time(int t, int v) {
			super();
			this.t = t;
			this.v = v;
		}

		@Override
		public int compareTo(Time o) {
			if (this.t == o.t)
				return this.v - o.v;
			return this.t - o.t;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/19/최소회의실개수.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		ArrayList<Time> time = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			time.add(new Time(Integer.parseInt(st.nextToken()), 1));
			time.add(new Time(Integer.parseInt(st.nextToken()), -1));
		}
		Collections.sort(time);
		int max = 0;
		int cnt = 0;
		for (Time t : time) {
			cnt += t.v;
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}
