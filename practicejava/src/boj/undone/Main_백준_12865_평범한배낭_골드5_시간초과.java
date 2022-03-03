package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/** Main_����_12865_����ѹ賶_���5_�ð��ʰ�*/
public class Main_����_12865_����ѹ賶_���5_�ð��ʰ� {
	

	private static int N;
	private static int K;
	
	private static int[][] items;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// �κ������� �־��� ��� ( ����ġ�Ⱑ �ȵ� ��� 2^100 ����) --> DP�� �����ؾ� �Ѵ�.
		N = Integer.parseInt(st.nextToken()); // ��ǰ�� �� 1 <= N <= 100
		K = Integer.parseInt(st.nextToken()); // ���� �Ѱ� 1 <= K <= 100_000
		// ����, ��ġ�� ���� ( ���� ���� ��������, ���԰� ���ٸ� ��ġ ���� ��������
		items = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(items, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]!=o2[0]) return o1[0]-o2[0];
				else return o2[1] - o1[1];
			}
		});
		
		
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





