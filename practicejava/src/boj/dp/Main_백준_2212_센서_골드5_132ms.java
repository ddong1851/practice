package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_백준_2212_센서_골드5_132ms {
	
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 센서의 개수
        int N = Integer.parseInt(br.readLine());
        // 집중국의 개수
        int K = Integer.parseInt(br.readLine());
        // 센서 초기화
        int[] sensors = new int[N];
        int[] diff = new int[N-1];
        
        // 1. 센서 데이터를 입력 받고 오름 차순 정렬한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		} 
        Arrays.sort(sensors);
        
        // 2. 센서 테이블의 차이 테이블을 만든다.
        for(int i=0; i<N-1; i++) {
        	diff[i] = sensors[i+1] - sensors[i];
        }
        Arrays.sort(diff);
        
        // 세울 수 있는 집중국이 K개면, K-1개 만큼의 차이를 가지 않아도 됨. 
        // 벌어지는 것을 최대한 적게 만들면 된다.
        int sum = 0;
        for(int i=0; i<N-1-(K-1); i++) { // 차이가 짧은것부터 원하는 개수만큼만 사용 
        	sum += diff[i];
        }
        
        System.out.println(sum);
        
    } // end of main
    
} // end of class 
