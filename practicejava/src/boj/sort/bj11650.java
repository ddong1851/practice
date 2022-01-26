package src.boj.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj11650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        //Arrays.sort()ë¥? new Comparator<T>(){} ?˜ compare(T o1, T o2)ë¥? ?¬? •?˜?•˜?—¬ ?‚¬?š©?•œ?‹¤
        //ì°¸ê³ ë¡? Comparable?? compareTo(T o1) ë©”ì†Œ?“œë¥?, comparator?Š” compare(T o1, T o2)ë¥? ? œê³µí•œ?‹¤.
        //2?‹¨ ë°°ì—´?„ ? •? ¬?•  ?•Œ?Š” ?´ë¥? ?´?š©?•œ?‹¤.
        //Comparable?? ??‹ ê³? ê°ì²´ë¥?, Comparator?Š” ?‘ ê°ì²´ë¥? ë¹„êµ?•  ?•Œ ?‚¬?š©
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    // ?–‘?ˆ˜ë©? o1?„, ê°™ìœ¼ë©? 0, ?Œ?ˆ˜?´ë©? o2ë¥? ë°˜í™˜?•œ?‹¤.
                    return o1[1] - o2[1];
                }
                else{
                    return o1[0] - o2[0]; 
                }
            }
        });

        /**
         * ?œ„ ?‹?„ ?Œ?‹¤?‹?œ¼ë¡? êµ¬í˜„
         * Arrays.sort(array, (x, y) ->{
            if(x[0] == y[0]){
                return x[1] - y[1];
            }
            else{
                return x[0] - y[0];
            }
        });
         */
        for(int i=0; i<n; i++){
            String str = array[i][0] + " " + array[i][1];
            bw.write(str+"\n");
        }

        br.close();
        bw.close();
    }
}
