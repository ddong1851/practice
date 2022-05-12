package src.boj.sort;

import java.io.*;
import java.util.*;

public class Main_����_1005_ACMCraft_���3_1296ms {
    
    private static int N, M, W, a, b, node;
	public static void main(String[] args) throws Exception{
		
		/*
		 * �������� ���� �ش� ���������� �ִ밪���� ��� ���ϴ� ����� ������ ����.
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
            
            // ���������� ���� �ʱ�ȭ
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
            
            // �ش� ��忡���� �ִ밪�� ����
            for(int i=1; i<=N; i++) {
            	result[i] = weight[i];
            	if(indegree[i]==0) {
            		q.offer(i);
            	} // ���� ��� �߰�
            } // find start nodes
            
            while(!q.isEmpty()) {
            	node = q.poll();
            	// �ڽ� ��� Ž��
            	for(int n:list.get(node)) {
            		// �ش� �������� �ִ밪���� ��� ����.
            		result[n] = Math.max(result[n], result[node]+weight[n]);
            		if(--indegree[n]==0) {
            			q.offer(n);
            		} // end of if indegree is zero
            	} // end of for list
            } // end of while queue 
            
            // ��ǥ ��忡���� �ִ밪�� ����
            sb.append(result[W]).append("\n"); 
            
        } // end of for test cases
                
        System.out.println(sb.toString());
        		
	} // end of main 
	
} // end of class 











