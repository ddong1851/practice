package src.boj.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_백준_7795_먹을것인가먹힐것인가_실버3_992ms
 * @author HD
 *
 */
public class Main_백준_7795_먹을것인가먹힐것인가_실버3_992ms {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int [] A;
	public static int [] B;
	
	public static void main(String[] args) throws IOException{
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			bw.write(solution()+"\n");
		}
		br.close();
		bw.close();
	}

	private static int solution() throws IOException{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());;
		
		A = new int[n];
		B = new int[m];
		
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		//비교대상인 B를 오름차순으로 정렬
		Arrays.sort(B);
		
//		for(int a:A) {
//			count += binarySearch(a, 0, m-1);
//		}
		
		forA:for(int a:A) {
			for(int b:B) {
				if(a>b) {
					count++;
				}
				// 시간 절약을 위한 
				else {
					continue forA;
				}
			}
		}
		
		return count;
	}

	
//	private static int binarySearch(int key, int low, int high) {
//		while(low<=high) {
//			int mid = (low+high)/2;
//			if(key == B[mid]) {
//				return mid;
//			}
//			else if(key < B[mid]) {
//				high = mid - 1;
//			}
//			else {
//				low = mid + 1;
//			}
//		}
//		
//		return low;
//	}

}
