package src.boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/** M*/
public class Main_백준_1012_유기농배추_실버2_192ms {
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
                    //諛곗텛 臾대━瑜� 諛쒓껄�븯硫� +1 
                    if(DFS(j, k)==true) result++;
                }
            }
            bw.write(result+"\n");
            result=0;                           //�븳踰� �룎怨� result 媛� 珥덇린�솕
        }
        br.close();
        bw.close();
    }
    
    static void init(){
        M = Integer.parseInt(st.nextToken());       //媛�濡쒓만�씠
        N = Integer.parseInt(st.nextToken());       //�꽭濡쒓만�씠
        K = Integer.parseInt(st.nextToken());       //諛곗텛�쓽 媛쒖닔
        cabbage = new int[M][N];                    //諛곗텛 諛곗뿴�쓽 珥덇린�솕
    }

    static void setData() throws IOException{
        //K媛쒖쓽 諛곗텛�쓽 �쐞移섎�� �엯�젰諛쏆븘 �빐�떦 諛곗뿴�쓽 媛믪쓣 1濡� �꽑�뼵
        for(int i=0; i<K; i++){
            st= new StringTokenizer(br.readLine());
            cabbage[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
    }

    static Boolean DFS(int x, int y){
        //x, y媛� 踰붿쐞瑜� 踰쀬뼱�궗�쓣 �븣
        if (x <= -1 || x >= M || y <= -1 || y >= N){
            return false;
        }
        if(cabbage[x][y]==1){   //�빐�떦 醫뚰몴�뿉 諛곗텛媛� 議댁옱�븯硫�
            cabbage[x][y]=0;    //諛⑸Ц 泥섎━
            DFS(x-1, y);        // �긽�븯醫뚯슦 �깘�깋
            DFS(x+1, y);
            DFS(x, y-1);
            DFS(x, y+1);
            return true;
        }
        //�쐞 2議곌굔�씠 �븘�땲硫� �븷珥덉뿉 諛곗텛媛� �엳�뒗 �옄由ш� �븘�떂
        return false;
    }

}
