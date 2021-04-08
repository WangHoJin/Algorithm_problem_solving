package ssafy.study.week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_12873_기념품 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		ArrayList<Integer> person = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			person.add(i);
		}
		int t = 1; // 단계
		long t3 = 0; // t^3
		int preIdx = 0;	// 이전까지 세던 사람 인덱스
		
		// 사람이 한명 남을때까지
		while (person.size() != 1) {
			t3 = (long) Math.pow(t, 3);
			int size = person.size();
			
			// t3+이전인덱스를 사이즈만큼 나눈 나머지 
			int result = (int) ((t3 + preIdx) % size);
			
			// t3으로 나눈 나머지 인덱스 삭제
			if (result != 0) {
				person.remove(result - 1);
				preIdx = result - 1;	// 이전까지 세던 인덱스 저장
			} 
			// 나머지가 0인 경우 t3/몫 인덱스 삭제
			else if (result == 0) {
				int idx = (int) ((t3 + preIdx) / ((t3 + preIdx) / size));
				person.remove(idx - 1);
				preIdx = idx - 1;
			}
			t++;	//t증가
		}
		// 마지막 한사람 출력
		System.out.println(person.get(0));
	}
}
