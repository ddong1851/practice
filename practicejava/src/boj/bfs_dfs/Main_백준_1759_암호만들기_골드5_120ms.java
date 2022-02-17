package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_백준_1759_암호만들기_골드5_120ms*/
public class Main_백준_1759_암호만들기_골드5_120ms {
	private static int C;
	private static int L;
	private static boolean[] using; 
	private static StringBuilder sb = new StringBuilder();
	private static char[] letters;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		letters = new char[C];
		using = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		// 오름차순 정렬
		Arrays.sort(letters);
		
		makePassword(0, 0);
		
		System.out.println(sb.toString());
		
		
	} // end of main
	
	private static void makePassword(int start, int picked) {
		if(picked==L) {
			String password = makepassword();
			if(isSave(password)) sb.append(password).append("\n");
		}
		for(int i=start; i<C; i++) {
			using[i] = true;
			makePassword(i+1, picked+1);
			using[i] = false;
		}
		
	}
	
	private static String makepassword() {
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<C; i++) {
			if(using[i]) {
				builder.append(letters[i]);
			}
		}
		return builder.toString();
	}

	private static boolean isSave(String pass) {
		int aeiou = 0; 
		int rest = 0;
		for(int i=0; i<L; i++) {
			char temp = pass.charAt(i);
			if(temp=='a' || temp=='e' || temp=='i' || temp=='o' || temp=='u') {
				aeiou++;
			}
			else {
				rest++;
			}
		}
		if(aeiou>=1 && rest>=2) {
			return true;
		}
		return false;
	}
} // end of Main
