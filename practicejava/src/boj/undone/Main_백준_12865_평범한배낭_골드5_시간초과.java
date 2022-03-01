package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_백준_12865_평범한배낭_골드5_시간초과*/
public class Main_백준_12865_평범한배낭_골드5_시간초과 {
	
	private static class Item implements Comparable<Item>{
		int w, value;
		public Item(int w, int value) {
			super();
			this.w = w;
			this.value = value;
		}
		// 평균 값어치가 가장 높은 순서로 정렬
		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			if(this.w == o.w) {
				return o.value - this.value;
			}
			else {
				return this.w - o.w;
			}
		}
	}

	private static int total;
	private static int N;
	private static int K;
	private static Item[] items;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 부분집합은 최악의 경우 ( 가지치기가 안들어간 경우 2^100 연산) --> DP로 접근해야 한다.
		N = Integer.parseInt(st.nextToken()); // 물품의 수 1 <= N <= 100
		K = Integer.parseInt(st.nextToken()); // 무게 한계 1 <= K <= 100_000
		
		items = new Item[N];
		
		// N개의 물품에 대한 정보를 받는다.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			items[i] = new Item(w, value);
		}
		
		Arrays.sort(items);
 		
		total = 0;
		
		go(0, 0, 0);
		// 정답 출력
		System.out.println(total);
	} 
	
	private static void go(int weight, int value, int start) {
		if(start==N) {
			total = Math.max(total, value);
			return;
		}
		// 이전 모든 합보다 현재 아이템의 가치가 더 높고, 물건의 무게가 한계를 초과하지 않는다면 비선택
		if(items[start].value==0) go(weight, value, start+1);
		// 연산할 필요가 없는 무게가 나온다면 종료
		else if(items[start].w > K) {
			total = Math.max(total, value);
			return;
		}
		// 선택 비선택
		else {
			if(weight+items[start].w <= K) go(weight+items[start].w, value+items[start].value, start+1);
			go(weight, value, start+1);
		}
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





