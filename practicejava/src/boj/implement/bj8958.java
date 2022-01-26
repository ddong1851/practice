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

        //?…Œ?Š¤?Š¸ ì¼??´?Š¤ ê°œìˆ˜ë¥? ?…? ¥ë°›ëŠ”?‹¤.
        int n = Integer.parseInt(br.readLine());
        //nê°œì˜ ë¬¸ì?—´ ?°?´?„°ë¥? ???¥?•  ë°°ì—´ ?ƒ?„±
        String[] data = new String[n];
        for(int i=0; i<n; i++){
            data[i] = br.readLine();
        }
        br.close();

        //ë¬¸ì?—´?˜ ?ˆ˜ në²? ë§Œí¼ ê³„ì‚°ê¸? ë©”ì†Œ?“œë¥? ?Œ? ¤?¼
        for(int i=0; i<n; i++)
            calc(data[i]);
        
    }

    private static void calc(String string) {
        int score, count;
        score = count = 0;

        //ë¬¸ì?—´?˜ ê¸¸ì´ë§Œí¼ ë°˜ë³µ 
        for(int i=0; i<string.length(); i++){
            // O ?¼?•Œ count ì¦ê??‹œ?‚¤ê³?, ? ?ˆ˜?— ?”?•œ?‹¤.
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
