package src.boj;

import java.io.*;
import java.util.*;

public class Main {
	
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
		 * 낚시왕이 가장 오른쪽 열의 오른쪽 칸에 도달하면 종료한다.
		 * 
		 * 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
		 * 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 가장 가까운 상어를 잡는다(row가 가장 작은 놈), 상어를 잡는다면 격자판에서 상아가 사라진다.
		 * 3. 상어가 이동한다. ( 이동은 한칸씩 말고, 한번의 연산으로(몫, 나머지 사용) )
		 * 4. 상어 이동 후 한 칸에 두 마리 이상의 상어가 있다면 크기가 가장 큰 상어가 나머지 상어를 모든 잡아 먹는다. (동일한 사이즈는 없다)   
		 * 
		 * 최종, 잡은 상어의 크기의 합을 출력한다.
		 * 
		 * 상어는 입력으로 주어진 속도로 이동하고, 상어가 배열의 범위를 벗어나려 하면 방향을 반대로 바꿔서 이동한다.
		 * 
		 * r, c, speed, direction, z(size)
		 * 
		 * 상어 큐는 우선순위큐를 사용하여 사이즈가 큰 상어부터 이동하자. (나중에 한 칸에 두마리 이상의 상어가 들어오는 경우 큰 상어가 선점하도록)
		 * 
		 * boolean 배열까지 쓰면 더 빠르긴 할거 같다.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] isShark = new boolean[C];
		PriorityQueue<Shark> sharks = new PriorityQueue<>();
		Queue<Shark> list = new LinkedList<>();
		
		int r, c, speed, direction, size;
		int[][] map = new int[R][C];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			speed = Integer.parseInt(st.nextToken());
			direction = Integer.parseInt(st.nextToken())-1;
			size = Integer.parseInt(st.nextToken());
			isShark[c] = true;
			sharks.offer(new Shark(r, c, speed, direction, size));
			map[r][c] = size;
		}
		
		R--;
		C--;
		int total = 0;
		int caught = 0;
		int next = 0;
		int[] mult = {-1, 1, 1, -1};
		
		// 낚시꾼 이동 
		for(int i=0; i<=C; i++) {
			// 1. 물고기를 잡는다.
			if(isShark[i]) {
				for(int row=0; row<=R; row++) {
					if(map[row][i]!=0) {
						caught = map[row][i];
						total+=caught;
						break;
					}
				} // end of for 
			} // end of if 
			
			// 상어 존재 배열을 초기화한다. 비트마스킹 쓰고싶다.. 
			for(int repC=0; repC<=C; repC++) {
				isShark[repC] = false;
				for(int repR=0; repR<=R; repR++) map[repR][repC] = 0;
			}
			
			// 2. 상어가 움직인다. (사이즈가 큰놈부터 움직인다)
			while(!sharks.isEmpty()) {
				Shark curr = sharks.poll();
				// 잡은 물고기가 아니라면 이동
				if(curr.size!=caught) {
					r = curr.r;
					c = curr.c;
					direction = curr.direction;
					speed = curr.speed;
					size = curr.size;
					// 상 하 우 좌
					if(direction/2==0) { 	// 상하
						next = r+speed*mult[direction];
						// 범위를 벗어난다면
						if(next<0 || next>R) {
							// 방향 변경 잘해야함.. 요기 체크
							if((next/R)%2==0) {
								if(direction==0) direction=1;
								else direction = 0;
							}
							// 바뀐 방향으로 나머지만큼 이동
							next %= R;
							next = Math.abs(next);
							if(mult[direction]<0) next = R-next;
						}
						if(map[next][c]==0) {
							list.offer(new Shark(next, c, speed, direction, size));
							map[next][c] = size;
							isShark[c] = true;
						}
					} // end of 상하
					else {					// 우좌
						next = c+speed*mult[direction];
						if(next<0 || next>C) {
							if((next/C)%2==0) {
								if(direction==2) direction=3;
								else direction=2;
							}
							next %= C;
							next = Math.abs(next);
							if(mult[direction]<0) next = C-next;
						}
						if(map[r][next]==0) {
							list.offer(new Shark(r, next, speed, direction, size));
							map[r][next] = size;
							isShark[next] = true;
						}
					} // end of 우좌
				} // end of if not caught
			} // end of for shark moving 
			
			// sharks 큐로 이동
			while(!list.isEmpty()) sharks.offer(list.poll());
			
		} // end of for 
		
		System.out.println(total);
		
	} // end of main 
	
} // end of Main 














