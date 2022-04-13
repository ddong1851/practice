package src.swea;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5604_������_D4_104ms {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		/*
		 * ������ ���ϴ� ����
		 * 8 12 �� �־����� 
		 * 8 + 9 + 1 + 0 + 1 + 1 + 1 + 2 = 23 �� ���. �̷������� �����ؾ� �Ѵ�.
		 * ���� �ִ� 10^15���� ���� �´� => long Ÿ�� ���
		 * ������ 10^15���ϸ� ������ ������
		 * 
		 * �ڸ�����ŭ modulo 10 ����
		 * 
		 * ���� ���� ������� �����ؾ� �Ѵ�.
		 * https://www.slideshare.net/Baekjoon/baekjoon-online-judge-1019
		 * https://tv.naver.com/v/22678458
		 * Ǯ�� ����
		 * 
		 * �ؼ�
		 * ���ڸ��� 0~9�� �����ϸ鼭 
		 * modulo 10�� �ݺ��ϸ� 0~9�� ��� ���Դ��� ī������ �Ѵ�.
		 * 
		 */
		
		long A, B, ans, rowCnt, mult;
		long[] nums = new long[10];
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			mult = 1;
			while(A<=B) {
				// A�� �� ���� 0���� ���߱� ���� �۾�
				for(; A%10!=0 && A<=B; A++) {
					parse(A, nums, mult);
				}
				// B�� �� ���� 9�� ���߱� ���� �۾�
				for(; B%10!=9 && A<=B; B--) {
					parse(B, nums, mult);
				}
				// ¥���� ó�� �� ������ ���������
				if(A>B) break;
				// 0~9������ row�� ó���Ѵ�. --> row�� ����ŭ �߰�
				A/=10;
				B/=10;
				rowCnt = B-A+1;
				for(int i=0; i<10; i++) {
					nums[i]+=rowCnt*mult;
				}
				mult*=10;
			} // end of while 
			
			// ���� ���, 0�� ���ϸ� 0�̴ϱ� ����
			ans = 0;
			for(int i=1; i<10; i++) {
				ans += i*nums[i];
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			Arrays.fill(nums, 0);
		}
		
		System.out.println(sb.toString());
		
	} // end of main 
	
	private static void parse(long x, long[] nums, long add) {
		while(x>0) {
			nums[(int)(x%10)]+=add;
			x/=10;
		}
	} // end of parse ( ¥���� ó�� ) 

} // end of class 











