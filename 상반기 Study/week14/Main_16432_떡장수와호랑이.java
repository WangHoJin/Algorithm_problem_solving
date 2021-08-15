package ssafy.study.week14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_16432_떡장수와호랑이 {
	static int N;
	static boolean flag;
	static ArrayList<Integer> ans;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/14/떡장수와호랑이.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		flag = false;
		arr = new ArrayList[N];
		ans = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
			for (int j = 0; j < k; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		dfs(0, 0);
		if (flag) {
			for (int i = 0; i < ans.size(); i++) {
				System.out.println(ans.get(i));
			}
		} else
			System.out.println(-1);
	}

	private static void dfs(int idx, int pre) {
		if (idx == N) {
			flag = true;
//			System.out.println(ans);
			return;
		}
		for (int i = 0; i < arr[idx].size(); i++) {
			int num = arr[idx].get(i);
			if (num == pre)
				continue;
			ans.add(num);
			dfs(idx + 1, num);
			if (flag)
				return;
			ans.remove(idx);
		}

	}
}
