package src.boj.djikstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** Main_����_1753_�ִܰ��_���5_760ms*/ 
public class Main_����_1753_�ִܰ��_���5_760ms {
	
	// ��� ����
	static ArrayList<Node>[] list;
	// �Ÿ� ����
	static int[] distance;
	private static int V;
	private static int E;
	// �ִ� �� V ���� ���� 300000 ���� �ִ� 10 -> 3000000
	static final int INF = 3_000_000;
	
	private static void go(int start) {
		// ���� �������� ����
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(start, 0));
		// ���ͽ�Ʈ�� ����
		while(!queue.isEmpty()) {
			// ���� Ž�� ���
			Node node = queue.poll();
			int currVer = node.V;
			int currW = node.weight;
			// �̹� ������ �Ǿ��ٸ� --> �̹� �湮�ѰŴϱ� + ���ݲ� �� ���� ���� �ƴ϶��
			if(distance[currVer] < currW) {
				continue;
			}
			// ���� ������ ����� ������
			for(int i=0; i<list[currVer].size(); i++) {
				int nextVer = list[currVer].get(i).V;
				// ���� �־������ ������ �����ϴ�
				int nextW = list[currVer].get(i).weight + currW;
				// ���� ��带 �湮���� �ʾҰ�, ���� �������� �Ÿ��� ���� ����� �Ÿ� + ���� �������� �Ÿ����� ū ��� ����
				// ���� �̸� �鸮�� �ʰ� �ȴٸ� INF �̻��� distance�� ����� ��
				if((distance[nextVer]> nextW)) {
					distance[nextVer] = nextW;
					queue.offer(new Node(nextVer, nextW));
				}
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// ���� ����
		int start = Integer.parseInt(br.readLine());
		
		// �迭 �ʱ�ȭ
		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		// ��� �߰�
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int vertax = Integer.parseInt(st.nextToken());
			int nextV = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// ���� �׷�����
			list[vertax].add(new Node(nextV, weight));
		}
		
		// �Ÿ� �迭 �ʱ�ȭ
		distance = new int[V+1];
		Arrays.fill(distance, INF);
		// ���� ���� -> ���� ���� = 0 + �湮 ó��
		distance[start] = 0;
		
		// ���� ������ ����� ��� �ִ� ��� ���
		go(start);
		// �ִ� ��ο� ���� ��� ó��
		for(int i=1; i<=V; i++) {
			if(distance[i] >= INF) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(distance[i]).append("\n");
			}
		}
		// ���� ���
		System.out.println(sb.toString());
		
	}
}

class Node implements Comparable<Node>{
	public int V;
	public int weight;
	public Node(int v, int distance) {
		super();
		V = v;
		this.weight = distance;
	}
	// ������������ �켱����
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
}
