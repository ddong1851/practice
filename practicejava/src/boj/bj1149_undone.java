package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1149_undone {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] home = new int[1000];
    public static void main(String[] args) throws IOException{
        // 집의 개수를 받을 변수 n
        int n = Integer.parseInt(br.readLine());
        //색깔 별 비용을 입력할 때, 띄어쓰기 구분용

        //색깔별 비용을 저장할 배열
        int[] red = new int[n];
        int[] green = new int[n];
        int[] blue = new int[n];

        //각 색깔의 비용을 배열에 저장한다.
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken()); green[i] = Integer.parseInt(st.nextToken()); blue[i] = Integer.parseInt(st.nextToken()); 
        }

        //첫번째 집은 빨초파 중 가장 저렴한 색깔
        home[0] = Math.min(Math.min(red[0], blue[0]), green[0]);
        //재귀적 DP
        for(int i=2; i<=n; i++){
            
        }
    }
}
