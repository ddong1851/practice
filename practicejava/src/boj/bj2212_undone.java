package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class bj2212_undone {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        //int K = Integer.parseInt(br.readLine());
        int [] sensors = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) sensors[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sensors);


        Integer diffSensors[] = new Integer[N-1];
        for(int i=0; i<N-1; i++){
            diffSensors[i] = sensors[i+1] - sensors[i];
        }
        
        //뭔가 차이를 이용하는 문제인 것 같은데... 어떤 기준을 두고 풀어야 할지..
    }
}
