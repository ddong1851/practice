package src.boj.sort;

import java.io.*;
import java.util.*;

public class Main_백준_1005_ACMCraft_골드3_1296ms {
    
    private static int N, M, W, a, b, node;
	public static void main(String[] args) throws Exception{
		
		/*
		 * 역순으로 가서 해당 레벨에서의 최대값으로 계속 더하는 방법도 좋을거 같다.
		 */
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        int TC = Integer.parseInt(br.readLine());
        for(int tc=0; tc<TC; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            int[] weight = new int[N+1];
            int[] indegree = new int[N+1];
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            list.add(new ArrayList<Integer>());
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                list.add(new ArrayList<Integer>());
                weight[i] = Integer.parseInt(st.nextToken());
            }
            
            // 위성정렬을 위한 초기화
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                indegree[b]++;
            }
            
            W = Integer.parseInt(br.readLine());
            // end of initialize
            
            Queue<Integer> q = new LinkedList<>();
            int[] result = new int[N+1];
            
            // 해당 노드에서의 최대값을 갱신
            for(int i=1; i<=N; i++) {
            	result[i] = weight[i];
            	if(indegree[i]==0) {
            		q.offer(i);
            	} // 시작 노드 추가
            } // find start nodes
            
            while(!q.isEmpty()) {
            	node = q.poll();
            	// 자식 노드 탐색
            	for(int n:list.get(node)) {
            		// 해당 노드까지의 최대값으로 계속 갱신.
            		result[n] = Math.max(result[n], result[node]+weight[n]);
            		if(--indegree[n]==0) {
            			q.offer(n);
            		} // end of if indegree is zero
            	} // end of for list
            } // end of while queue 
            
            // 목표 노드에서의 최대값이 정답
            sb.append(result[W]).append("\n"); 
            
        } // end of for test cases
                
        System.out.println(sb.toString());
        		
	} // end of main 
	
} // end of class 











