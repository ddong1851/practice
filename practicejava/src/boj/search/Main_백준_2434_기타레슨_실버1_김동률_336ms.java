package src.boj.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_2434_��Ÿ����_�ǹ�1_�赿��_336ms {
	private static int N;
	private static int M;
	private static int[] lecture;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lecture = new int[N];
		
		int max = 0;
		int low = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			lecture[i] = num;
			max+=num;
			low = Math.max(low, num);
		}
		
		// ������ �̺� Ž������ �ؾ��ұ�? -> ��緹���� ũ�⸦ ������ mid�� �����ϰ� 
		// ������ mid�� ��� ���ұ� max/M? �̰ɷ��ߴµ� �ȵ���
		// �ִ밪�̶� max�� �غ���, �ִ밪�� ����ؾ� ��� ���Ǹ� ������ �����ϱ�
		// �ش� mid�� �� count�� �Ͽ� count�� M�̸� M�� �ƴ� ������ ����, 
		// count <= M �̸� high�� mid-1�� �����ϰ� �ٽ�
		// count >M �̸� low�� mid+1�� �����ϰ� �ٽ�
		
		int high = max;
		int mid = 0;
		while(low<=high) {
			mid = (low+high)/2;
			if(count(mid)) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		
		// ����� �ϴٺ��� low�� ���̳׿�..
		// ���� ������ �ٷ� �ּ� ������ M���� ����ϴ� ��緹�� ũ�� �� �ּҰ��� ���ϴ� �Ŷ� low�� ����ϴ°� ���ƿ�
		System.out.println(low);
	} // end of main
	
	private static boolean count(int mid) {
		int cnt = 1;
		int blueray = mid;
		for(int i=0; i<N; i++) {
			if(blueray-lecture[i]<0) {
				blueray = mid - lecture[i];
				cnt++;
			}
			else {
				blueray-=lecture[i];
			}
		}// end of for
		if(cnt<=M) {
			return true;
		}
		else {
			return false;
		}
	} // end of count
	
	
} // end of class
