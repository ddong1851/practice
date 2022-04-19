package src.boj.dp;

import java.io.*;
import java.util.*;

public class Main_����_2212_����_���5_132ms {
	
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// ������ ����
        int N = Integer.parseInt(br.readLine());
        // ���߱��� ����
        int K = Integer.parseInt(br.readLine());
        // ���� �ʱ�ȭ
        int[] sensors = new int[N];
        int[] diff = new int[N-1];
        
        // 1. ���� �����͸� �Է� �ް� ���� ���� �����Ѵ�.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		} 
        Arrays.sort(sensors);
        
        // 2. ���� ���̺��� ���� ���̺��� �����.
        for(int i=0; i<N-1; i++) {
        	diff[i] = sensors[i+1] - sensors[i];
        }
        Arrays.sort(diff);
        
        // ���� �� �ִ� ���߱��� K����, K-1�� ��ŭ�� ���̸� ���� �ʾƵ� ��. 
        // �������� ���� �ִ��� ���� ����� �ȴ�.
        int sum = 0;
        for(int i=0; i<N-1-(K-1); i++) { // ���̰� ª���ͺ��� ���ϴ� ������ŭ�� ��� 
        	sum += diff[i];
        }
        
        System.out.println(sum);
        
    } // end of main
    
} // end of class 
