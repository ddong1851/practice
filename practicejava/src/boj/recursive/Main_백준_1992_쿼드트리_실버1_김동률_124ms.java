package src.boj.recursive;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_¹éÁØ_1992_ÄõµåÆ®¸®_½Ç¹ö1_±èµ¿·ü_124ms {
	
	private static int[][] map;
	private static StringBuilder sb;
	private static int N;
	private static int[] bin = {1,2,4,8,16,32,64};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		if(N==1) {
			sb.append("(").append(br.readLine()).append(")");
			System.exit(0);
		}
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<7; i++) {
			if(bin[i]==N) {
				N = i;
				break;
			}
		}
		
		makeQuadTree(0, 0, N);
		System.out.println(sb.toString());
		
	} // end of main

	// ÄõµåÆ®¸®¸¦ ¸¸µå´Â ¸Þ¼­µå
	private static void makeQuadTree(int r, int c, int n) {
		if(pressable(r, c, bin[n])) {
			sb.append(map[r][c]);
			return;
		}
		// 0ÀÏ ‹š Å»Ãâ
		if(n==0) {
			sb.append(map[r][c]);
			return;
		}
		sb.append("(");
		makeQuadTree(r, c, n-1);						// ÁÂ»ó
		makeQuadTree(r, c+bin[n-1], n-1);				// ¿ì»ó
		makeQuadTree(r+bin[n-1], c, n-1);				// ÁÂÇÏ
		makeQuadTree(r+bin[n-1], c+bin[n-1], n-1);		// ¿ìÇÏ
		sb.append(")");
		
	}
	
	
	private static boolean pressable(int row, int col, int size) {
		int point = map[row][col];
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(point!=map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
} // end of class 
