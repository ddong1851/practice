package src.programmers.kakao2022blind;

import java.util.*;

public class Solution_양과늑대 {
	
	private static int max = 0;
	private static int[] infos;
	private static ArrayList<ArrayList<Integer>> nodes;
	
	public static int solution(int[] info, int[][] edges) {
		
		/*
		 * 어려워서 참고했습니다,, 
		 * node를 만들고, 트리를 통으로 탐색하는 방법을 어떻게 해야하나.. 고민하다가 실패해서
		 * 참고해보니, 방문 가능한 노드를 추가하는 방식으로 구현하더라구요
		 * 
		 * Node {
		 * Node parent 
		 * List <Node> child
		 * }
		 */
		
        int len = info.length;
        
        infos = info;
        
        // Tree node 초기화
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
		// 현재 위치에서의 값이 양인지, 늑대인지 보고 증가
		if(infos[pointer]==0) sheep++;
		else wolf++;
		
		// 이때 늑대의 개수가 양보다 같거나 많은 경우 return 
		if(wolf>=sheep) return;
		
		// 양의 최대 개수 갱신
		if(max<sheep) max = sheep;
		
		// 다음 노드 방문
		List<Integer> list = new ArrayList<>();
		list.addAll(next);
		// 현재 위치의 포인터는 제거
		list.remove(Integer.valueOf(pointer));
		// 자녀 노드 추가
		for(int nxt: nodes.get(pointer)) {
			list.add(nxt);
		}
		
		// 다음 노드 탐색
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
