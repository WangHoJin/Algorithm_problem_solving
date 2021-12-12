package second.study.week24;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2294_동전2 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/24/동전2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		int[] d = new int[k + 1];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		for (int i = 1; i <= k; i++) {
			d[i] = 100001;
		}
		for (int i = 0; i < n; i++) {
			for (int j = num[i]; j <= k; j++) {
				d[j] = Math.min(d[j], d[j - num[i]] + 1);
			}
		}
		System.out.println(d[k]==100001?-1:d[k]);
	}
}
