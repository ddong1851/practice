package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//class Node{
//   int row;
//   int col;
//   public Node(int row, int col) {
//      super();
//      this.row = row;
//      this.col = col;
//   }
//   public int getRow() {
//      return row;
//   }
//   public int getCol() {
//      return col;
//   }
//} // end of Node 


/** Main_백준_10026_적록색약_골드5_204ms*/
// DFS를 이용한 풀이, 시간 제한 1초, 적록색약인 사람과 아닌 사람이 봤을 때 구역의 수를 구한다
// (1 ≤ N ≤ 100)
public class Main_백준_10026_적록색약_골드5_204ms {
   /*
    * 목적
    * NxN 테이블에 R G B로 이루어진 영역들이 있는데
    * 해당 구역의 개수를 색약 없는 사람과 있는 사람의 기준에서 구한다
    */
   
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
      
      // 색약이 아닌 사람
      for(int i=0; i<2; i++) {
         // 방문 여부 초기화 
         visited = new boolean[N][N];
         int count=0;
         // 모든 좌표에 대해 탐색
         for(int j=0; j<N; j++) {
            for(int k=0; k<N; k++) {
               // 좌표별 탐색 후 영역의 개수를 count에 추가한다
               count+=BFS(color, new Node(j, k));
            }
         } // end of for 
         color = true;
         // 개수를 출력 버퍼에 추가
         bw.write(count+" ");
      } // end of for
      
      // 버퍼를 비우면서 출력
      br.close();
      bw.close();
   } // end of main

   // BFS를 통한 안전 구역 개수 반환
   private static int BFS(boolean color, Node node) {
      Stack<Node> stack = new Stack<>();
      
      // 이미 방문한 좌표라면 0을 반환하고 메서드에서 나간다
      if(visited[node.getRow()][node.getCol()]==true) {
         return 0;
      }
      
      // 방문하지 않은 지점이라면 해당 좌표를 stack에 추가 후 방문 처리
      stack.add(node);
      visited[node.getRow()][node.getCol()] = true;
      
      while (!stack.isEmpty()) {
		Node n = stack.pop();
		int r = n.getRow();
		int c = n.getCol();
		char rgb = graph[r][c];
		int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dxy[i][0];
			int nc = c + dxy[i][1];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			// 색약인 경우
			if (!color) {
				if (graph[nr][nc] != rgb) {
					continue;
				}
				if (graph[nr][nc] == rgb && visited[nr][nc] == false) {
					stack.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			} // end of if(!color)
				// 색약이 아닌 경우
			if (color) {
				// R G 인 경우
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
				// B 인 경우
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
		} // end of for(4방)
      } // end of while
      
      // 탐색을 통해 1을 반환하여 안전구역의 개수 ++
      return 1;
   } // end of BFS
} // end of class
