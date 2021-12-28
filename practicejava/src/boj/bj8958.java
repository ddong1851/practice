package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj8958 {
    public static void main(String[] args) throws IOException{
        soultion();
    }

    private static void soultion() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 개수를 입력받는다.
        int n = Integer.parseInt(br.readLine());
        //n개의 문자열 데이터를 저장할 배열 생성
        String[] data = new String[n];
        for(int i=0; i<n; i++){
            data[i] = br.readLine();
        }
        br.close();

        //문자열의 수 n번 만큼 계산기 메소드를 돌려라
        for(int i=0; i<n; i++)
            calc(data[i]);
        
    }

    private static void calc(String string) {
        int score, count;
        score = count = 0;

        //문자열의 길이만큼 반복 
        for(int i=0; i<string.length(); i++){
            // O 일때 count 증가시키고, 점수에 더한다.
            if(string.charAt(i)=='O'){
                count++;
                score+=count;
            }
            else
                count = 0;
        }
        System.out.println(score);
    }
}
