package src.boj.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//?��번편 ?��?��?��?��, System 출력?�� 비해 BW?�� ?��?��?��?���? ?��간적?�� ?��?��?�� �? ?�� ?��?��.
public class bj10815 {
    static int[] data;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        data = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) data[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(data);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        //?��?��값이 data 배열?�� ?��?���? ?���? ?��?��
        for(int i=0; i<m; i++){
            int j = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(j, 0, data.length-1)+" ");
        }
        br.close();
        bw.close();
    }

    static int binarySearch(int key, int low, int high) throws IOException{
        int mid;
        while(low<=high){
            mid = (low + high)/2;
            if(key == data[mid])
                return 1;
            else if(key < data[mid]) high = mid - 1;
            else low = mid + 1;
        }
        //?��?�� ?��?��
        return 0;
    }
}
