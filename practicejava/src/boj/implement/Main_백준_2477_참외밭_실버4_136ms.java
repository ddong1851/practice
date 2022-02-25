package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2477_참외밭_실버4_136ms{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		int maxR = 0;
		int maxC = 0;
		int maxRIdx = 0;
		int maxCIdx = 0;
		int smallR = 0;
		int smallC = 0;
		boolean[] v = new boolean[5];
		int[] input = new int[6];
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(idx<=2) {
				if(v[idx]) {
					smallC = idx;
				}
				else {
					v[idx] = true;
					if(maxC<len) {
						maxC = len;
						maxCIdx = i;
					}
				}
			}
			else {
				if(v[idx]) {
					smallR = idx;
				}
				else {
					v[idx] = true;
					if(maxR<len) {
						maxR = len;
						maxRIdx = i;
					}
				}
			}
			input[i] = len;
		}
		
		int removeR = 0;
		int removeC = 0;
		
		if((smallR==3 && smallC==1) || (smallR==4 && smallC==2)) {
			removeR = (maxRIdx + 4)%6;
			removeC = (maxCIdx + 2)%6;
		}
		else {
			removeR = (maxRIdx + 2)%6;
			removeC = (maxCIdx + 4)%6;
		}
		
		System.out.println((maxR*maxC - input[removeR]*input[removeC])*K);
		
	    
	} // end of main
} // end of class
