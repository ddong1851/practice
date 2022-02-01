package src.boj.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Main_백준_1946_신입사원_실버1_3308ms*/
public class Main_백준_1946_신입사원_실버1_3308ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 지원자들의 등수를 저장할 배열
		int [][] rank;
		int TC = Integer.parseInt(br.readLine());
		// TC 수만큼 반복한다
		for(int i=0; i<TC; i++) {
			// 해당 케이스에서의 지원자 수
			int n = Integer.parseInt(br.readLine());
			// 지원자의 수 기준으로 배열 초기화
			rank = new int[n][2];
			// 배열 초기화
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				rank[j][0] = Integer.parseInt(st.nextToken());
				rank[j][1] = Integer.parseInt(st.nextToken());
			}
			// int형 데이터를 반환하여 SB에 저장
			bw.write(solution(rank)+"\n");
		}
		br.close();
		bw.close();
	}

	// 연산을 위한 메서드
	private static int solution(int[][] rank) {
		// 첫번째 인자는 무조건 채용됨. 나머지들의 앞번호보다 무조건 작으니까
		int hired = 1;
		// 배열 오름차순으로 정렬
		Arrays.sort(rank, (o1, o2)->{
			if(o1[0]==o2[0]) {
				return o1[1]-o2[1];
			}
			else {
				return o1[0]-o2[0];
			}
		});
		int min = rank[0][1];
		// rank[i][1]<min 을 만족해야 한다.
		for(int n=rank.length, i=1; i<n; i++) {
			if(min>rank[i][1]) {
				min = rank[i][1];
				hired++;
			}
		}
		return hired;
	}
}
