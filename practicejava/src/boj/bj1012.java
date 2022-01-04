package src.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] cabbage;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            init();
            setData();
            for(int j=0; j<M; j++){
                for(int k=0; k<N; k++){
                    //배추 무리를 발견하면 +1 
                    if(DFS(j, k)==true) result++;
                }
            }
            bw.write(result+"\n");
            result=0;                           //한번 돌고 result 값 초기화
        }
        br.close();
        bw.close();
    }
    
    static void init(){
        M = Integer.parseInt(st.nextToken());       //가로길이
        N = Integer.parseInt(st.nextToken());       //세로길이
        K = Integer.parseInt(st.nextToken());       //배추의 개수
        cabbage = new int[M][N];                    //배추 배열의 초기화
    }

    static void setData() throws IOException{
        //K개의 배추의 위치를 입력받아 해당 배열의 값을 1로 선언
        for(int i=0; i<K; i++){
            st= new StringTokenizer(br.readLine());
            cabbage[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
    }

    static Boolean DFS(int x, int y){
        //x, y가 범위를 벗어났을 때
        if (x <= -1 || x >= M || y <= -1 || y >= N){
            return false;
        }
        if(cabbage[x][y]==1){   //해당 좌표에 배추가 존재하면
            cabbage[x][y]=0;    //방문 처리
            DFS(x-1, y);        // 상하좌우 탐색
            DFS(x+1, y);
            DFS(x, y-1);
            DFS(x, y+1);
            return true;
        }
        //위 2조건이 아니면 애초에 배추가 있는 자리가 아님
        return false;
    }

}
