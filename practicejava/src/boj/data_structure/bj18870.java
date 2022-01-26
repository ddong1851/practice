package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        Integer [] data = new Integer[N];

        //2 4 -10 4 -9
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) data[i] = Integer.parseInt(st.nextToken());

        Integer[] cloneData = data.clone();
        Arrays.sort(cloneData);
        
        //Set?? ì¤‘ë³µ?œ ?›?†Œë¥? ê°–ì? ?•Š?Š”?‹¤. Integerë¡? ë§Œë“  ë°°ì—´ ë¦¬ìŠ¤?Š¸ë¥? Set?œ¼ë¡? ë³?ê²½í•˜ë©? ì¤‘ë³µ?œ ?›?†Œ?“¤?´ ?‚¬?¼ì§„ë‹¤. 
        //HashMap?„ ?´?š©?•˜ê³?, ?—¬ê¸°ì„œ containsKeyë¥? ?´?š©?•˜?Š” ê²ƒë„ ë°©ë²•
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        for(int i: cloneData){
            if(!map.containsKey(i)){
                map.put(i, count);
                count++;
            }
        }
        for(int i:data){
            bw.write(map.get(i)+" ");
        }
        br.close();
        bw.close();
    }
}
