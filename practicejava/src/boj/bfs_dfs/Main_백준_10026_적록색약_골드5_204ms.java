package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;



public class Main_백준_10026_적록색약_골드5_204ms {
   
   static char[][] graph;
   static boolean [][] visited;
   static int N;
   
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      N = Integer.parseInt(br.readLine());
      graph = new char[N][N];
      
      for(int i=0; i<N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         String str = st.nextToken();
         for(int size = str.length(), j=0; j<size; j++) {
        	 graph[i][j] = str.charAt(j);
         }
      }
      boolean color = false;
      
      // ������ �ƴ� ���
      for(int i=0; i<2; i++) {
         // �湮 ���� �ʱ�ȭ 
         visited = new boolean[N][N];
         int count=0;
         // ��� ��ǥ�� ���� Ž��
         for(int j=0; j<N; j++) {
            for(int k=0; k<N; k++) {
               // ��ǥ�� Ž�� �� ������ ������ count�� �߰��Ѵ�
               count+=BFS(color, new Node(j, k));
            }
         } // end of for 
         color = true;
         // ������ ��� ���ۿ� �߰�
         bw.write(count+" ");
      } // end of for
      
      // ���۸� ���鼭 ���
      br.close();
      bw.close();
   } // end of main

   // BFS�� ���� ���� ���� ���� ��ȯ
   private static int BFS(boolean color, Node node) {
      Stack<Node> stack = new Stack<>();
      
      // �̹� �湮�� ��ǥ��� 0�� ��ȯ�ϰ� �޼��忡�� ������
      if(visited[node.getRow()][node.getCol()]==true) {
         return 0;
      }
      
      // �湮���� ���� �����̶�� �ش� ��ǥ�� stack�� �߰� �� �湮 ó��
      stack.add(node);
      visited[node.getRow()][node.getCol()] = true;
      
      while (!stack.isEmpty()) {
		Node n = stack.pop();
		int r = n.getRow();
		int c = n.getCol();
		char rgb = graph[r][c];
		int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// 4�� Ž��
		for (int i = 0; i < 4; i++) {
			int nr = r + dxy[i][0];
			int nc = c + dxy[i][1];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			// ������ ���
			if (!color) {
				if (graph[nr][nc] != rgb) {
					continue;
				}
				if (graph[nr][nc] == rgb && visited[nr][nc] == false) {
					stack.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			} // end of if(!color)
				// ������ �ƴ� ���
			if (color) {
				// R G �� ���
//           	   if(rgb=='R' || rgb=='G') 
				if (rgb != 'B') {
					if (graph[nr][nc] == 'B') {
						continue;
					}
				if (graph[nr][nc] != 'B' && visited[nr][nc] == false) {
						stack.add(new Node(nr, nc));
						visited[nr][nc] = true;
					}
					}
				// B �� ���
				else {
					if (graph[nr][nc] != 'B') {
						continue;
					}
					if (graph[nr][nc] == rgb && visited[nr][nc] == false) {
						stack.add(new Node(nr, nc));
						visited[nr][nc] = true;
					}
				}
			} // end of if(color)
		} // end of for(4��)
      } // end of while
      
      // Ž���� ���� 1�� ��ȯ�Ͽ� ���������� ���� ++
      return 1;
   } // end of BFS
} // end of class
