package src.boj.math;

import java.io.*;
import java.util.*;

/** Main_백준_1708_블록껍질_플레5_*/
public class Main_백준_1708_블록껍질_플레5_1076ms {
	
	private static class Point{
		long x, y;
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	} // end of Point 
	
	private static class clockSort implements Comparator<Point>{
		Point first;
		public clockSort(Point first) {
			super();
			this.first = first;
		}
		public int compare(Point p1, Point p2) {
			long result = counterClockWise(first, p1, p2);
			if(result==0) {
				long dist1 = dist(first, p1);
				long dist2 = dist(first, p2);
				if(dist1 > dist2) return 1;
				return -1;
			} 
			return result>0?-1:1;
		}
	} // end of clockSort
	
	private static int counterClockWise(Point first, Point p1, Point p2) {
		double result = cross(vec(first, p1), vec(p1, p2)); // PA - AB 벡터가 반시계방향으로 돌고 있는지 확인
		if(result>0) return 1;			// 반시계 방향이다
		else if(result<0) return -1;	// 시계방향이다
		return 0;
	} // end of CCW
	
	private static long cross(Point a, Point b) {
		return a.x*b.y-a.y*b.x;
	} // end of cross 맨하튼 거리 계산 
	
	private static Point vec(Point a, Point b) {
		long x = b.x-a.x;
		long y = b.y-a.y;
		return new Point(x, y);
	} // end of vector AB 벡터를 구하는 식
	
	private static long dist(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	} // end of distance
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> points = new ArrayList<>();
		Stack<Point> hull = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			points.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		}
		// 1. 가장 아래 좌표 지정
		points.sort((o1, o2)->{
			int re = Long.compare(o1.y, o2.y);
			if(re==0) return Long.compare(o1.x, o2.x);
			else return re;
		});
		// 2. 가장 아래 좌표 선택 후 반 시계방향 정렬
		Point first = points.remove(0);
		hull.push(first);
		points.sort(new clockSort(first));
		// 3. 1번째 2번째 스택에 추가
		hull.push(points.remove(0));
		// 4. 모든 좌표 탐색
		for(int i=0, size=N-2; i<size; i++) {
			Point b = points.get(i);
			while(hull.size()>=2) {
				// PA AB 벡터 확인을 위한 좌표를 빼내기
				Point a = hull.pop();
				Point p = hull.peek();
				// 반시계방향으로 진행중인지 확인
				int ccwValue = counterClockWise(p, a, b);
				// 반시계 방향이면 빼냈던 좌표를 다시 넣고, 아니라면 넣지 않음 
				if(ccwValue>0) {
					hull.push(a);
					break;
				} // end of if 
			} // end of while 
			hull.push(b);
		} // end of for 
		System.out.println(hull.size());
	} // end of main 
} // end of class 
