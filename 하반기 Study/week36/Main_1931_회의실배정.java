package second.study.week36;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

	static int N, ans;

	static class Time implements Comparable<Time> {
		int start, end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if (this.end == o.end)
				return this.start - o.start;
			return this.end - o.end;
		}

		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/36/회의실배정.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		ArrayList<Time> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Time(s, e));
		}
		Collections.sort(list);
		int last = 0;

		for (int i = 0; i < N; i++) {
			int s = list.get(i).start;
			int e = list.get(i).end;
			if (last <= s) {
				last = e;
				ans++;
			}
		}
		System.out.println(list.toString());
	}

}
