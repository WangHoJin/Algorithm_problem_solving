package level1;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i = 1; i <=count; i++){
            sum += i* price;
        }
        answer = sum - money;
        if(answer < 0) answer = 0;
        return answer;
    }
}