package src.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Solution_SWEA_1289_원재의메모리복구하기_D3_김동률_103ms*/
public class Solution_SWEA_1289_원재의메모리복구하기_D3_김동률_103ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int i=1; i<=TC; i++) {
			// 한줄을 읽고, 연속된 1, 연속된 0의 개수만큼 반복하자( 단 원 데이터는 다 00000 이다)
			// 연산처리를 진행하는 메서드
			String temp = br.readLine();
			sb.append(String.format("#%d %d\n", i, calc(temp)));
		}
		br.close();
		System.out.println(sb.toString());
	}

	private static int calc(String temp) {
		// TODO Auto-generated method stub
		int len = temp.length();
		// charAt으로 대처 가능
		char[] bit = temp.toCharArray();
		int count = 0;
		// bit[i] bit[i-1] 비교로 대처 가능, 하지만 꺼내는 연산으로 인해 효율이 떨어질 수 있다
		char flag = '0';
		// 첫번째 인자부터 1이면 전체를 1로 변환해야 함
		if(bit[0]=='1') {
			count++;
			flag = '1';
		}
		// 전체 길이만큼 반복
		for(int i=1; i<len; i++) {
			// 현재이 연속된 데이터인지 확인
			if(bit[i]==flag) {
				continue;
			}
			// 연속되지 않은 데이터면 증가
			else {
				flag = bit[i];
				count++;
			}
		}
		return count;
	}
}
