package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/** Main_백준_15686_치킨배달_골드5_시간초과*/
public class Main_백준_15686_치킨배달_골드5_228ms {
	
	private static class Node{
		public int row;
		public int col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static List<Node> houses = new ArrayList<>();
	private static List<Node> chickens = new ArrayList<>();
	private static boolean[] pickChicken;
	private static int[] houseDistance;
	private static int min;
	private static ArrayList<Integer>[] memoDistance;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/*
		 * NxN 도시가 있고
		 * 수익을 최대로 낼 수 있는 치킨집이 최대 M개가 있다
		 * 최대 M개의 치킨집을 골랐을 때 치킨 거리의 최솟값을 출력하라
		 * 
		 * 0은 빈칸
		 * 1은 집
		 * 2는 치킨집 
		 * 
		 * IDEA M개의 치킨집을 선택한 후
		 * 각 가구 기준 치킨 거리의 총합을 저장, 모든 조합을 살펴본 후 최솟값 출력
		 * 
		 * 1. 전체 치킨집 중 M개를 선택
		 * 2. 선택된 치킨집 기준 각 가구별 치킨 거리 저장
		 * 3. 모두 살펴본 후 총합 계산 후 최솟값 갱신
		 * 
		 * 메모이제이션 활용해야 함
		 * 치킨집 1을 선택했을 때의 치킨 거리 저장 .... 
		 * + 
		 * 
		 */
		
		// 지도 초기화
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num==1) {
					houses.add(new Node(i, j));
				}
				else if(num==2) {
					chickens.add(new Node(i, j));
				}
			}
		}
		
		int housesize = houses.size();
		int chickensize = chickens.size();
		// 여기서 먼저 모든 치킨 거리를 다 계산하자
		// 도시의 개수는 모르고, 치킨집의 개수는 최대 13개  --> 모든 가구들이 각 치킨집까지의 거리를 미리 계산
		memoDistance = new ArrayList[housesize];
		for(int i=0; i<housesize; i++) {
			memoDistance[i] = new ArrayList<Integer>(chickensize);
		}
		
		// 모든 거리 미리 합산
		for(int i=0; i<housesize; i++) {
			for(int j=0; j<chickensize; j++) {
				memoDistance[i].add(Math.abs(houses.get(i).row - chickens.get(j).row) + Math.abs(houses.get(i).col - chickens.get(j).col));
			}
		} // end of Memorization
		
		min = 1_000_000;
		pickChicken = new boolean[chickensize];
		SelectChickens(0, 0);
		
		System.out.println(min);
	} // end of main

	private static void SelectChickens(int picked, int start) {
		// M개를 뽑았을 때
		if(picked==M) {
			min = Math.min(min, ChickenDistance());
			return;
		}
		// start부터 조회해야 필요없는 조회를 하지 않는다
		for(int i=start; i<chickens.size(); i++) {
			// 치킨집 선택
			if(pickChicken[i]) continue;
			pickChicken[i] = true;
			SelectChickens(picked+1, i+1);
			// 치킨집 미선택
			pickChicken[i] = false;
		}
		
	} // end of SelcetChickens
	
	private static int ChickenDistance() {
		int housesize = houses.size();
		houseDistance = new int[housesize];
		Arrays.fill(houseDistance, 1_000_000);
		for(int i=0; i<chickens.size(); i++) {
			// 선택한 치킨집 
			if(pickChicken[i]) {
				for(int j=0; j<housesize; j++) {
					houseDistance[j] = Math.min(houseDistance[j], memoDistance[j].get(i));
				} // end of distance
			} // end of picked true
		} // end of for
		
		int total = 0;
		for(int i=0; i<housesize; i++) {
			total+=houseDistance[i];
		}
		return total;
	}
} // end of class 
