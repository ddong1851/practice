package src.boj.implement;

import java.io.*;
import java.util.*;


public class Main_拷層_14500_砺闘稽耕葛_茨球5_416ms {
	
	private static int N, M;
	
	// 3鯵梢 側 
	private static int[][][] dir = {
			{// 析切 
				{0, 1}, {0, 2}, {0, 3}, {1, 0}, {2, 0}, {3, 0}
			},
			{// 革乞 獣域号狽
				{0, 1}, {1, 1}, {1, 0}
			},
			{// ぁ乞丞, 延匝 捉精 匝 授生稽 掌 --. 
				{-1, 0}, {-2, 0}, {0, 1}, {0, 1}, {0, 2}, {1, 0}, {1, 0}, {2, 0}, {0, -1}, {0, -1}, {0, -2}, {-1, 0}
			},
			{// ぁ乞丞 鋼穿 
				{-1, 0}, {-2, 0}, {0, -1}, {0, 1}, {0, 2}, {-1, 0}, {1, 0}, {2, 0}, {0, 1}, {0, -1}, {0, -2}, {1, 0}
			},
			{// で 乞丞 で た ぬ っ
				{0, -1}, {0, 1}, {-1, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 0}, {0, -1}
			},
			{// ぁい 乞丞
				{-1, 0}, {-1, -1}, {-2, -1}, {0, 1}, {-1, 1}, {-1, 2}, {1, 0}, {1, 1}, {2, 1}, {0, -1}, {1, -1}, {1, -2}
			},
			{// ぁい 乞丞 鋼穿
				{-1, 0}, {-1, 1}, {-2, 1}, {0, 1}, {1, 1}, {1, 2}, {1, 0}, {1, -1}, {2, -1}, {0, -1}, {-1, -1}, {-1, -2}
			}
	};

	private static int[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/*
		 * 刃穿 貼事 庚薦? 虞壱 馬奄殖 亜稽 室稽税 紫戚綜亜 岨 滴延 馬陥.
		 * 益軍拭亀 災姥馬壱 刃穿 貼事聖 背醤拝 暗 旭精汽, 
		 * 
		 * 嬢彊廃 疎妊研 識澱馬壱, 
		 * 暗奄辞 督持鞠澗 乞窮 亜走呪拭 企背 域至 置企葵 端滴
		 * 
		 * 廃繊拭辞 BFS研 宜軒希虞亀 掻差聖 薦暗馬延 毘級牛
		 * DFS澗 亜管拝暗 旭精汽
		 * 戚澗 ったでぬ研 公娃陥.
		 * 
		 * 乞窮 繊拭 企背
		 * 1. DFS
		 * 2. で 乞丞 伊紫?
		 * 獣娃戚.. 吃猿
		 * 
		 * 壕伸聖 込嬢蟹澗 依聖 号走馬奄 是背 N+6 M+6生稽 幻級嬢辞 背左切
		 * 唖唖税 追戚什研 乞砧 督焦馬檎辞 置企葵聖 飴重馬切  ( 23鯵 追戚什? )
		 */
		
		map = new int[N+6][M+6];
		for(int i=3; i<N+3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=3; j<M+3; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int r=3; r<N+3; r++) {
			for(int c=3; c<M+3; c++) {
				max = Math.max(max, TetrisCount(r, c));
			}
		}
		System.out.println(max);
		
	} // end of main 

	
	// 廃 繊拭 企廃 乞窮 亜走呪 端滴
	private static int TetrisCount(int r, int c) {
		// TODO Auto-generated method stub
		int max = 0;
		int start = map[r][c];
		for(int i=0; i<7; i++) {
			int temp = 0;
			for(int j=0, rowsize=dir[i].length; j<rowsize; ) {
				temp = start + map[r+dir[i][j][0]][c+dir[i][j++][1]] + map[r+dir[i][j][0]][c+dir[i][j++][1]] 
						+ map[r+dir[i][j][0]][c+dir[i][j++][1]];
				if(max<temp) max = temp;
			}
		}
		return max;
	} // end of TetrisCount
	
} // end of class 












