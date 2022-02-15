package src.jungol.figure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_¡§ø√_1828_≥√¿Â∞Ì_IM_106ms {
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] ing = new int[N][2];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			ing[i][0] = Integer.parseInt(st.nextToken());
			ing[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ing, (o1, o2)->{
			return o1[0]!=o2[0]?o1[0]-o2[0] : o1[1]-o2[1]; 
		});
		
		int refrigerater = 1;
		int max = ing[0][1];
		for(int i=1; i<N; i++) {
			int currmin = ing[i][0];
			int currmax = ing[i][1];
			if(max>=currmin) {
				if(max>currmax) {
					max = currmax;
				}
			}
			else {
				refrigerater++;
				max = currmax;
			}
		}
		
		System.out.println(refrigerater);
	}
}