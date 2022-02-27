package src.boj.mst_union;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_����_1976_���డ��_���4_192ms*/
public class Main_����_1976_���డ��_���4_192ms {
	private static int N;
	private static int M;
	private static int[] p;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // ������ ���� 1 <= N <= 200
		M = Integer.parseInt(br.readLine()); // ��ȹ�� ���� ���õ��� �� 1 <= M <= 1000
		
		// MakeSet
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		// ���� �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				int num = Integer.parseInt(st.nextToken());
				// ����Ǿ��ִٰ� �� �� ����
				if(num==1) {
					union(i, j);
				}
			}
		}
		
		// ���⼭ M�� ���ȴ�.
		st = new StringTokenizer(br.readLine());
		int curr = findSet(Integer.parseInt(st.nextToken()));
		while(st.hasMoreElements()) {
			if(curr!=findSet(Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		System.out.println("YES");
		
		
	}

	private static void union(int city1, int city2) {
		int root1 = findSet(city1);
		int root2 = findSet(city2);
		if(root1==root2) return;
		p[root2] = root1;
	}

	private static int findSet(int city) {
		// TODO Auto-generated method stub
		if(p[city] == city) return city;
		else return p[city] = findSet(p[city]);
	}
}
