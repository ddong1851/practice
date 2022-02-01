package src.boj.greedy;

import java.util.Arrays;
import java.util.Scanner;

/** Main_諛깆�_1339_�떒�뼱�닔�븰_怨⑤뱶4_212ms*/
// 諛깆� 1339 寃��깋�븯�뿬 �젙�떟 �솗�씤
/** 吏꾩쭨 �돩�슫 諛⑸쾿��! 媛� �떒�뼱? �뿉 �옄由щ퀎濡� 10^n�쓣 怨깊빐�꽌 �젣�씪 �겙嫄곕��꽣 9�쓽 媛믪쓣 遺��뿬�빐蹂대뒗 寃�*/
public class Main_백준_1339_단어수학_골드4_212ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �떒�뼱�쓽 媛쒖닔
		int n = sc.nextInt();
		// 26媛쒖쓽 �븣�뙆踰녹쓣 �떞�쓣 諛곗뿴
		int [] alpha = new int[26];
		// 臾몄옄�뿴�쓣 �떞�쓣 諛곗뿴
		String [] srr = new String[n];
		// �떒�뼱�뱾 �엯�젰
		for(int i=0; i<n; i++) {
			srr[i] = sc.next();
		}
		
		for(int i=0; i<n; i++) {
			int temp = (int)Math.pow(10, srr[i].length()-1);
			for(int j=0; j<srr[i].length(); j++) {
				// 臾몄옄�뿴�쓽 �빐�떦 �옄由욧컪�뿉 10�쓽 湲몄씠�듅留뚰겮 怨깊븳 寃껋쓣 �꽔�뒗�떎
				alpha[(int)(srr[i].charAt(j)-65)]+=temp;
				// �떎�쓬 �옄由우닔瑜� ���옣�븯湲� �쐞�빐 10�쓣 �굹�닠以��떎
				temp /= 10;
			}
		}
		// �뜲�씠�꽣 �젙�젹, �삤由� 李⑥닚�쑝濡� �젙�젹�맂�떎.
		Arrays.sort(alpha);
		// 怨깊븷 �씤�옄 珥덇린�솕
		int mult = 9;
		// �젙�떟�쓣 ���옣�븷 蹂��닔
		int result = 0;
		int size = alpha.length-1;
		for(int i=size; i>=0; i--) {
			// �븣�뙆踰녹� 26媛�, �슦由ш� ���옣�븳 媛믪� 理쒕� 10媛쒕땲源�, 踰붿쐞瑜� 踰쀬뼱�굹硫� �굹媛��씪�뒗 �쓽誘�
			if(alpha[i] == 0) {
				break;
			}
			// 踰붿쐞瑜� 踰쀬뼱�굹吏� �븡�븯�떎硫�, �젙�떟 蹂��닔�뿉 �빐�떦 �븣�뙆踰� 媛믪뿉 媛��뒫�븳 理쒕�媛믪쓣 怨깊븳 媛믪쓣 �뜑�빐以��떎.
			result += alpha[i]*mult--;
		}
		// �젙�떟 異쒕젰
		System.out.println(result);
		
	} // end of main
} // end of class
