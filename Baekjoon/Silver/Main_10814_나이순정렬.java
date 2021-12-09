package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {
	static class Member implements Comparable<Member> {
		int age;
		String name;

		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
//			if (this.age == o.age) {
//				return this.name.compareTo(o.name);
//			}
			return this.age - o.age;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Member> members = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members.add(new Member(age, name));
		}
		
		Collections.sort(members);
		
		for (Member member : members) {
			System.out.println(member.age + " "+ member.name);
		}
	}
}
