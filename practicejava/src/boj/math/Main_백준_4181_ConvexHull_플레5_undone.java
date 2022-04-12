package src.boj.math;

import java.io.*;
import java.util.*;

/** Main_백준_4181_ConvexHull_플레5_undone*/
public class Main_백준_4181_ConvexHull_플레5_undone {
	
	private static class Point{
		long x, y;
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x+" "+y;
		}
	} // end of Point
	
	private static class clockSort implements Comparator<Point>{
		Point P;
		public clockSort(Point p) {
			super();
			P = p;
		}
		@Override
		public int compare(Point a, Point b) {
			int re = counterClockWise(P, a, b);
			if(re==0) {
				long dist1 = distance(P, a);
				long dist2 = distance(P, b);
				if(dist1>dist2) return 1;
				return -1;
			} 
			return re>0?-1:1;
		}
	} // end of clockSort
	
	private static int counterClockWise(Point p, Point a, Point b) {
		long re = cross(vec(p, a), vec(a, b));
		if(re>0) return 1;			
		else if(re<0) return -1;	
		return 0;
	} // end of CCW 
	
	private static long cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	} // end of cross 
	
	private static Point vec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	} // end of vector 
	
	private static long distance(Point a, Point b){
		return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
	} // end of distance
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> points = new ArrayList<>();
		Stack<Point> hull = new Stack<>();
		
		long x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());
			if(st.nextToken().equals("Y")) points.add(new Point(x, y));
		} // end of for 
		points.sort((p1, p2)->{
			int re = Long.compare(p1.y, p2.y);
			if(re==0) return Long.compare(p1.x, p2.x);
			return re;
		});
		// 바닥 좌표 넣기
		Point P = points.remove(0);
		hull.push(P);
		// 바닥 좌표 기준 반시계 방향으로 정렬
		points.sort(new clockSort(P));
		hull.push(points.remove(0));
		
		// Graham Scan 
		for(int i=0; i<points.size(); i++) {
			while(hull.size()>=2 && counterClockWise(hull.get(hull.size()-2), hull.get(hull.size()-1), points.get(i))<0) {
				hull.pop();
			} // end of while 
			hull.push(points.get(i));
		} // end of for
		
		
		ArrayList<Point> extra_points = new ArrayList<>();
		for(int i=0; i<points.size(); i++) {
			if(!hull.contains(points.get(i))) extra_points.add(points.get(i));
		}
		
		extra_points.sort((o1, o2)-> {
			long dist1 = distance(P, o1);
			long dist2 = distance(P, o2);
			if(dist1<dist2) return 1;
			return -1;
		});
		
		hull.addAll(extra_points);
		
		StringBuilder sb = new StringBuilder();
		sb.append(hull.size()).append("\n");
		for(int i=0; i<hull.size(); i++) {
			sb.append(hull.get(i).toString()).append("\n");
		}
		
		System.out.print(sb.toString());
	} // end of main 
	
} // end of class 

//13
//0 7 Y
//0 -5 Y
//2 -3 Y
//1 3 N
//5 5 Y
//-4 4 Y
//3 6 Y
//-6 1 Y
//4 2 Y
//0 -3 N
//-3 -2 Y
//-1 3 N
//3 0 Y


//13
//0 7 
//0 -5 
//2 -3 
//1 3 
//5 5 
//-4 4 
//3 6 
//-6 1 
//4 2 
//0 -3 
//-3 -2 
//-1 3 
//3 0 



