package ssafy.study.week02;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13335_트럭 {
	static int n, w, l;
	static int[] truck;
	static Queue<Integer> q;
	static int sumWeight, time, cnt;

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
		// 1일 경우 : 큐가 다리길이만큼 찰때까지 0을 삽입
		// 2일 경우 : 바로 큐에 삽입
		int i = 0;
		time = 0;
		cnt = 0;
		while (true) {
			if (sumWeight + truck[i] > l) {
				q.add(0);
				time++;
			} else if (sumWeight + truck[i] <= l) {
				sumWeight += truck[i];
				q.add(truck[i]);
				time++;
				i++;
			}
			if (q.size() == w) {
				sumWeight -= q.poll();
			}
			if (i == n) {
				time += w;
				break;
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
