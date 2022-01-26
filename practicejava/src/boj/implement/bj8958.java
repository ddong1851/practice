package src.boj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj8958 {
    public static void main(String[] args) throws IOException{
        soultion();
    }

    private static void soultion() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //?��?��?�� �??��?�� 개수�? ?��?��받는?��.
        int n = Integer.parseInt(br.readLine());
        //n개의 문자?�� ?��?��?���? ???��?�� 배열 ?��?��
        String[] data = new String[n];
        for(int i=0; i<n; i++){
            data[i] = br.readLine();
        }
        br.close();

        //문자?��?�� ?�� n�? 만큼 계산�? 메소?���? ?��?��?��
        for(int i=0; i<n; i++)
            calc(data[i]);
        
    }

    private static void calc(String string) {
        int score, count;
        score = count = 0;

        //문자?��?�� 길이만큼 반복 
        for(int i=0; i<string.length(); i++){
            // O ?��?�� count 증�??��?���?, ?��?��?�� ?��?��?��.
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
