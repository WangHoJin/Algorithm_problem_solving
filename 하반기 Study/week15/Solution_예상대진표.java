package kakao.level2;

public class Solution_예상대진표 {
	public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a!=b){
            a = (a+1) / 2;
            b = (b+1) / 2;
            answer++;
        }

        return answer;
    }
}
