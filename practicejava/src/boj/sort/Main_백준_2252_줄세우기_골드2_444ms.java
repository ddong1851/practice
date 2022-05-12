package src.boj.sort;

import java.io.*;
import java.util.*;

/** Main_백준_2252_줄세우기_골드2_444ms*/
public class Main_백준_2252_줄세우기_골드2_444ms {
    
    public static void main(String[] args) throws Exception{
    	
    	/*
    	 * 방향성이 있고, 사이클이 없는 그래프에서 
    	 * 줄 세우기, 어느 지점까지 도착하는 최단 시간, 등을 연산할 때 사용할 수 있는 알고리즘이다.
    	 * 
    	 * 핵심 
    	 * 1. 인접 리스트 
    	 * 2. Indegree 배열. 지목된 적 있는 노드의 가중치를 늘리면서, 최종적으로 root와 같은 시작 지점을 찾을 때 사용한다.
    	 * 3. 빼낼 때마다 가중치를 낮추며, 가중치가 0이되면 다음에 꺼낼 node로 추가한다.
    	 * 
    	 */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int[] indegree = new int[N+1];
        
        for(int i=0; i<=N; i++) list.add(new ArrayList<Integer>());
        
        int a, b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            indegree[b]++;
            list.get(a).add(b);
        } // end of initialize 
        
        // topologicalSort begin
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
            	q.offer(i);
            }
        } // end of find root
        
        int node = 0;
        while(!q.isEmpty()){
            node = q.poll();
            sb.append(node).append(" ");
            for(Integer next:list.get(node)){
                if(--indegree[next]==0){
                    q.offer(next);
                }
            }
        } // end of while not Empty
        
        System.out.println(sb.toString());
        
    } // end of main 
    
} // end of class