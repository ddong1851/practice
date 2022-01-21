package src.boj;

import java.util.Scanner;
import java.util.StringTokenizer;

/**Main_백준_2615_오목_실버2_248ms*/
// 아래 계산식을 0이 아닌 다른 숫자를 만났을 때 int num = x 로 두고, 인자를 다 x 로 하면 절반으로 줄일 수 있다.
public class Main_백준_2615_오목_실버2_248ms {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int [][] omok = new int[21][21];
		
		
		// 오목판 초기화
		for(int i=1; i<20; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int j = 1;
			while(st.hasMoreTokens()) {
				omok[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false;

		F:for(int i=1; i<20; i++) {
//			4방 탐색을 진행할건데, 동, 동남, 남, 남서 순서로 조회하자.
			int [][] dxy = {{0, 1}, {1, 1}, {1, 0}, {1, -1}};			
			int direction = 0;	// 동부터 이동 지정		
			
			int count = 0;
			
			// 1,1 ~ 19,19 행부터 조회
			for(int j=1; j<20; j++) {
				// 방향 초기화
				direction = 0;
				if(omok[i][j]==0) continue;
				
				// 1일 때
				else if(omok[i][j]==1) {
//					다음 좌표
					int nx = i;
					int ny = j;
					
//					4방향 탐색
					while(direction<4) {
						
						nx += dxy[direction][0];
						ny += dxy[direction][1];
						
						// 범위를 벗어나거나 1이 아닌 경우
						if (nx > 20 || nx < 0 || ny > 20 || ny < 0 || omok[nx][ny]!=1) {
							if(count==4) {
								nx = i-dxy[direction][0];
								ny = j-dxy[direction][1];
								if(omok[nx][ny] != 1) {
									if(direction==3) {
										System.out.println("1");
										System.out.println((i+dxy[direction][0]*4)+" "+(j+dxy[direction][1]*4));
										flag = true;
										break F;
									}
									System.out.println("1");
									System.out.println(i+" "+j);
									flag = true;
									break F;
								}
							} // end od if
							nx = i;
							ny = j;
							direction++;
							count = 0;
							continue;
						} // end of if 
						
						// 1이 맞으면 해당 방향 한번 더
						else {
							++count;
						} // end of else
					} // end of while
				} // end of else if
				// 2일 때
				else if(omok[i][j]==2) {
					int nx = i;
					int ny = j;
					
//					4방향 탐색
					while(direction<4) {
						nx += dxy[direction][0];
						ny += dxy[direction][1];

						// 범위를 벗어나거나 2가 아닌 경우
						if(nx > 20 || nx < 0 || ny > 20 || ny < 0 || omok[nx][ny]!=2) {
							// 벗어난 시점에서 count가 4인 경우
							if(count==4) {
								nx = i-dxy[direction][0];
								ny = j-dxy[direction][1];
								if(omok[nx][ny] != 2) {
									if(direction==3) {
										System.out.println("2");
										System.out.println((i+dxy[direction][0]*4)+" "+(j+dxy[direction][1]*4));
										flag = true;
										break F;
									}
									System.out.println("2");
									System.out.println(i+" "+j);
									flag = true;
									break F;
								}
							} // end of if
							nx = i;
							ny = j;
							direction++;
							count=0;
							continue;
						} // end of if
						// 1이 맞으면 해당 방향 한번 더
						else {
							++count;
						} // end of else
					} // end of while
						
				} // end of else if
			} // end of for
				
		} // end of For
		
		if(flag==false) {
			System.out.println(0);
		}
	}	
			
}
