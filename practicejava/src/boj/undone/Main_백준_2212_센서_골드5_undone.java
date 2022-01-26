package src.boj.undone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

// 정렬과 그리디를 이용한 방식   
/**Main_백준_2212_센서_골드5_  시간 제한 2초*/
public class Main_백준_2212_센서_골드5_undone {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
    	
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        int [] sensors = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) sensors[i] = Integer.parseInt(st.nextToken());
        // 센서 배열을 정렬
        Arrays.sort(sensors);

        
        //차이 배열을 만든다
        Integer diffSensors[] = new Integer[N-1];
        for(int i=0; i<N-1; i++){
            diffSensors[i] = sensors[i+1] - sensors[i];
        } //  2 3 0 1 2
        
        
        
    }
}
