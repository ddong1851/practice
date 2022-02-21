package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_2527_���簢��_�ǹ�1_120ms{

	private static int minX;
	private static int maxX;
	private static int minY;
	private static int maxY;
	private static int width1;
	private static int height1;
	private static int width2;
	private static int height2;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		/*
		 * �ڿ� ���� ���� �� �ϳ��� x~p, y~q ���� �ȿ� ������ a ����
		 * ��ġ�ϴ� �κ��� �Ѱ���� b ���� 
		 * ��ġ�ϴ� �κ��� 2����� c ����
		 * �� 3���� ��� �������� ������ d ���� 
		 */
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			minX = Math.min(x1, x2);
			maxX = Math.max(p1, p2);
			minY = Math.min(y1, y2);
			maxY = Math.max(q1, q2);
			width1 = p1 - x1; 
			height1 = q1 - y1;
			width2 = p2 - x2; 
			height2 = q2 - y2; 
			
			sb.append(checkRange()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static char checkRange() {
		// TODO Auto-generated method stub
		if (((width1+width2 == maxX-minX) && (height1+height2 > maxY-minY)) || 
				((height1+height2 == maxY-minY) && (width1+width2 > maxX-minX)))
			return 'b';
		else if ((width1+width2 == maxX-minX) && (height1+height2 == maxY-minY)) 
			return 'c';
		else if ((width1+width2 < maxX-minX) || (height1+height2 < maxY-minY)) 
			return 'd';
		return 'a';
	}

}
