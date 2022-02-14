package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Solution_SWEA_6808_�Կ��̿͹ο�����ī�����_D3_3799ms*/
public class Solution_SWEA_6808_�Կ��̿͹ο�����ī�����_D3_3594ms {
	
	/** �Կ����� ī��*/
	private static int[] myCards;
	private static int wins;
	private static int loses;
	private static boolean[] isSelected;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		/*
		 * 1~18������ ī�带 9�徿 ������
		 * 9 ���� ���� ���ڸ� ������
		 * �� ���� ī�带 �� ����� ���� ī�� �� + ���� ī�尪�� ������ ȹ���ϰ�
		 * �� ����� �ƹ� ������ ���� ���Ѵ�. 
		 * ���߿� ������ ���� ������ �� ���� ����� �̱�°Ŵ� ( ���ºε� �����Ѵ� ) 
		 * 
		 * �Է�
		 * TC ��
		 * �� ���̽� �� 9���� ī�� ���� ( �Կ��̰� ���� ������ ���� ) 
		 * �����ΰ� �����ΰ�? �ƹ�ư ��Ž����
		 * �ο��̰� ���� �� �ִ� ��� ī�� ���տ� ���� ���� üũ 
		 * --> �ο��̰� ���� �� �ִ� ��� ī�� ������ ������ -> ����
		 */
		
		int TC = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=TC; testcase++) {
			
			/** 1��1 ��Ī*/
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
		// ���� ���
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
		// ��� ī�� Ž��
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