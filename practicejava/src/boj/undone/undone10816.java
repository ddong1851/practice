package src.boj.undone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class undone10816 {
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
            int c = (HighSearch(temp, 0, data.length-1)-LowSearch(temp, 0, data.length-1));
            if(c!=0) bw.write(c+1 +" ");
            else bw.write(c +" ");
        }
        br.close();
        bw.flush();
    }

    static int HighSearch(int s, int low, int high){
        return 1;
    }

    static int LowSearch(int s, int low, int high){
        return 0;
    }

}

