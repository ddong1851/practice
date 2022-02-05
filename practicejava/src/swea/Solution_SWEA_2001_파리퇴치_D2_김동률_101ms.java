package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*SWEA 2001 D2 파리 퇴치*/
public class Solution_SWEA_2001_파리퇴치_D2_김동률_101ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 범위를 벗어나는 경우를 무시하도록 설계하자
			int [][] graph = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int count = 0;
			int range = N-M;
			for(int i=0; i<=range; i++) {
				for(int j=0; j<=range; j++) {
					// 이 지점을 기준으로 MxM 만큼의 좌표들의 합을 구하라 
					for(int ren = i+M, k=i; k<ren; k++) {
						for(int ren2 = j+M, l=j; l<ren2; l++) {
							count+=graph[k][l];
						}
					} // end of for MxM 
					max = Math.max(max, count);
					count = 0;
				} // end of for Cols
			} // end of for Rows
			sb.append("#").append(test).append(" ").append(max).append("\n");
		} // end of for outer
		
		System.out.println(sb.toString());
 	} // end of main
} // end of class
