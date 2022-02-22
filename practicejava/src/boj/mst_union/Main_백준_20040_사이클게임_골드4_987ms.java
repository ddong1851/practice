package src.boj.mst_union;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_����_20040_����Ŭ����_���4_987ms*/
public class Main_����_20040_����Ŭ����_���4_987ms {
	
	private static int count = 0;
	private static int first = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// ���μ� ���� ����
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			// �� ��° �������� counting 
			count++;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// ù��° ����Ŭ�� �ȳ����� ���� �ݺ�
			if(first==0) {
				union(a, b, p);
			}
		}
		System.out.println(first);
	} // end of main
	
	// ������ �θ� ã��
	private static int findSet(int a, int[] p) {
		if(a==p[a]) return a;
		else return p[a] = findSet(p[a], p);
	}

	// ��ġ��
	private static void union(int a, int b, int[] p) {
		// TODO Auto-generated method stub
		int aroot = findSet(a, p);
		int broot = findSet(b, p);
		// �θ� ���� �� 
		if(aroot==broot) {
			// ù ����Ŭ�� �߰����� ������ ��
			if(first==0) {
				// ù ����Ŭ�� �� ��° ���꿡�� ���Դ� ����
				first = count;
			}
			return;
		}
		// �θ� �ٸ� ��
		p[broot] = aroot;
	}
} // end of class
