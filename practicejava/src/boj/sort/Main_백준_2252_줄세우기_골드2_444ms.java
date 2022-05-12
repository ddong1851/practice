package src.boj.sort;

import java.io.*;
import java.util.*;

/** Main_����_2252_�ټ����_���2_444ms*/
public class Main_����_2252_�ټ����_���2_444ms {
    
    public static void main(String[] args) throws Exception{
    	
    	/*
    	 * ���⼺�� �ְ�, ����Ŭ�� ���� �׷������� 
    	 * �� �����, ��� �������� �����ϴ� �ִ� �ð�, ���� ������ �� ����� �� �ִ� �˰����̴�.
    	 * 
    	 * �ٽ� 
    	 * 1. ���� ����Ʈ 
    	 * 2. Indegree �迭. ����� �� �ִ� ����� ����ġ�� �ø��鼭, ���������� root�� ���� ���� ������ ã�� �� ����Ѵ�.
    	 * 3. ���� ������ ����ġ�� ���߸�, ����ġ�� 0�̵Ǹ� ������ ���� node�� �߰��Ѵ�.
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