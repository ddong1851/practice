package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_����_12865_����ѹ賶_���5_�ð��ʰ�*/
public class Main_����_12865_����ѹ賶_���5_�ð��ʰ� {
	
	private static class Item implements Comparable<Item>{
		int w, value;
		public Item(int w, int value) {
			super();
			this.w = w;
			this.value = value;
		}
		// ��� ����ġ�� ���� ���� ������ ����
		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			if(this.w == o.w) {
				return o.value - this.value;
			}
			else {
				return this.w - o.w;
			}
		}
	}

	private static int total;
	private static int N;
	private static int K;
	private static Item[] items;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// �κ������� �־��� ��� ( ����ġ�Ⱑ �ȵ� ��� 2^100 ����) --> DP�� �����ؾ� �Ѵ�.
		N = Integer.parseInt(st.nextToken()); // ��ǰ�� �� 1 <= N <= 100
		K = Integer.parseInt(st.nextToken()); // ���� �Ѱ� 1 <= K <= 100_000
		
		items = new Item[N];
		
		// N���� ��ǰ�� ���� ������ �޴´�.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			items[i] = new Item(w, value);
		}
		
		Arrays.sort(items);
 		
		total = 0;
		
		go(0, 0, 0);
		// ���� ���
		System.out.println(total);
	} 
	
	private static void go(int weight, int value, int start) {
		if(start==N) {
			total = Math.max(total, value);
			return;
		}
		// ���� ��� �պ��� ���� �������� ��ġ�� �� ����, ������ ���԰� �Ѱ踦 �ʰ����� �ʴ´ٸ� ����
		if(items[start].value==0) go(weight, value, start+1);
		// ������ �ʿ䰡 ���� ���԰� ���´ٸ� ����
		else if(items[start].w > K) {
			total = Math.max(total, value);
			return;
		}
		// ���� ����
		else {
			if(weight+items[start].w <= K) go(weight+items[start].w, value+items[start].value, start+1);
			go(weight, value, start+1);
		}
	}
}
//10 999
//46 306
//60 311
//33 724
//18 342
//57 431
//49 288
//12 686
//89 389
//82 889
//16 289





