package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_김동률_117ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			// 입력 받으면서 처리할 수도 있다.
			int [][] graph = new int[n][n];
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int len=str.length(), j=0; j<len; j++) {
					graph[i][j] = str.charAt(j)-'0';
				}
			}
			int mid = n/2;
			int range = 0;
			int add = 0;
			int count = 0;
			for(int i=0; i<n; i++) {
				if(i<=mid) {
					range = mid-i;
					add = 2*i+1;
				}
				else {
					range = i - mid;
					add = n - (i-mid)*2;
				}
				for(int addRange = add+range, j=range; j<addRange; j++) {
					count += graph[i][j];
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	} 			
}				
