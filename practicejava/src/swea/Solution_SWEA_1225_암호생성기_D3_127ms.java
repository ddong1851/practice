package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_127ms {
	static int testcase = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			try {
				st = new StringTokenizer(br.readLine());				
				testcase = Integer.parseInt(st.nextToken());
			} catch(NoSuchElementException e) {
				break;
			}
			Queue<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			W: while(true) {
				for(int i=1; i<=5; i++) {
					int curr = q.poll()-i;
					if(curr<=0) {
						q.offer(0);
						break W;
					}
					q.offer(curr);
				}
			}
			sb.append("#").append(testcase).append(" ");
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		} // end of while testcases
		System.out.println(sb.toString());
	} // end of main
} // end of class