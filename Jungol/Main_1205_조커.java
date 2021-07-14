import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1205_조커 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] num = new int[N];
		int J = 0; // 조커 갯수
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (num[i] == 0)
				J++;
		}
		Arrays.sort(num);
		int size = num[N - 1]; // 최대값 구하고
		boolean[] numCheck = new boolean[size+1]; // 숫자 체크할 배열 생성
		// 숫자가 있으면 true 표시
		for (int i = 0; i < N; i++) {
			numCheck[num[i]] = true;
		}

		Queue<Integer> joker = new LinkedList<Integer>();	// 조커 사용 현황
		int[] len = new int[size+1];	// 인덱스별 길이
		int max = J;
		int L = 0 ;	// 현재 길이
		for (int i = 1; i <= size; i++) {
			// 있는 숫자일 경우
			if(numCheck[i]) {
				L++;
				//len[i] = len[i-1]+1;
			}
			// 없는 숫자일 경우
			else {
				if(joker.size() < J) {
					L++;
					//len[i] = len[i-1]+1;
					joker.add(i);	
				}
				else {
					L++;
					//len[i] = len[i-1]+1-len[joker.poll()];
					L = L-joker.poll();
					joker.add(i);
					
				}
			}
			max = Math.max(max, L);
		}
		
		System.out.println(max);

	}
}
