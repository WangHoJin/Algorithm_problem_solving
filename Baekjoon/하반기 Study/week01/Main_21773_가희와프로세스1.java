import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21773_가희와프로세스1 {
	static int T, n, A, B, C;

	static class Process implements Comparable<Process> {
		int id, time, priority;

		public Process(int id, int time, int priority) {
			super();
			this.id = id;
			this.time = time;
			this.priority = priority;
		}

		@Override
		public int compareTo(Process o) {
			if (this.priority == o.priority) {
				return this.id - o.id;
			}
			return o.priority - this.priority;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/00/가희와프로세스1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		PriorityQueue<Process> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			pq.add(new Process(A, B, C));
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			if (pq.size() == 0)
				break;
			Process temp = pq.poll();
			sb.append(temp.id + "\n");
//			System.out.println(temp.id);
			if (temp.time == 1)
				continue;
			pq.add(new Process(temp.id, temp.time - 1, temp.priority - 1));
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
