package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_�ܹ��Ŵ��̾�Ʈ_D3_182ms {
	
	static int score[], calorie[];
	static boolean isSelected[];
	static int TC, N, L;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// ��͸� ���鼭 ���õ� ��Ḧ �߰��Ͽ��� �� Į�θ��� ������ L�� ���� �ʾҴٸ� ���� ���
		// ������ �Ѱų� cnt�� N�� �����Ͽ��� ��� ������ total ������ ����. ���� Math.max = ���� ū ���� ���
		TC = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=TC; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// ����� ����
			N = Integer.parseInt(st.nextToken());
			// ��Ằ Į�θ�
			L = Integer.parseInt(st.nextToken());
			// �迭 �ʰ�ȭ
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
	
	// �κ� �������� �ذ�
	private static void getScore(int cnt, int totalCal, int totalScore) {
		if(cnt==N) {
			// �� ����� Į�θ� ������ L�� ���� �ʴ´ٸ� ���� ����
			if(totalCal<=L) {
				max = Math.max(max, totalScore);
			}
			return;
		}
		// ��� ����
		isSelected[cnt] = true;
		getScore(cnt + 1, totalCal+calorie[cnt], totalScore+score[cnt]);
		// ��� ������
		isSelected[cnt] = false;
		getScore(cnt + 1, totalCal, totalScore);
	}
}	
