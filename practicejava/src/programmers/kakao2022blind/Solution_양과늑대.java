package src.programmers.kakao2022blind;

import java.util.*;

public class Solution_������� {
	
	private static int max = 0;
	private static int[] infos;
	private static ArrayList<ArrayList<Integer>> nodes;
	
	public static int solution(int[] info, int[][] edges) {
		
		/*
		 * ������� �����߽��ϴ�,, 
		 * node�� �����, Ʈ���� ������ Ž���ϴ� ����� ��� �ؾ��ϳ�.. ����ϴٰ� �����ؼ�
		 * �����غ���, �湮 ������ ��带 �߰��ϴ� ������� �����ϴ��󱸿�
		 * 
		 * Node {
		 * Node parent 
		 * List <Node> child
		 * }
		 */
		
        int len = info.length;
        
        infos = info;
        
        // Tree node �ʱ�ȭ
        nodes = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<len; i++) nodes.add(new ArrayList<>());
        for(int[] edge: edges) {
        	nodes.get(edge[0]).add(edge[1]);
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        go(0, 0, 0, list); // (pointer, sheep, wolf, nextnode) vis[]
        
        return max;
    }

	private static void go(int pointer, int sheep, int wolf, List<Integer> next) {
		// ���� ��ġ������ ���� ������, �������� ���� ����
		if(infos[pointer]==0) sheep++;
		else wolf++;
		
		// �̶� ������ ������ �纸�� ���ų� ���� ��� return 
		if(wolf>=sheep) return;
		
		// ���� �ִ� ���� ����
		if(max<sheep) max = sheep;
		
		// ���� ��� �湮
		List<Integer> list = new ArrayList<>();
		list.addAll(next);
		// ���� ��ġ�� �����ʹ� ����
		list.remove(Integer.valueOf(pointer));
		// �ڳ� ��� �߰�
		for(int nxt: nodes.get(pointer)) {
			list.add(nxt);
		}
		
		// ���� ��� Ž��
		for(int nxt: list) {
			go(nxt, sheep, wolf, list);
		}
	}
	
	public static void main(String[] args) {
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		
		System.out.println(solution(info, edges));
	}
	
	
}
