package ssafy.study.week02;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13335_트럭2 {
	static int n, w, l;
	static int[] truck;
	static Queue<Integer> q;
	static int sumWeight, time, cnt,cntP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();
		l = sc.nextInt();
		truck = new int[n];
		sumWeight = 0;
		for (int i = 0; i < n; i++) {
			truck[i] = sc.nextInt();
		}
		q = new LinkedList<>();
		// 다리에 트럭 진입 => 1. 뒤에 트럭 못들어옴 2.뒤에 트럭 바로 들어옴
		// 1일 경우 시간 += 다리길이
		// 2일 경우 시간 = 연이은 트럭 수 + 다리길이
		// 다리 길이 2, 최대하중 10
		// 7 4 5 6
		int i = 0;
//		q.add(truck[0]);
//		sumWeight = truck[0];
		time = 1;
		cnt = 0;
		cntP=0;
		q.add(truck[0]);
		sumWeight += truck[i];
		i++;
		while (!q.isEmpty()) {
			if (i == n) {
				while (!q.isEmpty()) {
					q.poll();
				}
				time += w;
				break;
			}
			sumWeight += truck[i];
			if (sumWeight > l) {
				while (sumWeight > l) {
					sumWeight -= q.poll();
					cnt--;
					cntP++;
					if(cnt==0) {
						time += w+cntP;
						cnt=-1;
						cntP=0;
					}
				}
			}
			if (i != n && sumWeight <= l) {
				q.add(truck[i]);
				cnt++;
				i++;
			}
		}
		System.out.println(time);
	}

	public static boolean Over() {
		if (sumWeight > l)
			return true;
		return false;
	}
}
