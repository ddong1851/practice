package src.boj.undone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class bj1283_undone {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Character> key;
    Arrays arrays;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        key = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            bw.write(solution(str)+"\n");
        }

        br.close();
        bw.close();
    }

    static String solution(String s){
        //?���? 과정?�� 거치�? ?��?��?���? 바로 출력
        String result=s;

        //만약 key배열?�� 비어?��?���?(첫번�? 값이 ?��?��?��거라�?) 첫번�? ?��?���? 바로 추�??��?��.
        if(Arrays.asList(key).isEmpty()) {
            key.add(s.charAt(0));
            String str = String.valueOf(s.charAt(0));
            return result.replaceFirst(str, "["+str+"]");
        }
        return result;
    }
}
