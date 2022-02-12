package src.boj.implement;
import java.util.*;
import java.io.*;

public class Main_����_16927_�迭������2_���5_604ms {
	static int dy[] = {0,1,0,-1};		// ��, ��, ��, �� 
	static int dx[] = {1,0,-1,0}; 
    public static void main(String []args) throws IOException {      
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	int n = stoi(stk.nextToken());
    	int m = stoi(stk.nextToken());
    	int r = stoi(stk.nextToken());
    	int arr[][] = new int[n][m];
    	int sm = Math.min(n, m);
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++)
    			arr[i][j] = stoi(stk.nextToken());
    	}
    	
    	int i, j, d = 0, nr;
    	
		for(int idx = 0; idx < sm/2; idx++) {
			nr = r % ((n - idx * 2) * 2 + (m - idx * 2) * 2 - 4);		// ���Ӱ� �߰��� �ڵ�. �ش��ϴ� �׵θ��� ũ�⸦ modulo ���־�, �ݺ� Ƚ���� ���δ�.  
			
			while(nr-- != 0) {
				i = idx;
				j = idx;
				d = 0;
				int tmp = arr[i][j];
				
				while(d != 4) {
					if(i + dy[d] < idx || i + dy[d] >= n - idx  || j + dx[d] < idx || j + dx[d] >= m - idx) {
						d++;
						continue;
					}
					arr[i][j] = arr[i + dy[d]][j + dx[d]];
					i += dy[d];
					j += dx[d];
				}
				arr[idx + 1][idx] = tmp;
			}
    	}
		
    	StringBuilder sb = new StringBuilder();
    	for(int[] a : arr) {
    		for(int v : a) {
    			sb.append(v).append(" ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
    	br.close();
    }
    
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
    
}