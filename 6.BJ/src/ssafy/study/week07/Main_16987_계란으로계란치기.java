package ssafy.study.week07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기 {
	static int N, ans;
	static ArrayList<Point> egg;

	static class Point {
		int defense;
		int attack;

		public Point(int defense, int attack) {
			super();
			this.defense = defense;
			this.attack = attack;
		}

		@Override
		public String toString() {
			return "Point [defense=" + defense + ", attack=" + attack + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/계란으로계란치기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 1; t++) {
			ans = 0;
			N = Integer.parseInt(in.readLine());
			egg = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				egg.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			hitEgg(0);

			System.out.println(ans);
		}
	}

	private static void hitEgg(int idx) {
		if (idx == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (egg.get(i).defense <= 0)
					cnt++;
			}
			ans = (ans < cnt) ? cnt : ans;
			return;
		}
		if (egg.get(idx).defense <= 0) {
			hitEgg(idx + 1);
		} else {
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (i == idx || egg.get(i).defense <= 0)
					continue;
				egg.get(i).defense -= egg.get(idx).attack;
				egg.get(idx).defense -= egg.get(i).attack;
				flag = true;
				hitEgg(idx + 1);
				egg.get(i).defense += egg.get(idx).attack;
				egg.get(idx).defense += egg.get(i).attack;
			}
			if (!flag)
				hitEgg(idx + 1);
		}
	}

}
