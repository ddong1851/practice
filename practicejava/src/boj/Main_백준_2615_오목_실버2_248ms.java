package src.boj;

import java.util.Scanner;
import java.util.StringTokenizer;

/**Main_����_2615_����_�ǹ�2_248ms*/
// �Ʒ� ������ 0�� �ƴ� �ٸ� ���ڸ� ������ �� int num = x �� �ΰ�, ���ڸ� �� x �� �ϸ� �������� ���� �� �ִ�.
public class Main_����_2615_����_�ǹ�2_248ms {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int [][] omok = new int[21][21];
		
		
		// ������ �ʱ�ȭ
		for(int i=1; i<20; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int j = 1;
			while(st.hasMoreTokens()) {
				omok[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false;

		F:for(int i=1; i<20; i++) {
//			4�� Ž���� �����Ұǵ�, ��, ����, ��, ���� ������ ��ȸ����.
			int [][] dxy = {{0, 1}, {1, 1}, {1, 0}, {1, -1}};			
			int direction = 0;	// ������ �̵� ����		
			
			int count = 0;
			
			// 1,1 ~ 19,19 ����� ��ȸ
			for(int j=1; j<20; j++) {
				// ���� �ʱ�ȭ
				direction = 0;
				if(omok[i][j]==0) continue;
				
				// 1�� ��
				else if(omok[i][j]==1) {
//					���� ��ǥ
					int nx = i;
					int ny = j;
					
//					4���� Ž��
					while(direction<4) {
						
						nx += dxy[direction][0];
						ny += dxy[direction][1];
						
						// ������ ����ų� 1�� �ƴ� ���
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
						
						// 1�� ������ �ش� ���� �ѹ� ��
						else {
							++count;
						} // end of else
					} // end of while
				} // end of else if
				// 2�� ��
				else if(omok[i][j]==2) {
					int nx = i;
					int ny = j;
					
//					4���� Ž��
					while(direction<4) {
						nx += dxy[direction][0];
						ny += dxy[direction][1];

						// ������ ����ų� 2�� �ƴ� ���
						if(nx > 20 || nx < 0 || ny > 20 || ny < 0 || omok[nx][ny]!=2) {
							// ��� �������� count�� 4�� ���
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
						// 1�� ������ �ش� ���� �ѹ� ��
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
