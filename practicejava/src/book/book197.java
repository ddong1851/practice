package src.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class book197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int MyParts[];
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        MyParts = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            MyParts[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(MyParts);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int find = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(find, 0, MyParts.length-1)+" ");
        }
        br.close();
        bw.close();
    }

    static String binarySearch(int key, int low, int high){
        int mid;
        while(low<high){
            mid = (low+high)/2;
            if(MyParts[mid]==key){          //탐색 성공
                return "yes";
            }
            // 타겟이 리스트의 중간값보다 더 작은 경우, high를 중간값 기준으로 변경
            else if(key<MyParts[mid]){
                high = mid-1;
            }
            else low = mid+1;
        }
        //탐색 실패
        return "no";
    }
}
