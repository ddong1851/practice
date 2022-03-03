package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/** Main_백준_12865_평범한배낭_골드5_시간초과*/
public class Main_백준_12865_평범한배낭_골드5_시간초과 {
	

	private static int N;
	private static int K;
	
	private static int[][] items;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 부분집합은 최악의 경우 ( 가지치기가 안들어간 경우 2^100 연산) --> DP로 접근해야 한다.
		N = Integer.parseInt(st.nextToken()); // 물품의 수 1 <= N <= 100
		K = Integer.parseInt(st.nextToken()); // 무게 한계 1 <= K <= 100_000
		// 무게, 가치를 저장 ( 무게 기준 오름차순, 무게가 같다면 가치 기준 내림차순
		items = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(items, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]!=o2[0]) return o1[0]-o2[0];
				else return o2[1] - o1[1];
			}
		});
		
		
	} 
	
}
//10 999
//46 306
//60 311
//33 724
//18 342
//57 431
//49 288
//12 686
//89 389
//82 889
//16 289





