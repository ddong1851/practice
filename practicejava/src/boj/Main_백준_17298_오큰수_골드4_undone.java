package src.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 * Main_����_17298_��ū��_���4_
 * @author HD
 *
 */
//�ð� ���� 1��, 512MB, 
public class Main_����_17298_��ū��_���4_undone {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int [] NGE = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int i=0;
		
		//���� �迭�� �� �ִ´�.
		while(st.hasMoreTokens()) {
			NGE[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		br.close();
		
		i=0;
		while(true) {
			// ������ ������ ����, ���� ���� ����Ű�� ����
			int num = -1;
			int temp = NGE[i];			
			// ���� ��ȸ���� �������� ��, 
			for(int j=i+1; j<n; j++) {
				// ���� ����Ű�� �ִ� �������� 
				if(temp<NGE[j]) {
					num = NGE[j];
					break; // for�� Ż��
				} 
			}
			stack.push(num);
			if(i==n-1) {
				break;
			}
			i++;		// ���� ĭ ��ȸ
		} // end of while
		String str = stack.toString();
		System.out.println(str.substring(1, str.length()-1));
	} // end of main
} // end of class
