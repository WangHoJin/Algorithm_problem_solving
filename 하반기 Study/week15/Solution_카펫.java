package kakao.level2;

public class Solution_카펫 {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i = 3 ; i <= total; i++){
            int row = i;    // 세로
            int col = total / row;  // 가로
            
            if(col < row) continue;
            
            if((col-2)*(row-2) == yellow)
            {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }
        
        return answer;
    }
}
