package src.swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/** Solution_SWEA_1228_암호문1_D3_109ms*/
public class Solution_SWEA_1228_암호문1_D3_109ms {
	
	static int testcase=1;
	static int N;
	static List<String> password;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
			} catch(NoSuchElementException e) {
				break;
			}
			password = new LinkedList<String>();
			ListIterator<String> iter = password.listIterator();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				iter.add(st.nextToken());
			}
			int cmd = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<cmd; i++) {
				int idx = 0;
				int size = 0;
				if(st.nextToken().charAt(0)=='I') {
					idx = Integer.parseInt(st.nextToken());
					size = Integer.parseInt(st.nextToken());
				}
				if(iter.nextIndex()<idx) {
					while(iter.nextIndex()!=idx) {
						iter.next();
					}
				}
				else if(iter.nextIndex()>idx) {
					while(iter.nextIndex()!=idx) {
						iter.previous();
					}
				}
				for(int rep=0; rep<size; rep++) {
					iter.add(st.nextToken());
				}
			}
			while(iter.previousIndex()!=-1) {
				iter.previous();
			}
			sb.append("#").append(testcase++).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
			if(testcase==11) break;
		} // end of while
		System.out.println(sb.toString());
	}
}