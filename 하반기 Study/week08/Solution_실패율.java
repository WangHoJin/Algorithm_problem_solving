package kakao.level1;

import java.util.Arrays;
import java.util.Collections;

public class Solution_실패율 {
	public static class Info implements Comparable<Info> {
		int stage; // 해당 스테이지
		int chalCnt; // 해당 스테이지에 도전한 사용자 수
		int nClearCnt; // 해당 스테이지에 클리어하지 못한 사용자 수
		double failRate; // 해당 스테이지 실패율

		public Info(int stage, int chalCnt, int nClearCnt, double failRate) {
			this.stage = stage;
			this.chalCnt = chalCnt;
			this.nClearCnt = nClearCnt;
			this.failRate = failRate;
		}

		@Override
		public int compareTo(Info o) {
			if (Double.compare(o.failRate, this.failRate) == 0) {
				return this.stage - o.stage;
			}
			else if (Double.compare(o.failRate, this.failRate) > 0)
				return 1;
			else
				return -1;
//			실수를 비교할때 주의사항 
//			return (int) (o.failRate - this.failRate);
		}
	}

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 2, 4, 3, 3 };
//		int[] stages = { 4,4,4,4,4};
		int[] answer = solution(N, stages);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		Info[] info = new Info[N];
		// info 객체 생성
		for (int i = 0; i < N; i++)
			info[i] = new Info(i+1, 0, 0, 0);
		// 도전했던 사용자와 클리어하지 못한 사용자 카운트
		for (int i = 0; i < stages.length; i++) {
			int currStage = stages[i]-1;
			for (int j =0; j <= currStage; j++) {
				if (j == N)
					break;
				info[j].chalCnt++;
			}
			// 모든 스테이지 클리어한 사용자는 패스
			if (N == currStage)
				continue;
			info[currStage].nClearCnt++;
		}
		// 스테이지 실패율 구하기
		for (int i = 0; i < N; i++) {
			info[i].failRate = (double) info[i].nClearCnt / info[i].chalCnt;
			if(info[i].chalCnt == 0) info[i].failRate = 0.0; 
		}
		// 내림차순 정렬
		Arrays.sort(info);

		for (int i = 0; i < N; i++) {
			answer[i] = info[i].stage;
		}

		return answer;
	}
}
