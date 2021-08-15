package ssafy.study.week16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609_회문 {
	static int T, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/16/회문.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0;
			String str = in.readLine();
			ans = twoPoint(str);
			System.out.println(ans);
		}

	}

	private static int twoPoint(String str) {
		int len = str.length();	// 문장 길이
		boolean flag = true;	// 유사회문
		int end = len - 1;	

		for (int start = 0; start <= end; start++, end--) {
			if (str.charAt(start) == str.charAt(end)) {	// 같으면 투포인터를 옮기면서 검사
				continue;
			} else{	// 다르면 유사회문 검사
				int s = start;
				int e = end;
				// 오른쪽부터 사용
				e--;
				while (s <= e) {
					if (str.charAt(s) == str.charAt(e)) {
						s++;
						e--;
					} else {
						flag = false;
						break;
					}

				}
				// 오른쪽에서 유사회문이면 왼쪽 할 필요 X
				if (flag)
					return 1;
				
				// 왼쪽 검사
				s = start;
				e = end;
				s++;
				while (s <= e) {
					if (str.charAt(s) == str.charAt(e)) {
						s++;
						e--;
					} else {
						flag = true;
						break;
					}

				}
				
				// 둘다 안되면 2 되면 1
				if (flag)
					return 2;
				else
					return 1;
			}
		}
		return 0;

	}

}
