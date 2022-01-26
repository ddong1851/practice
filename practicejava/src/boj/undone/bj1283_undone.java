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
        //?•„ë¬? ê³¼ì •?„ ê±°ì¹˜ì§? ?•Š?Š”?‹¤ë©? ë°”ë¡œ ì¶œë ¥
        String result=s;

        //ë§Œì•½ keyë°°ì—´?— ë¹„ì–´?žˆ?‹¤ë©?(ì²«ë²ˆì§? ê°’ì´ ?“¤?–´?˜¨ê±°ë¼ë©?) ì²«ë²ˆì§? ?‹¨?–´ë¥? ë°”ë¡œ ì¶”ê??•œ?‹¤.
        if(Arrays.asList(key).isEmpty()) {
            key.add(s.charAt(0));
            String str = String.valueOf(s.charAt(0));
            return result.replaceFirst(str, "["+str+"]");
        }
        return result;
    }
}
