class Solution {
    // 최대 공약수로 나누었을때 반복되는 패턴이 나온다.
    // ex) (8,12) => 최대공약수 4로 나누면 (2,3)칸마다 패턴
    public long solution(int w, int h) {
        long answer = 1;
        long width = (long) w;
        long height = (long) h;
        // w * h - (w + h - 최대공약수) 라는 식이 나옴.
        
        // 최대공약수 함수 gcd
        if(width == height) answer = width * height - width;
        else if(width < height)
            answer = width * height - (height + width - gcd(height, width));
        else
            answer = width * height - (width + height - gcd(width, height));
        return answer;
    }
    
    public long gcd(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}