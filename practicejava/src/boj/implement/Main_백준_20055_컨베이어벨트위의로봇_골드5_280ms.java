package src.boj.implement;

import java.io.*;
import java.util.*;

/** Main_����_20055_�����̾Ʈ���Ƿκ�_���5_280ms*/
public class Main_����_20055_�����̾Ʈ���Ƿκ�_���5_280ms {
	
	private static class Box{
		int durability;
		boolean robot;
		public Box(int durability, boolean robot) {
			super();
			this.durability = durability;
			this.robot = robot;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		/*
		 * �����̾� ��Ʈ�� �� �ϸ��� ��ĭ�� ȸ���Ѵ�
		 * �κ��� �����̾� ��Ʈ �� �ø��� ��ġ�� �ø� �� ������
		 * �κ��� �ø��ų�, �κ��� �̵��� �� �ش� ĭ�� �������� 1�� �����Ѵ�
		 * ���� ����
		 * 1. ��Ʈ�� �� ĭ ���� �ִ� �κ���� �Բ� ȸ��
		 * 2. ���� ���� ��Ʈ�� �ö� �κ�����, ��Ʈ�� ȸ���ϴ� �������� �̵��� �� �ִٸ� �̵�
		 * 3. ȸ�� �� �̵� �� ù��° ĭ�� �������� 0�� �ƴ϶�� �κ��� �ø���
		 * 4. �������� 0�� ĭ�� ������ ī����, K�� �̻��̸� ���� ����
		 * 
		 * -> ������ ī���� ������ �������� ���
		 * do while? 
		 * ����ĭ, ����ĭ�� Ȯ���ؾ� �ϴ�, index�� ���
		 */
		
		// 0~N-1 �ø��� ĭ, N~2N-1 ������ ĭ
		st = new StringTokenizer(br.readLine());
		Box[] box = new Box[N*2];
		for(int i=0, len=2*N; i<len; i++) {
			box[i] = new Box(Integer.parseInt(st.nextToken()), false);
		}
		
		int cnt = 0;
		int turn = 0;
		do {
			// 1. rotateBelt
			int temp = box[N*2-1].durability;
			for(int start=N*2-1, i=start; i>0; i--) {
				box[i].durability = box[i-1].durability;
				if(i<N) box[i].robot = box[i-1].robot;
				else box[i].robot = false;
			}
			box[0].durability = temp;
			box[0].robot = false;
			
			// 2. moveRobot
			// �ø��� ĭ ���� �ִ� �κ��� ������
			box[N-1].robot = false;
			for(int start=N-2, i=start; i>=0; i--) {
				// ���� ��ȸ�� ĭ�� �κ��� �ְ�, ����ĭ�� ��������� �������� 0�� ���� �� ����ĭ���� �̵�
				if(box[i].robot && 
						(!box[i+1].robot && box[i+1].durability>0)) {
					// ���� ĭ�� �κ��� ���ְ�
					box[i].robot=false;
					// ���� ĭ���� �κ��� �ű��
					box[i+1].robot=true;
					// �������� ���ߴµ�, �������� 0�� �ȴٸ� ������ 0�̵� ĭ ����
					if(--box[i+1].durability==0) cnt++;
				}
			}
			
			// 3. �ø��� ĭ ùĭ�� �κ��� �ø���
			if(box[0].durability>0) {
				box[0].robot = true;
				// ���� ĭ�� ������ üũ
				if(--box[0].durability==0) cnt++;
			}
			turn++;
		} while(cnt<K); // �������� 0�ΰ� K������ ���� ��쿡�� �ݺ�
		// �� �� �������� ���
		System.out.println(turn);
	}
}
