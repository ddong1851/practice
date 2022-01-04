package src.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj2750 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int [] data = new int[N];
        
        for(int i=0; i<N; i++) data[i] = Integer.parseInt(br.readLine());
        Arrays.sort(data);
        
        for(int i:data) bw.write(i+"\n");
        br.close(); bw.close();
    }
}
