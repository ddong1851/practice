package src.boj.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_����_1946_���Ի��_�ǹ�1_3308ms*/
public class Main_����_1946_���Ի��_�ǹ�1_3308ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// �����ڵ��� ����� ������ �迭
		int [][] rank;
		int TC = Integer.parseInt(br.readLine());
		// TC ����ŭ �ݺ��Ѵ�
		for(int i=0; i<TC; i++) {
			// �ش� ���̽������� ������ ��
			int n = Integer.parseInt(br.readLine());
			// �������� �� �������� �迭 �ʱ�ȭ
			rank = new int[n][2];
			// �迭 �ʱ�ȭ
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				rank[j][0] = Integer.parseInt(st.nextToken());
				rank[j][1] = Integer.parseInt(st.nextToken());
			}
			// int�� �����͸� ��ȯ�Ͽ� SB�� ����
			bw.write(solution(rank)+"\n");
		}
		br.close();
		bw.close();
	}

	// ������ ���� �޼���
	private static int solution(int[][] rank) {
		// ù��° ���ڴ� ������ ä���. ���������� �չ�ȣ���� ������ �����ϱ�
		int hired = 1;
		// �迭 ������������ ����
		Arrays.sort(rank, (o1, o2)->{
			if(o1[0]==o2[0]) {
				return o1[1]-o2[1];
			}
			else {
				return o1[0]-o2[0];
			}
		});
		int min = rank[0][1];
		// rank[i][1]<min �� �����ؾ� �Ѵ�.
		for(int n=rank.length, i=1; i<n; i++) {
			if(min>rank[i][1]) {
				min = rank[i][1];
				hired++;
			}
		}
		return hired;
	}
}
