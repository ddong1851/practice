package src.boj.math;
import java.io.*;
import java.util.*;

public class ConvexHull {
	private static class Point {
	    long x;
	    long y;
	    Point(long x, long y) {
	        this.x = x;
	        this.y = y;
	    }
		@Override
		public String toString() {
			return x+" "+y;
		}
	}
    static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (st.nextToken().equals("Y")) {   // Y인 것만 볼록 껍질
                points.add(new Point(x, y));
            }
        }
        
        Stack<Point> result = grahamScan(points);
        bw.write(result.size() + "\n");
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i).toString() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    
    static Stack<Point> grahamScan(ArrayList<Point> points) throws IOException {
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).x < root.x) {
                root = points.get(i);
            } else if (points.get(i).x == root.x) {
                if (points.get(i).y < root.y) {
                    root = points.get(i);
                }
            }
        }
        
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {    // return 1이면 자리를 바꾼다
                int result = ccw(root, p1, p2);
                if(result==0) {
                	long distance1 = dist(root, p1);
                    long distance2 = dist(root, p2);
                    if (distance1 > distance2) return 1;  
                }
                return result>0?-1:1;
            }
        });
        
        Stack<Point> stack = new Stack<>();
        stack.add(root);
        for (int i = 1; i < points.size(); i++) {
            while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) < 0)) {    // first, second, next
                stack.pop();    // second 빼기
            }
            stack.add(points.get(i));    // next 넣기
        }
        
        ArrayList<Point> extra_points = new ArrayList<>();
        for (int i = 1; i < points.size(); i++) {
            if (!stack.contains(points.get(i))) {
                extra_points.add(points.get(i));
            }
        }
        
        extra_points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                long distance1 = dist(root, o1);
                long distance2 = dist(root, o2);
                if (distance1 < distance2) return 1;
                return -1;
            }
        });
        stack.addAll(extra_points);
        return stack;
    }
    private static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        if (result > 0) return 1;
        else if (result < 0) return -1;
        return 0;
    }
    private static long dist(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
}











