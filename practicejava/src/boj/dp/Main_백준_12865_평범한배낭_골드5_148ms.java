package src.boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/** Main_����_12865_����ѹ賶_���5_�ð��ʰ�*/
public class Main_����_12865_����ѹ賶_���5_148ms {
	

	private static int N;
	private static int K;
	private static int[][] items;
	private static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		items = new int[N+1][2];
		dp = new int[N+1][K+1]; // 0~K
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// ������ ���� ����
		for(int i=1; i<=N; i++) {
			// ��� ���� Ȯ��
			for(int w=1; w<=K; w++) {
				// ���� �������� ���԰� Ȯ���� ���Ժ��� ���̴ٸ� DP �迭 ���� ���� �����´�.
				if(items[i][0]>w) dp[i][w] = dp[i-1][w];
				// ���� ���� �״�� �������� vs ���� �������� ��ġ + �ش� �������� �߰��Ͽ� �߰��ϱ� ���� ���� ������ ��ġ���� �� 
				else dp[i][w] = Math.max(items[i][1] + dp[i-1][w-items[i][0]], dp[i-1][w]);
			}
		}
		
		System.out.println(dp[N][K]);
		
		
	} // end of main 
	
} // end of class 

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





