package src.boj.undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/** Main_����_1874_���ü���_�ǹ�3_380*/
public class Main_����_1874_���ü���_�ǹ�3_380ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		// 1���� �߰��� ����
		// in�� 1�� �θ� 1�� �Է����� �� EmptyStackException �߻�
		int in = 0;
		for(int i=0; i<n; i++) {
			// Ÿ���� ���� ����
			int target = Integer.parseInt(br.readLine());
			// ���� �߰��ؾ� �ϴ� ���
			if(target > in) {
				for(int j=in+1; j<=target; j++) {
					sb.append("+").append("\n");
					stack.push(j);
					in++;
				}
			}
			
			// stack�� �������� target�� ��ġ���� �ʴ� ���
			else if(stack.peek()!=target) {
				System.out.println("NO");
				// NO ����ϰ� �ٷ� Ż��
				System.exit(0);
			}
			
			// ������ �ϳ� ����, 4�� �ְ� �ٷ� �E �� �ְ� <--- �������� �����ٰ� �� 30�� ���Ⱦ��
			stack.pop();
			sb.append("-").append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
