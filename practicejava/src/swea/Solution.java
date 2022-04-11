package src.swea;

import java.util.*;
import java.io.*;

/** Solution_SWEA_8458_원점으로집합_D4_*/
public class Solution {
	
	private static int N;
	private static int x;
	private static int y;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
			}
			
		} // end of for TC

		System.out.println(sb.toString());
		
	} // end of main 
} // end of class 
