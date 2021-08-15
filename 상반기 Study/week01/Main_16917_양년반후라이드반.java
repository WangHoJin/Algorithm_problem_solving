package ssafy.study.week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 문제> 
 * 양념 치킨 최소 X마리, 후라이드 치킨 최소 Y마리를 구매하는 금액의 최솟값을 구해라!!
 * 
 * 조건>
 * A : 양념 치킨 가격
 * B : 후라이드 치킨 가격
 * C : 반반 치킨 가격
 * X : 양념 치킨 최소갯수
 * Y : 후라이드 치킨 최소갯수
 * 1 <= A,B,C <= 5,000    1 <= X,Y <= 100,000
 * 
 * 주의사항>
 * 1. 반반 치킨 두마리는 각각 후라이드, 양념 치킨 한마리가 된다!
 * 2. 2*C가 각각의 A, B보다 작으면 반반 가격으로 사는게 최소금액!
 * 
 * 풀이>
 * 1. A+B < 2C 이면 반반 치킨은 사지않는다!
 * 2. A+B >= 2C 이면 반반 치킨을 최대한 사고 나머지는 낱개로 산다!
 * 3. 2.에서 2*C < A, B이면 반반으로 모든 치킨 구매!! 
 *
 */
public class Main_16917_양년반후라이드반 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		// 입력
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int result = 0;

		// 풀이
		// 반반치킨 가격 => 한마리당 가격으로 변경
		int Cprice = 2 * C;
		// 반반치킨 가격과 비교하여 후 더 작은값 삽입
		A = (A > Cprice) ? Cprice : A;
		B = (B > Cprice) ? Cprice : B;
		if (A + B >= Cprice) {
			if (X >= Y) {
				result = (Cprice * Y) + ((X - Y) * A);
			} else if (Y > X) {
				result = (Cprice * X) + ((Y - X) * B);
			}
		} else if (A + B < Cprice) {
			result = (A * X) + (B * Y);
		}
		System.out.println(result);
	}
}
