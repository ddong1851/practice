package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/** Main_����_15686_ġŲ���_���5_�ð��ʰ�*/
public class Main_����_15686_ġŲ���_���5_228ms {
	
	private static class Node{
		public int row;
		public int col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static List<Node> houses = new ArrayList<>();
	private static List<Node> chickens = new ArrayList<>();
	private static boolean[] pickChicken;
	private static int[] houseDistance;
	private static int min;
	private static ArrayList<Integer>[] memoDistance;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/*
		 * NxN ���ð� �ְ�
		 * ������ �ִ�� �� �� �ִ� ġŲ���� �ִ� M���� �ִ�
		 * �ִ� M���� ġŲ���� ����� �� ġŲ �Ÿ��� �ּڰ��� ����϶�
		 * 
		 * 0�� ��ĭ
		 * 1�� ��
		 * 2�� ġŲ�� 
		 * 
		 * IDEA M���� ġŲ���� ������ ��
		 * �� ���� ���� ġŲ �Ÿ��� ������ ����, ��� ������ ���캻 �� �ּڰ� ���
		 * 
		 * 1. ��ü ġŲ�� �� M���� ����
		 * 2. ���õ� ġŲ�� ���� �� ������ ġŲ �Ÿ� ����
		 * 3. ��� ���캻 �� ���� ��� �� �ּڰ� ����
		 * 
		 * �޸������̼� Ȱ���ؾ� ��
		 * ġŲ�� 1�� �������� ���� ġŲ �Ÿ� ���� .... 
		 * + 
		 * 
		 */
		
		// ���� �ʱ�ȭ
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num==1) {
					houses.add(new Node(i, j));
				}
				else if(num==2) {
					chickens.add(new Node(i, j));
				}
			}
		}
		
		int housesize = houses.size();
		int chickensize = chickens.size();
		// ���⼭ ���� ��� ġŲ �Ÿ��� �� �������
		// ������ ������ �𸣰�, ġŲ���� ������ �ִ� 13��  --> ��� �������� �� ġŲ�������� �Ÿ��� �̸� ���
		memoDistance = new ArrayList[housesize];
		for(int i=0; i<housesize; i++) {
			memoDistance[i] = new ArrayList<Integer>(chickensize);
		}
		
		// ��� �Ÿ� �̸� �ջ�
		for(int i=0; i<housesize; i++) {
			for(int j=0; j<chickensize; j++) {
				memoDistance[i].add(Math.abs(houses.get(i).row - chickens.get(j).row) + Math.abs(houses.get(i).col - chickens.get(j).col));
			}
		} // end of Memorization
		
		min = 1_000_000;
		pickChicken = new boolean[chickensize];
		SelectChickens(0, 0);
		
		System.out.println(min);
	} // end of main

	private static void SelectChickens(int picked, int start) {
		// M���� �̾��� ��
		if(picked==M) {
			min = Math.min(min, ChickenDistance());
			return;
		}
		// start���� ��ȸ�ؾ� �ʿ���� ��ȸ�� ���� �ʴ´�
		for(int i=start; i<chickens.size(); i++) {
			// ġŲ�� ����
			if(pickChicken[i]) continue;
			pickChicken[i] = true;
			SelectChickens(picked+1, i+1);
			// ġŲ�� �̼���
			pickChicken[i] = false;
		}
		
	} // end of SelcetChickens
	
	private static int ChickenDistance() {
		int housesize = houses.size();
		houseDistance = new int[housesize];
		Arrays.fill(houseDistance, 1_000_000);
		for(int i=0; i<chickens.size(); i++) {
			// ������ ġŲ�� 
			if(pickChicken[i]) {
				for(int j=0; j<housesize; j++) {
					houseDistance[j] = Math.min(houseDistance[j], memoDistance[j].get(i));
				} // end of distance
			} // end of picked true
		} // end of for
		
		int total = 0;
		for(int i=0; i<housesize; i++) {
			total+=houseDistance[i];
		}
		return total;
	}
} // end of class 
