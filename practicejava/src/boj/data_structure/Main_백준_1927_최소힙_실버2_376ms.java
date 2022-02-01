package src.boj.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/** Main_諛깆�_1927_理쒖냼�옓_�떎踰�2_376ms*/
public class Main_백준_1927_최소힙_실버2_376ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); 理쒕��옓
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			switch(num) {
			case 0:
				if(pq.isEmpty()) {
					bw.write(0+"\n");
				}
				else {
					bw.write(pq.poll()+"\n");
				}
				break;
			default:
				// add瑜� �벐硫� �궡遺��쟻�쑝濡� offer瑜� �룎由곕떎. 洹몃깷 offer瑜� �벐�옄!
				pq.offer(num); 
				break;
			}
		}
		br.close();
		bw.close();
	}
}
