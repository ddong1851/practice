package src.boj.math;

import java.io.*;
import java.util.*;

public class Main_����_4105_��Ŭ����_�ǹ�2_348ms {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		double[][] points = new double[6][2];
		double area, L, R, T, t, X, Y, X4, Y4;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				points[i][0]=Double.parseDouble(st.nextToken());
				points[i][1]=Double.parseDouble(st.nextToken());
			}
			boolean isS=true;
			for (int i = 0; i < 6; i++) {
				if(points[i][0]==0.0 && points[i][1]==0.0){
					isS= isS && true;
				}else{
					isS= isS && false;
				}
			}
			if(isS) break;
			// 1. �ﰢ���� ���̸� ���Ѵ�
			area = 0.5*calc(points[3][0], points[3][1], points[4][0], points[4][1], points[5][0], points[5][1]);
			// 2. �ﰢ���� ���̿� ��ġ�ϴ� ����纯���� ��ǥ�� ���Ѵ�.
			// �ű��ߴ� �κ�, ���⸦ 1000�����ϸ� Ʋ��(�ð��ʰ�) �Ƹ� �Ѱ����� ��ģ ���� �������µ� �ð��� ���� �ɷ��� �׷� �� ����.
			L = -100000.0;
			R = 100000.0;
			t = (L+R)/2.0;
			while(true) {
				X = points[0][0]-t*(points[0][0]-points[2][0]);
				Y = points[0][1]-t*(points[0][1]-points[2][1]);
				T = calc(points[0][0], points[0][1], points[1][0], points[1][1], X, Y);
				if(Math.abs(area-T) <= 1.0E-7) break;
				if(area-T>0) L=t;
				else R=t;
				t=(L+R)/2.0;
			}
			// 3. GX GY HX HY ��ǥ�� ����Ѵ� ( �Ҽ��� 3�ڸ������� ) 
			X=points[0][0]-t*(points[0][0]-points[2][0]);
			Y=points[0][1]-t*(points[0][1]-points[2][1]);
			X4=X-points[0][0]+points[1][0];
			Y4=Y-points[0][1]+points[1][1];
			sb.append(String.format("%.3f %.3f %.3f %.3f\n", X4, Y4, X, Y));
		}
		
		System.out.println(sb.toString());
		
		
	} // end of main 

//	private static boolean isZero(double[][] points) {
//		for (int i = 0; i < 6; i++) {
//			if(points[i][0]!=0.0 || points[i][1]!=0.0) return false;
//		}
//		return true;
//	} // end of isZero
	
	private static double calc(double x1, double y1, double x2, double y2, double x3, double y3) {
		return Math.abs(x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3);
	} // end of calc
	
} // end of class 








