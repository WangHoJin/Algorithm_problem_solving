package second.study.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_기능개발 {
	static int N;

	public static void main(String[] args) throws IOException {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		solution(progresses, speeds);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> pr = new LinkedList<Integer>();
		Queue<Integer> sp = new LinkedList<Integer>();

		for (int i : progresses)
			pr.add(i);
		for (int i : speeds)
			sp.add(i);
		ArrayList<Integer> ans = new ArrayList<>();
		int cnt = 0;
		while (!pr.isEmpty()) {
			boolean flag = false;
			int size = pr.size();
			for (int i = 0; i < size; i++) {
				int temp = pr.poll();
				if (i == 0 && temp >= 100) {
					flag = true;
					cnt = 0;
				}
				if (flag && temp >= 100) {
					sp.poll();
					cnt++;
				} else {
					int speed = sp.poll();
					temp += speed;
					pr.add(temp);
					sp.add(speed);
					flag = false;
				}
			}

			if (pr.size() == 0 || (!flag && cnt != 0)) {
				ans.add(cnt);
				cnt = 0;
			}
		}
		int[] answer = new int[ans.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.get(i);
			System.out.println(answer[i]);
		}
		return answer;
	}

}
