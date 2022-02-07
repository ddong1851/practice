package src.boj.data_structure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_¹éÁØ_2493_Å¾_°ñµå5_±èµ¿·ü_732ms {
	
	private static int N;
	private static int[] tower;
	private static int[] LBN;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		tower = new int[N+1];
		LBN = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		tower[0] = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		stack.push(1);
		LBN[0]=0;
		int idx = 2;
		while(idx < N+1) {
			if(tower[stack.peek()]<tower[idx]) {
				while(tower[stack.peek()]<tower[idx]) {
					stack.pop();
				}
				LBN[idx] = stack.peek();
				stack.push(idx);
			}
			else {
				LBN[idx] = stack.peek();
				stack.push(idx);
			}
			idx++;
		}
		
		for(int i=1; i<N+1; i++) {
			sb.append(LBN[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
}	
