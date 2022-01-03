package src.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//떡볶이 떡 만들기
public class book201 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] cake;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cake = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) cake[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cake);
        
        binarySearch(m, 0, cake[cake.length-1]);

        br.close();
        bw.close();
    }

    static void binarySearch(int key, int low, int high) throws IOException{
        int mid, h;
        while(low<high){
            mid = (low+high)/2;
            h = AddArrays(mid);
            if(key==h) {
                bw.write(mid+" ");
                break;
            }
            else if(key < h) low = mid+1;
            else high = mid-1;
        }
    }
    
    static int AddArrays(int height){
        int result = 0;
        for(int i:cake){
            if(i-height<=0) continue;
            else{
                result += i-height;
            }
        }
        return result;
    }
}
