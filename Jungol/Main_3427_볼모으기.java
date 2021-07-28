import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
    static int N, ans;
    static char[] ball;
 
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input/second/03/볼모으기.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        ball = new char[N];
        String s = in.readLine();
        int r = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            char color = s.charAt(i);
            ball[i] = color;
            if (color == 'R')
                r++;
            else
                b++;
 
        }
 
        // 1. 양쪽 끝이 같은 색일 경우
        if (ball[0] == ball[N - 1]) {
            char temp = ball[0];
            // 양쪽 끝에서 같은 색이 이어지는 최대 길이 측정
            // 왼쪽
            int left = 0;
            for (int i = 0; i < N; i++) {
                if (ball[i] == temp)
                    left++;
                else
                    break;
            }
            // 오른쪽
            int right = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (ball[i] == temp)
                    right++;
                else
                    break;
            }
            // 더 많이 연속된 갯수 저장
            int max = Math.max(left, right);
 
            // 해당 색의 총 갯수에 연속된 갯수를 뺀 수와 다른색의 수 중 작은거 선택
            // 빨강일때
            if (temp == 'R') {
                ans = Math.min(b, r - max);
            }
            // 파랑일때
            else {
                ans = Math.min(r, b - max);
            }
 
        }
 
        // 2. 양쪽 끝이 다른 색일 경우
        else {
            char temp1 = ball[0];
            char temp2 = ball[N - 1];
            // 양쪽 끝에서 같은 색이 이어지는 최대 길이 측정
            // 왼쪽
            int left = 0;
            for (int i = 0; i < N; i++) {
                if (ball[i] == temp1)
                    left++;
                else
                    break;
            }
            // 오른쪽
            int right = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (ball[i] == temp2)
                    right++;
                else
                    break;
            }
 
            // 해당 색의 총 갯수에 연속된 갯수를 뺀 수와 다른색의 수 중 작은거 선택
            // 빨강일때
            if (temp1 == 'R') {
                ans = Math.min(b - right, r - left);
            }
            // 파랑일때
            else {
                ans = Math.min(r - right, b - left);
            }
        }
 
//      print(ball);
        System.out.println(ans);
    }
 
    private static void print(char[] map) {
        for (char i : map) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}