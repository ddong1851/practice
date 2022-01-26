package src.boj.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj12738 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // ì¦ê??ˆ˜?—´?„ ???¥?•  ë¦¬ìŠ¤?Š¸
        List<Integer> list = new ArrayList<>();
        // ?…? ¥?œ ê°’ì„ ???¥?•  ë°°ì—´
        int arr[] = new int[n + 1];

        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            // ?™•?¸?•˜?Š” ?ˆ«?ê°? ì¦ê??ˆ˜?—´?˜ ë§ˆì?ë§? ?ˆ˜ë³´ë‹¤ ?° ê²½ìš°
            // ?ˆ˜?—´?— ì¶”ê??•´ì¤??‹¤.
            if(num > list.get(list.size() - 1)) list.add(num);
            // ?™•?¸?•˜?Š” ?ˆ«?ê°? ì¦ê??ˆ˜?—´?˜ ë§ˆì?ë§? ?ˆ˜ë³´ë‹¤ ?‘?? ê²½ìš°
            else{
                // ?ˆ«??˜ ? ?‹¹?•œ ?œ„ì¹˜ë?? ì°¾ì•„
                // ì¦ê??ˆ˜?—´?˜ ê°’ì„ ë³?ê²½í•´ì¤??‹¤.
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        // ìµœì¥ ê¸¸ì´ ì¶œë ¥
        sb.append(list.size() - 1 + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}