package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

/** Main_諛깆�_11279_理쒕��옓_�떎踰�2_356ms*/
public class Main_백준_11279_최대힙_실버2_356ms {
	public static void main(String[] args) throws IOException{
		// 理쒕��옓�쑝濡� 援ы쁽
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			switch (num) {
			case 0:
				if(pq.isEmpty()) {
					bw.write(0+"\n");
				}
				else {
					bw.write(pq.poll()+"\n");
				}
				break;
			default:
				pq.offer(num);
				break;
			}
		}
		
		br.close();
		bw.close();
	}
}	
