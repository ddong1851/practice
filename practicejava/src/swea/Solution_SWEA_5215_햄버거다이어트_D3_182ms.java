package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_182ms {
	
	static int score[], calorie[];
	static boolean isSelected[];
	static int TC, N, L;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 재귀를 돌면서 선택된 재료를 추가하였을 때 칼로리의 총합이 L은 넘지 않았다면 다음 재귀
		// 총합이 넘거나 cnt가 N에 도달하였을 경우 총합을 total 변수에 저장. 이후 Math.max = 가장 큰 값만 기억
		TC = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=TC; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 재료의 개수
			N = Integer.parseInt(st.nextToken());
			// 재료별 칼로리
			L = Integer.parseInt(st.nextToken());
			// 배열 초가화
			score = new int[N];
			calorie = new int[N];
			isSelected = new boolean[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			getScore(0, 0, 0);
			sb.append("#").append(testcase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 부분 집합으로 해결
	private static void getScore(int cnt, int totalCal, int totalScore) {
		if(cnt==N) {
			// 각 재로의 칼로리 총합이 L은 넘지 않는다면 점수 갱신
			if(totalCal<=L) {
				max = Math.max(max, totalScore);
			}
			return;
		}
		// 재료 포함
		isSelected[cnt] = true;
		getScore(cnt + 1, totalCal+calorie[cnt], totalScore+score[cnt]);
		// 재료 미포함
		isSelected[cnt] = false;
		getScore(cnt + 1, totalCal, totalScore);
	}
}	
