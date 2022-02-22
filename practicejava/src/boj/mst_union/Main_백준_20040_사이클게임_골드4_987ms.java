package src.boj.mst_union;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_백준_20040_사이클게임_골드4_987ms*/
public class Main_백준_20040_사이클게임_골드4_987ms {
	
	private static int count = 0;
	private static int first = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 서로소 집합 생성
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			// 몇 번째 연산인지 counting 
			count++;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 첫번째 사이클이 안나왔을 때만 반복
			if(first==0) {
				union(a, b, p);
			}
		}
		System.out.println(first);
	} // end of main
	
	// 집합의 부모 찾기
	private static int findSet(int a, int[] p) {
		if(a==p[a]) return a;
		else return p[a] = findSet(p[a], p);
	}

	// 합치기
	private static void union(int a, int b, int[] p) {
		// TODO Auto-generated method stub
		int aroot = findSet(a, p);
		int broot = findSet(b, p);
		// 부모가 같을 때 
		if(aroot==broot) {
			// 첫 사이클을 발견하지 못했을 때
			if(first==0) {
				// 첫 사이클은 몇 번째 연산에서 나왔다 저장
				first = count;
			}
			return;
		}
		// 부모가 다를 때
		p[broot] = aroot;
	}
} // end of class
