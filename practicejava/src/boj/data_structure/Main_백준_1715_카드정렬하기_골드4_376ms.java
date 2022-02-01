package src.boj.data_structure;

import java.util.PriorityQueue;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

/**
 * Main_諛깆�_1715_移대뱶�젙�젹�븯湲�_怨⑤뱶4_376ms
 * �슦�꽑�닚�쐞 �걧瑜� �씠�슜�븯�뒗 臾몄젣, �븘�옒 2媛쒕�� �뜑�븯怨� �슦�꽑�닚�쐞 �걧�뿉 �슦�꽑�닚�쐞 湲곕컲�쑝濡� 異붽�, �씠瑜� �걹源뚯� 諛섎났�븯硫� �맂�떎.
 * �슦�꽑�닚�쐞�걧�뒗 �옓�쓣 �씠�슜�븯�뿬 援ы쁽�븯怨�, 理쒕� �옓 �삉�뒗 理쒖냼�옓�쑝濡� 援ы쁽�븯寃� �맂�떎.
 * �슦�꽑�닚�쐞�걧�뿉�꽌�뒗 �궡遺��쟻�쑝濡� �젙�젹�쓣 �빐二쇨린�븣臾몄뿉 �슦由щ뒗 �뜲�씠�꽣留� �궗�슜�븯硫� �맂�떎.
 * @author HD
 *
 */
public class Main_백준_1715_카드정렬하기_골드4_376ms {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int total = 0;
		while(true) {
			if(pq.size()!=1) {
				int sum = pq.poll()+pq.poll();
				total += sum;
				pq.offer(sum);
			}
			else {
				System.out.println(total);
				break;
			}
		}
		br.close();
//		bw.close();
	}
}	
