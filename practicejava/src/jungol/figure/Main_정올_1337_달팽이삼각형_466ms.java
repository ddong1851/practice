package src.jungol.figure;

import java.util.Arrays;
import java.util.Scanner;

/**Main_����_1337_�����̻ﰢ��_466ms */
public class Main_����_1337_�����̻ﰢ��_466ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n<=0 || n>=101) {
			System.exit(0);
		}
		sc.close();
		
		int [][] figure = new int[n][n];
		for(int[] f:figure) {
			Arrays.fill(f, -1);
		}
		// �迭�� -1�� �ʱ�ȭ
		
		//				  �밢	 ����		 ����
		int [][] dxy = {{1, 1},{0, -1},{-1, 0}};
		int nx = 0;
		int ny = 0;
		int num = 0;
		
		int direction = 0;
		int count = 0;
		while(true) {
			figure[ny][nx] = num++;
			ny += dxy[direction][0];
			nx += dxy[direction][1];
			
			while(figure[ny][nx]==-1){
				figure[ny][nx] = num++;
				ny += dxy[direction][0];
				nx += dxy[direction][1];
				if(num>9) num=0;
//				������ �����
				if(nx<count || nx>=n-count || ny<count || ny>=n-count) {
					ny -= dxy[direction][0];
					nx -= dxy[direction][1];
					direction++;
					ny += dxy[direction][0];
					nx += dxy[direction][1];
				}
			}
			// �� while������ �Ͽ��� �� ��ǥ�� 0, 0
			ny -= dxy[direction][0];
			nx -= dxy[direction][1];
			direction = 0;
			ny += dxy[direction][0];
			nx += dxy[direction][1];
			if(figure[ny][nx]!=-1) {
				break;
			}
			count++;
		}
		
		
		for(int[] i:figure) {
			for(int f:i) {
				if(f==-1) System.out.print("  ");
				else System.out.print(f+" ");
			}
			System.out.println();
		}
	}
}
