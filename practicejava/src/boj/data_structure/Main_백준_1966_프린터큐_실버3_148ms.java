package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ������ �� ����� ����Ϸ� ����
class PrinterQ implements Comparable<PrinterQ>{
	int idx;
	int rank;
	public PrinterQ(int idx, int rank) {
		super();
		this.idx = idx;
		this.rank = rank;
	}
	public int getIdx() {
		return idx;
	}
	public int getRank() {
		return rank;
	}
	// ��������
	@Override
	public int compareTo(PrinterQ o) {
		// TODO Auto-generated method stub
		if(this.rank > o.rank) {
			return -1;
		}
		else if(this.rank < o.rank) {
			return 1;
		}
		return 0;
	}
}

/** 1966 ������ť*/
public class Main_����_1966_������ť_�ǹ�3_148ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// ť�� �迭�� �������
		// ť���� �ε����� �����ϰ�
		// �迭�� ������ �������� �����Ͽ� ��������
		// �ε����� ���� ���� ���� ���� ���ΰ�? �� �����Ͽ� �ƴϸ� �� ������ �̵�
		
		int TC = Integer.parseInt(br.readLine());
		for(int testcase=0; testcase<TC; testcase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			
			Integer[] score = new Integer[n];
			Queue<Integer> q = new LinkedList<Integer>();
			Queue<Integer> result = new LinkedList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				q.offer(i);
			}
			// �������� ����
			Integer[] oriScore = score.clone();
			Arrays.sort(score, Collections.reverseOrder());
			
			int idx = 0;
			while(idx!=n) {
				// � �������� Ž������
				int curr = q.poll();
				if(oriScore[curr]<score[idx]) {
					q.offer(curr);
				}
				else if(oriScore[curr]==score[idx]) {
					result.offer(curr);
					idx++;
				}
			} // end of while
			
			int cnt = 1;
			while(result.peek()!=target) {
				result.poll();
				cnt++;
			}
			sb.append(cnt).append("\n");
		} // end of for
		
		System.out.println(sb.toString());
	} // end of main
} // end of class
