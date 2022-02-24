package src.boj.mst_union;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// �׳� Set�� ����ϸ� �ð� �ʰ��� ����. -> HashMap�� �Ẹ��
/** Main_����_4195_ģ����Ʈ��ũ_���2_980ms*/
public class Main_����_4195_ģ����Ʈ��ũ_���2_980ms {
	
	private static int index;
	private static int F;
	private static int[] p;
	private static int[] depths;
	private static HashMap<String, Integer> map;
	
	private static void union(String friend1, String friend2) {
		// map�� index-1�� �ڸ��� String �̸��� �ִ´� --> p[i] = i ����
		if(!map.containsKey(friend1)) {
			map.put(friend1, index++);
		}
		if(!map.containsKey(friend2)) {
			map.put(friend2, index++);
		}
		int root1 = findSet(map.get(friend1));
		int root2 = findSet(map.get(friend2));
		if(root1==root2) return;
		// head �ٲ��ֱ�
		p[root2] = root1;
//		map.put(friend2, root1); �ʿ��� �����ΰ�
		// ���� ����
		depths[root1] = depths[root1] + depths[root2];
		// depths �ʱ�ȭ, �ʿ��Ѱ�? ���� root2�� �ٽô� ������ ���� �ڸ�
//		depths[root2] = 1;
	}

	// �θ� ã���鼭 ����
	private static int findSet(Integer i) {
		if(p[i] == i) return p[i];
		return p[i] = findSet(p[i]);
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<TC; tc++) {
			// makeSet F�� �ִ� 100000�̴� ģ���� ���� �ִ� 200000�� �� �� ���� 1~200000���
			p = new int[200001];
			depths = new int[200001]; // �� �ڸ��� ���̸� ���� ( ��ǻ� rank�� ����ϴ� UnionFind ) ( Set.size�ϴϱ� �ð� �ʰ� )
			for(int i=1; i<200001; i++) {
				p[i] = i;
				depths[i] = 1;
			}
			// ���⿡ String �ִ��� Ȯ��
			map = new HashMap<String, Integer>();
			index = 1;
			StringTokenizer st;
			F = Integer.parseInt(br.readLine()); // ģ���� ��
			for(int i=0; i<F; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String friend1 = st.nextToken();
				String friend2 = st.nextToken();
				union(friend1, friend2);
				// ������ friend1�� root�� ���� �����̴�, �ش� ���̸� ���
				sb.append(depths[findSet(map.get(friend1))]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	} // end of main
	
} // end of class 

//1
//8
//a b
//b c
//d e
//e f
//g h
//h i
//a f
//c i
