package src.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class book182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] a;
    static Integer[] b;
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        //하나는 오름차순, 하나는 내림차순으로 정렬
        Arrays.sort(a); Arrays.sort(b, Collections.reverseOrder());

        int c, count;
        c = count = 0;
        //순서대로 비교하는데, A의 최솟값이 B의 최댓값보다 클 경우 OR k번만큼 변경을 했을 때 정답을 출력
        while(true){
           if(a[c]>=b[c] || count==k){
               System.out.println(AddArrays());
               break;
            }
            else{
               a[c] = b[c];
               count++;
            }
            c++;
        }
    }

    //A 배열에 있는 값들을 다 더해주는 메서드
    static int AddArrays(){
        int result = 0;
        for(int i:a) result+=i;
        return result;
    }
}
