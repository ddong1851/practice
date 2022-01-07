package src.boj;

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
        //아무 과정도 거치지 않는다면 바로 출력
        String result=s;

        //만약 key배열에 비어있다면(첫번째 값이 들어온거라면) 첫번째 단어를 바로 추가한다.
        if(Arrays.asList(key).isEmpty()) {
            key.add(s.charAt(0));
            String str = String.valueOf(s.charAt(0));
            return result.replaceFirst(str, "["+str+"]");
        }
        return result;
    }
}
