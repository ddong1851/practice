package src.boj.implement;

import java.io.*;
import java.util.*;

public class Main_����_17143_���ÿ�_���2_932ms {
	
	private static class Shark implements Comparable<Shark>{
		int r, c, speed, direction, size;
		public Shark(int r, int c, int speed, int direction, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return o.size-this.size;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		/*
		 * ���ÿ��� ���� ������ ���� ������ ĭ�� �����ϸ� �����Ѵ�.
		 * 
		 * 1. ���ÿ��� ���������� �� ĭ �̵��Ѵ�.
		 * 2. ���ÿ��� �ִ� ���� �ִ� ��� �߿��� ���� ���� ����� �� ��´�(row�� ���� ���� ��), �� ��´ٸ� �����ǿ��� ��ư� �������.
		 * 3. �� �̵��Ѵ�. ( �̵��� ��ĭ�� ����, �ѹ��� ��������(��, ������ ���) )
		 * 4. ��� �̵� �� �� ĭ�� �� ���� �̻��� �� �ִٸ� ũ�Ⱑ ���� ū �� ������ �� ��� ��� �Դ´�. (������ ������� ����)   
		 * 
		 * ����, ���� ����� ũ���� ���� ����Ѵ�.
		 * 
		 * ���� �Է����� �־��� �ӵ��� �̵��ϰ�, �� �迭�� ������ ����� �ϸ� ������ �ݴ�� �ٲ㼭 �̵��Ѵ�.
		 * 
		 * r, c, speed, direction, z(size)
		 * 
		 * ��� ť�� �켱����ť�� ����Ͽ� ����� ū ������ �̵�����. (���߿� �� ĭ�� �θ��� �̻��� �� ������ ��� ū �� �����ϵ���)
		 * 
		 * boolean �迭���� ���� �� ������ �Ұ� ����.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] isShark = new boolean[C];
		// �� ū�� ���� Ȯ��
		PriorityQueue<Shark> sharks = new PriorityQueue<>();
		Queue<Shark> list = new LinkedList<>();
		
		int r, c, speed, direction, size;
		int[][] map = new int[R][C];
		R--;
		C--;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			speed = Integer.parseInt(st.nextToken());
			direction = Integer.parseInt(st.nextToken())-1;
			if(direction<2) {
				speed = speed%(R*2);
			} else {
				speed = speed%(C*2);
			}
			size = Integer.parseInt(st.nextToken());
			isShark[c] = true;
			sharks.offer(new Shark(r, c, speed, direction, size));
			map[r][c] = size;
		}
		
		int total = 0;
		int caught = 0;
		int next = 0;
		int[] add = {-1, 1, 1, -1};
		
		// ���ò� �̵� 
		for(int i=0; i<=C; i++) {
			// 1. �� ��´�.
			if(isShark[i]) {
				for(int row=0; row<=R; row++) {
					if(map[row][i]!=0) {
						caught = map[row][i];
						total+=caught;
						break;
					}
				} // end of for 
			} // end of if 
			
			// ��� ���� �迭�� �ʱ�ȭ�Ѵ�. ��Ʈ����ŷ ����ʹ�.. 
			for(int repC=0; repC<=C; repC++) {
				isShark[repC] = false;
				for(int repR=0; repR<=R; repR++) map[repR][repC] = 0;
			}
			
			// 2. �� �����δ�. (����� ū����� �����δ�)
			while(!sharks.isEmpty()) {
				Shark curr = sharks.poll();
				// ���� ����Ⱑ �ƴ϶�� �̵�
				if(curr.size!=caught) {
					r = curr.r;
					c = curr.c;
					direction = curr.direction;
					speed = curr.speed;
					size = curr.size;
					// �� �� �� ��
					if(direction<2) {
						// �̷��� ��ĭ���� ���ϰ�, �����ؼ� �Ϸ��ߴµ�, �� �ȵǾ.. �����߽��ϴ�.
						for(int s=0; s<speed; s++) {
							next = r + add[direction];
							if(next<0 || next>R) {
								direction = (direction-1)*-1;
								next = r + add[direction];
							}
							r = next;
						}
						if(map[r][c]==0) {
							map[r][c] = size;
							isShark[c] = true;
							list.add(new Shark(r, c, speed, direction, size));
						}
					} else {
						for(int s=0; s<speed; s++) {
							next = c + add[direction];
							if(next<0 || next>C) {
								if(direction==2) direction=3;
								else direction=2;
								next = c + add[direction];
							}
							c = next;
						}
						if(map[r][c]==0) {
							map[r][c] = size;
							isShark[c] = true;
							list.add(new Shark(r, c, speed, direction, size));
						}
					}
				} // end of if not caught
				
			} // end of for shark moving 
			// sharks ť�� �̵�
			while(!list.isEmpty()) sharks.offer(list.poll());
			
		} // end of for 
		
		System.out.println(total);
		
	} // end of main 
	
} // end of Main 














