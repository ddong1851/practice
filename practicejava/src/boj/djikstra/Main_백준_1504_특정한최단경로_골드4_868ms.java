package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// ���ͽ�Ʈ�� ����, DFS�� ��������� �湮 ó���� �Ÿ� �ջ��� �Լ� ������ �Ѵ�.
/** Main_����_1504_Ư�����ִܰ��_���4_868ms*/
public class Main_����_1504_Ư�����ִܰ��_���4_868ms {
	
	private static int N;
	private static int E;
	
	// ��ΰ� ���ٸ� -1
	private static int max = 200000000;
	static ArrayList<VE>[] list;
	static boolean visited[];
	static int[] distance;
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/*
		 * ù �ٿ� ������ ���� N�� ������ ���� E�� �־�����.
		 * 2���� ������ ������ �ִ� ����� ���̸� ����Ѵ�.
		 * 
		 * �湮�� ������ ������ 2���� �Ǿ��� �� ���̸� ��ȯ�ؾ� �ϴµ�
		 * �̶� ���̰� �ִ� ���̺��� ū��, �������� �����ؾ� �Ѵ�.
		 * + �޸������̼��� ���� � �������� �ٸ� ���������� �Ÿ��� �̸� �����صδ°� ����
		 * �� ������ DFS�� �����Ͽ� Ǫ�°� ���� �� ����.
		 * visited ó�� ���� DFS�� ���� �߰�, ���߰��� �غ���
		 */
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		// 1��1 ��Ī
		list = new ArrayList[N+1];
		distance = new int[N+1];
		// �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		// ������ ������ŭ �߰�
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int ver = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			// ��������� ����
			list[v].add(new VE(ver, edge));
			list[ver].add(new VE(v, edge));
		}
		
		st = new StringTokenizer(br.readLine());
		// �ݵ�� Ž���ؾ� �ϴ� 2���� ����
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		// �̷� ��쿡�� 1-> v1, v1->v2, v2->N �� �ִܰŸ��� ���� ���Ͽ� ���ؾ� �Ѵ�.
		int len1 = go(1, v1) + go(v1, v2) + go(v2, N);
		int len2 = go(1, v2) + go(v2, v1) + go(v1, N);
		// �ϳ��� �Ұ����� ��ΰ� �ִٸ� -1 ���
		int result = (len1 >= max && len2 >= max)?-1:Math.min(len1, len2);
		System.out.println(result);
	}

	// ����1 visited�� ������ �ǰ� �ִ�. --> 1-2-3-4���� min�� 7�� �ٲ���µ� 1-4�� ������ �� visited�� �ʱ�ȭ�� �ȵǾ� min�� 4�� �ٲ��.
	// 1�� ������ ����
	private static int go(int start, int end) {
		// ������Ʈ3 
		// �Ÿ��� �����ϴ� �迭�� �˰��� ���� ����
		distance = new int[N+1];
		Arrays.fill(distance, max);
		Arrays.fill(visited, false);
		distance[start] = 0;
		PriorityQueue<VE> queue = new PriorityQueue<VE>();
		// ���� ���� �߰�
		queue.offer(new VE(start, 0));
		
		while(!queue.isEmpty()) {
			VE node = queue.poll();
			int ver = node.V;
			int edge = node.E;
			// ���� ����ġ�� �� ũ�� �������� ����(�ּ� �Ÿ��� �����ҰŴϱ�)
			if(!visited[ver]) {
				visited[ver] = true;
			}
			for(int i=0; i<list[ver].size(); i++) {
				int nextver = list[ver].get(i).V;
				int nextedge = list[ver].get(i).E;
				// ���� �Ÿ��� �ִ� ��ζ�� �����Ѵ�. ( �湮 ���ߴٸ� ) 
				if(!visited[nextver] && distance[nextver] > distance[ver] + nextedge) {
					distance[nextver] = nextedge + distance[ver];
					queue.add(new VE(nextver, distance[nextver]));
				}
			} // end of for
		} // end of while
		// �ִ� ��θ� ��ȯ�Ѵ�.( ��ǥ�ϴ� ��ұ����� �ִܰ�ΰ� ���ٸ� MAX�� ��ȯ�Ѵ�) 
		return distance[end];
	}
}

class VE implements Comparable<VE>{
	public int V;
	public int E;
	public VE(int V, int E) {
		super();
		this.V = V;
		this.E = E;
	}
	@Override
	public int compareTo(VE o) {
		// TODO Auto-generated method stub
		return E - o.E;
	}
}

