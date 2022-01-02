package src.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] data;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        data = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) data[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(data);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int temp = Integer.parseInt(st.nextToken());
            bw.write(BinarySearch(temp, 0, data.length-1)+" ");
        }
        br.close();
        bw.flush();
    }

    static int BinarySearch(int key, int low, int high) throws IOException{
        int mid;

        while(low<=high){
            mid = (low+high)/2;
            if(key==data[mid]) {
                return CountNum(key);
            }
            else if(key < data[mid]) high = mid - 1;      
            else low = mid+1;     
        }
        return 0;
    }

    static int CountNum(int num){
        int count=0;
        for(int i : data) if(i==num) count++;
        return count;
    }
}

