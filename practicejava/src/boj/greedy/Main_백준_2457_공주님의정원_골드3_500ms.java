package src.boj.greedy;

import java.io.*;
import java.util.*;

/** Main_����_2457_���ִ�������_���3_500ms */
public class Main_����_2457_���ִ�������_���3_500ms {

	private static class Date implements Comparable<Date> {
		int month, day;

		public Date(int month, int day) {
			super();
			this.month = month;
			this.day = day;
		}

		// ��¥ �񱳸� ���� �޼���
		@Override
		public int compareTo(Date o) {
			if (this.month == o.month) {
				return this.day - o.day;
			}
			return this.month - o.month;
		}
	}

	private static class Flower implements Comparable<Flower> {
		Date start, end;

		public Flower(Date start, Date end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower o) {
			int comp = this.start.compareTo(o.start);
			if (comp == 0) {
				return o.end.compareTo(this.end);
			}
			return comp;
		}
	}

	public static void main(String[] args) throws Exception {

		/*
		 * 1. ���ְ� �����ϴ� ������ 3�� 1�Ϻ��� 11�� 30�ϱ��� ���� ���� �� ���� �̻� �Ǿ��־�� �Ѵ�. 2. ������ �ɴ� ���� ������
		 * �ּҰ� �Ǿ�� �Ѵ�.
		 * 
		 * IDEA 1. ��¥ ó���� ��F�� �ұ� �� �����͸� �� �ϼ� �����ͷ� ��ȯ? �� ��ƴ�.. 2. Date Ŭ������ ����غ���
		 * 
		 * ¥�� �׸���ϱ� ������ �ؾ� ��... � �������� �����ұ� ������ �������� ��������
		 * 
		 * 1. ������ Ÿ���� ��������. 1.1 ��¥ �񱳸� ���� Date Ŭ���� 1.2 ���� ������ ��� �ִ� Flower Ŭ����
		 * 
		 * ���� �� ���� ���� ������ ��¥�� ���� ���� ���� ��¥�� ��ġ�� �ʴ´ٸ� + �̶� ���ִ��� ���ϴ� ���� 1���� �������� �ʴ´ٸ� ���� (
		 * ���� )
		 * 
		 * Ʋ���� ��, �����Ͽ� ���� ��!!!
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Flower> flowers = new PriorityQueue<>();

		int sm, sd, em, ed;
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sm = Integer.parseInt(st.nextToken());
			sd = Integer.parseInt(st.nextToken());
			em = Integer.parseInt(st.nextToken());
			ed = Integer.parseInt(st.nextToken());
			// �ǹ� ���� ��������, 2�� ����, 12�� �����ϴ� �� ����
			if (em <= 2 || sm >= 12)
				continue;
			flowers.offer(new Flower(new Date(sm, sd), new Date(em, ed)));
		}

//		while(!flowers.isEmpty()) {
//			System.out.println(flowers.poll().toString());
//		}

		Date start = new Date(3, 1);
		Date end = new Date(11, 30);

		Flower curr = new Flower(new Date(1, 1), new Date(1, 1));
		Flower temp = new Flower(new Date(0, 0), new Date(0, 0));
		Flower update = new Flower(new Date(0, 0), new Date(0, 0));

		boolean flag = false;
		// 1. start �� ã��
		while (!flowers.isEmpty()) {
			if (flowers.peek().start.compareTo(start) > 0) {
				break;
			}
			// ó������ ���� �� ���� ( �� ���� ���� ���� ���� )
			temp = flowers.poll();
			if (temp.end.compareTo(curr.end) > 0) {
				curr = temp;
				flag = true;
			}
		}
		if (!flag)
			System.out.println(0);
		else {
			// �ϳ� ���� ������ ����
			int cnt = 1;
			flag = false;
			// ���� ó�� ���� ���� �ϳ� ���� ���� �� �ִ� ���̶�� ����
			if (curr.end.compareTo(end) > 0) System.out.println(cnt);
			else {
				while (true) {
					// �� ť�� ������� �ʰ�, ���� ���� ������ ������ �ɴ� ���̶�� Ž��
					while (!flowers.isEmpty() && curr.end.compareTo(flowers.peek().start) >= 0) {
						// Ž���� �� ����
						temp = flowers.poll();
						// ���� ���õ� ���� ������ ���ԵǸ鼭 �� ���� �Ⱓ ���� �� �ִ� ���̶�� ����
						if (curr.end.compareTo(temp.end) < 0) {
							// ���� �� �༮���� ������Ʈ
							if (update.end.compareTo(temp.end) < 0) {
								update = temp;
							}
							// ã�Ҵٴ� �ǹ��� flag 
							flag = true;
						}
					}
					// ������ ���� ã�� ���ߴٸ� ����
					if (!flag) break;
					// ���� �� ������ ����
					curr = update;
					cnt++;
					// ���� �ֱٿ� ���� ������ 11�� 30�ϱ��� Ű�� �� �ִ� ��� ����
					if (curr.end.compareTo(end) > 0) break;
					flag = false;
				} // end of while view flowers
				// �� �ɱ⿡ �������� �ʾҴٸ� cnt : 0
				System.out.println(flag ? cnt : 0);
			}
		}
	} // end of main
} // end of class

