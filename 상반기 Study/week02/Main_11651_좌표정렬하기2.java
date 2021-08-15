package ssafy.study.week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11651_좌표정렬하기2 {
	static int N;
	static Point[] p;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		p = new Point[N];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x, y);
		}

		Arrays.sort(p, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.y == p2.y)
					return Integer.compare(p1.x, p2.x);
				return Integer.compare(p1.y, p2.y);
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.println(p[i].x + " " + p[i].y);
		}
	}
}
