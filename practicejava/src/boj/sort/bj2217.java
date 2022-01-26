package src.boj.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj2217 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        Integer[] data = new Integer[N];

        // ë°°ì—´?— ë¡œí”„?˜ ê°’ë“¤?„ ?…? ¥ë°›ê³ , ?‚´ë¦¼ì°¨?ˆœ?œ¼ë¡? ? •? ¬?•œ?‹¤. 
        for(int i=0; i<N; i++) data[i] = sc.nextInt();
        sc.close();
        Arrays.sort(data, Collections.reverseOrder());

        int result=data[0];     //ë°°ì—´?˜ ì²«ë²ˆì§? ê°’ì„ ???¥. ë¡œí”„ë¥? ?•œê°œë§Œ ?“´?‹¤ë©? ì²˜ìŒ ê°’ì„ ?“°?Š”ê²? ê°??¥ ?´?“
        for(int i=1; i<N; i++){
            if(result<(i+1)*data[i]) result=(i+1)*data[i];
        }
        
        System.out.println(result);
    }
}
