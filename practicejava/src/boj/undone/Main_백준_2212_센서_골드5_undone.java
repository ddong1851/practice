package src.boj.undone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

// ���İ� �׸��� �̿��� ���   
/**Main_����_2212_����_���5_  �ð� ���� 2��*/
public class Main_����_2212_����_���5_undone {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
    	
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        int [] sensors = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) sensors[i] = Integer.parseInt(st.nextToken());
        // ���� �迭�� ����
        Arrays.sort(sensors);

        
        //���� �迭�� �����
        Integer diffSensors[] = new Integer[N-1];
        for(int i=0; i<N-1; i++){
            diffSensors[i] = sensors[i+1] - sensors[i];
        } //  2 3 0 1 2
        
        
        
    }
}
