package src.boj.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_2343_��Ÿ����_�ǹ�1_58�� {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// ���� ��
		int M = Integer.parseInt(st.nextToken());	// ��緹�� ��
		long max = 0;
		
		int[] lecture = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			lecture[i] = num;
			max += num;
		}
		
		long firstBlue = max/M;
		int cnt = 1;
		while(cnt!=M-1) {
			long blueray = firstBlue;
			for(int i=0; i<N; i++) {
				if(blueray-lecture[i]>=0) {
					blueray-=lecture[i];
				}
				else {
					blueray = firstBlue - lecture[i];
					cnt++;
				}
			}
			if(cnt>M) {
				firstBlue++;
				cnt=1;
			}
			else {
				firstBlue--;
				cnt=1;
			}
		}
		
		System.out.println(firstBlue);
	}
}

