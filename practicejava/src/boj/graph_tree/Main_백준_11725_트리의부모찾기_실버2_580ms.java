package src.boj.graph_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/** Main_����_11725_Ʈ���Ǻθ�ã��_�ǹ�2_580ms*/
public class Main_����_11725_Ʈ���Ǻθ�ã��_�ǹ�2_580ms {
	
	// ���� �迭
	private static int[] arr;
	// �迭�� ����
	private static int N;
	
	// ����� ������� (���ͽ�Ʈ�󿡼� �׻� ���� ���) 
	/* list[i]  ArrayList<Integer>
	 * Node1 -> ����� ����
	 * Node2 -> ����� ����
	 * ......
	 * �� ���� ������ �̷�� �ȴ�.
	 */
	private static ArrayList<Integer>[] list;

	// ����� �Ⱦ 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{

		
		/* 
		 * ����
		 * ��Ʈ�� ���� Ʈ���� �־�����.
		 * Ʈ���� ��Ʈ�� 1�̶�� �������� �� �� ����� �θ� ���ϴ� ���α׷��� �ۼ��ض�
		 * 
		 * IDEA
		 * 2��° Ʈ���̿����� ������ ������ �޸� �ϱ� ���� ���� �з��� �ôµ� �׷��� Ž���̿���,, �׷��� Ž������ 
		 * DFS�� ����ϴµ�, visited ���θ� ���� �迭 ���� ���η� �Ͽ���.
		 * 
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// �迭�� ���� �ʱ�ȭ
		N = Integer.parseInt(br.readLine());
		// ����� ���� ���� �ʱ�ȭ
		list = new ArrayList[N+1];
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
		}
		// �迭�� �����ϸ� �ڵ������� 0���� �ʱ�ȭ�Ǵ�, �Ʒ� ���ǿ��� ������ �߻��� �� �ִ�.
		arr[1] = -1;
		findParent(1);
		
		// ���� ���
		for(int i=2; i<=N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	} // end of main
	

	// �θ� ã�� �޼��� -> ���̿켱���� ��Ʈ ����� 1���� Ž���Ѵ�.
	private static void findParent(int start) {
		for(int i=0; i<list[start].size(); i++) {
			int child = list[start].get(i);
			// ���� �ʱ�ȭ���� �ʾҴٸ� -> �湮���� �ʾҴ� --> visited ���� Ȯ���� �ڵ����� �ȴ�.
			if(arr[child]==0) {
				// �ڽ��� �θ�� start�� �ʱ�ȭ
				arr[child] = start;
				findParent(child);
			}
		}
	}
} // end of Main
