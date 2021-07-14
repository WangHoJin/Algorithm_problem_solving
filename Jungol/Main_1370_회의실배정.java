import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1370_회의실배정 {
	static int N, cnt;

	static class Meeting implements Comparable<Meeting> {
		int no;
		int start;
		int end;

		public Meeting(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end)
				return this.start - o.start;
			return this.end - o.end;
		}

		@Override
		public String toString() {
			return "Meeting [no=" + no + ", start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		Meeting[] m = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<Meeting> list = new ArrayList<>();
		Arrays.sort(m);
//		print(m);
		list.add(m[0]);// 첫회의는 무조건 배정
		sb.append(m[0].no).append(" ");
		cnt = 1;
		for (int i = 1, size = m.length; i < size; i++) {
			if (list.get(list.size() - 1).end <= m[i].start) {
				list.add(m[i]);
				sb.append(m[i].no).append(" ");
				cnt++;
			}
		}
		System.out.println(cnt);
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}

	private static void print(Meeting[] m) {
		for (Meeting meeting : m) {
			System.out.println(meeting);
		}
	}
}
