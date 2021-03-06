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

        //Arrays.sort()λ₯? new Comparator<T>(){} ? compare(T o1, T o2)λ₯? ?¬? ???¬ ?¬?©??€
        //μ°Έκ³ λ‘? Comparable?? compareTo(T o1) λ©μ?λ₯?, comparator? compare(T o1, T o2)λ₯? ? κ³΅ν?€.
        //2?¨ λ°°μ΄? ? ? ¬?  ?? ?΄λ₯? ?΄?©??€.
        //Comparable?? ?? κ³? κ°μ²΄λ₯?, Comparator? ? κ°μ²΄λ₯? λΉκ΅?  ? ?¬?©
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    // ??λ©? o1?, κ°μΌλ©? 0, ???΄λ©? o2λ₯? λ°ν??€.
                    return o1[1] - o2[1];
                }
                else{
                    return o1[0] - o2[0]; 
                }
            }
        });

        /**
         * ? ?? ??€??Όλ‘? κ΅¬ν
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
