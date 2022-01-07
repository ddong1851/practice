package src.book.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class book220 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //창고 개수 최대 100
    public static int[] d = new int[100];
    //식량 창고의 데이터를 저장할 배열
    static int[] garrage;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        garrage = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        //창고에 값 넣기
        for(int i=0; i<n; i++){
            garrage[i] = Integer.parseInt(st.nextToken());
        }

        //0, 1 일때 초기화
        d[0] = garrage[0];
        d[1] = Math.max(d[0] ,garrage[1]);
        
        for(int i=2; i<n; i++){
            d[i] = Math.max(d[i-1], d[i-2] + garrage[i]);
        }

        System.out.println(d[n-1]);
    }
}
