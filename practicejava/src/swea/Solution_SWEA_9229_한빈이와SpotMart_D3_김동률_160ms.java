package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_ÇÑºóÀÌ¿ÍSpotMart_D3_±èµ¿·ü_160ms {
	
	static int N, M, max;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=TC; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int [] weight = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			SubSet(0, 0, 0, weight);
			sb.append("#").append(testcase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void SubSet(int cnt, int totalWeight, int picked, int[] weight) {
		if(picked==2) {
			if(totalWeight<=M) {	
				max = Math.max(max, totalWeight);
			}
			return;
		}
		if(cnt==N) {
			if(picked==2) {
				if(totalWeight<=M) {
					max = Math.max(max, totalWeight);
				}
			}
			return;
		}
		SubSet(cnt+1, totalWeight+weight[cnt], picked+1, weight);
		SubSet(cnt+1, totalWeight, picked, weight);
	}
}