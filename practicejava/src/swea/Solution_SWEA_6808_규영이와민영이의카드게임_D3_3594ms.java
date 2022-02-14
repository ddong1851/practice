package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Solution_SWEA_6808_규영이와민영이의카드게임_D3_3799ms*/
public class Solution_SWEA_6808_규영이와민영이의카드게임_D3_3594ms {
	
	/** 규영이의 카드*/
	private static int[] myCards;
	private static int wins;
	private static int loses;
	private static boolean[] isSelected;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		/*
		 * 1~18까지의 카드를 9장씩 나누고
		 * 9 라운드 끝에 승자를 가린다
		 * 더 높은 카드를 낸 사람은 본인 카드 값 + 상대방 카드값의 점수를 획득하고
		 * 진 사람은 아무 점수도 얻지 못한다. 
		 * 나중에 총점을 따져 총점이 더 높은 사람이 이기는거다 ( 무승부도 존재한다 ) 
		 * 
		 * 입력
		 * TC 수
		 * 각 케이스 별 9장의 카드 정보 ( 규영이가 내는 순서와 동일 ) 
		 * 조합인가 순열인가? 아무튼 완탐문제
		 * 민영이가 갖을 수 있는 모든 카드 조합에 대해 승패 체크 
		 * --> 민영이가 갖을 수 있는 모든 카드 조합을 만들자 -> 순열
		 */
		
		int TC = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=TC; testcase++) {
			
			/** 1대1 매칭*/
			myCards = new int[9];
			
			isSelected = new boolean[19];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				int card = Integer.parseInt(st.nextToken());
				myCards[i] = card;
				isSelected[card] = true;
			}
			
			wins = loses = 0;
			perm(0, 0, 0);
			
			sb.append("#").append(testcase).append(" ").append(wins).append(" ").append(loses).append("\n");
		}
		// 정답 출력
		System.out.println(sb.toString());
	}

	private static void perm(int cnt, int myTotal, int minTotal) {
		
		if(cnt==9) {
			if(myTotal>minTotal) {
				wins++;
			}
			else {
				loses++;
			}
			return;
		}
		// 모든 카드 탐색
		for(int i=1; i<=18; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			if( i> myCards[cnt]) {
				perm(cnt+1, myTotal, minTotal+i+myCards[cnt]);
			}
			else {
				perm(cnt+1, myTotal+i+myCards[cnt], minTotal);
			}
			isSelected[i] = false;
		}
	} // end of perm
}